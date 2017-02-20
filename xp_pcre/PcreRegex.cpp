/*
xp_pcre. A Regular Expressions extended stored procedure for use with Microsoft SQL Server.
Copyright (C) 2005 Dan Farino (dan.farino@gmail.com)

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

#include "PcreRegex.h"
#include "DebugStream.h"
#include "StringBuilder.h"
#include "XpException.h"

using namespace std;
using namespace boost;

PcreRegex::PcreRegex(const string& pattern, const int flags) :
	m_pcre(NULL),
	m_pcreExtra(NULL),
	m_ovectorSize(0),
	m_pattern(pattern)
{
	const char *errptr = NULL;
	int erroffset = 0;

	m_pcre = pcre_compile(
		pattern.c_str(),
		flags,
		&errptr,
		&erroffset,
		NULL
		);

	if(!m_pcre)
	{
		throw XpException(
			StringBuilder()
			<< "pcre_compile() failed: "
			<< errptr
			<< " at character "
			<< erroffset
			);
	}

	// study the pattern
	m_pcreExtra = pcre_study(
		m_pcre,
		0,
		&errptr
		);

	if (NULL != errptr)
	{
		throw XpException(
			StringBuilder()
			<< "pcre_study() returned "
			<< errptr
			);
	}

	// calculate the number of capturing subpatterns this pattern has
	int count = 0;
	int result = pcre_fullinfo(m_pcre, NULL, PCRE_INFO_CAPTURECOUNT, &count);
	if(result == 0)
	{
		// the total number of captures is 1 + count (the "whole match" counts
		// as the first "capture". Multiply by 3 according to the PCRE docs
		// to get the expected size of the array
		m_ovectorSize = (count + 1) * 3;
	}
	else
	{
		throw XpException(
			StringBuilder()
			<< "pcre_fullinfo() returned "
			<< result
			);
	}
}

shared_ptr<PcreMatch> PcreRegex::Match(const string& input, const int options, const int startIndex) const
{
	const int inputLen = static_cast<int>(input.length());

	// Validate the startIndex
	// NOTE: startIndex > inputLen instead of >= because we'll allow matching
	// starting just past the last character of the string. This also allows
	// us to match empty strings
	if (startIndex < 0 || startIndex > inputLen)
		throw XpException(
			StringBuilder()
			<< "PcreRegex::Match(): startIndex=" 
			<< startIndex 
			<< " is out of range. input.length()="
			<< inputLen
			);

	vector<int> ovector(m_ovectorSize);

	// do the PCRE match
	const int captureCount = pcre_exec(
		m_pcre,
		m_pcreExtra,
		input.c_str(),
		inputLen,
		startIndex,
		options,
		&ovector[0],
		static_cast<int>(ovector.size())
		);

	shared_ptr<PcreMatch> match;
	if (captureCount == PCRE_ERROR_NOMATCH)
	{
		// The default constructor of PcreMatch is for failed matches
		match.reset(new PcreMatch);
	}
	else if (captureCount < 0)
	{
		throw XpException(
			StringBuilder()
			<< "pcre_exec() returned "
			<< captureCount
			);
	}
	else
	{
		match.reset(new PcreMatch(input, ovector, captureCount));
	}

	return match;
}

string PcreRegex::Replace(const string& input, const string& replacement) const
{
	string result;

	// we'll repeat until we can't match the string anymore
	int offset = 0;
	const int inputLen = static_cast<int>(input.length());

	// Note: The "<=" here is to support zero-width matches on empty strings (or at
	// the end of a non-empty string)
	while (offset <= inputLen)
	{
		shared_ptr<PcreMatch> match = Match(input, 0, offset);
		if (!match->Success())
			break;

		// empty matches are a special case
		if (match->MatchStart() == match->MatchEnd())
		{
			// just append the replacement followed by the original character (unless we're past the
			// end of the input string) at this position and bump along. This seems to emulate Perl 5.8.
			copy(replacement.begin(), replacement.end(), back_inserter(result));
			if (offset != inputLen)
				result.push_back(*(input.begin() + offset));
			++offset;
		}
		else
		{
			// We have a match. First, copy everything from the starting offset
			// until the start of the match
			copy(input.begin() + offset, input.begin() + match->MatchStart(), back_inserter(result));

			// Now, add the formatted match
			match->Format(replacement, result);

			offset = match->MatchEnd();
		}
	}

	// copy anything extra
	if (offset < inputLen)
		copy(input.begin() + offset, input.end(), back_inserter(result));

	return result;
}

int PcreRegex::MatchCount(const string& input) const
{
	int count = 0;
	int offset = 0;
	const int inputLen = static_cast<int>(input.length());

	while (offset < inputLen)
	{
		shared_ptr<PcreMatch> match = Match(input, 0, offset);
		if (!match->Success())
			break;

		++count;

		// empty matches are special cases
		if (match->MatchStart() == match->MatchEnd())
		{
			// manually bump the offset along
			++offset;
		}
		else
		{
			offset = match->MatchEnd();
		}
	}

	return count;
}

shared_ptr<vector<string> > PcreRegex::Split(const string& input) const
{
	shared_ptr<vector<string> > results(new vector<string>);

	// we'll repeat until we can't match anymore
	int offset = 0;
	const int inputLen = static_cast<int>(input.length());
	bool lastMatchBumped = false;

	// Perl 5.8 won't produce anything when splitting an empty string on a zero-width
	// match. We don't need to allow matching after the last character of the string.
	// (Hence "<" instead of "<=".)
	while (offset < inputLen)
	{
		shared_ptr<PcreMatch> match = Match(input, 0, offset);
		if (!match->Success())
			break;

		// empty matches are special cases
		if (match->MatchStart() == match->MatchEnd())
		{
			// try again with different options
			match = Match(input, PCRE_NOTEMPTY | PCRE_ANCHORED, offset);
			if (!match->Success())
			{
				// this seems to emulate Perl 5.8's behavior. We'll have this split
				// be just the single character we're skipping
				results->push_back(string(input.begin() + offset, input.begin() + offset + 1));

				// manually bump the offset along
				++offset;
				lastMatchBumped = true;
				continue;
			}
		}
		else
		{
			// everything up to the match start is part of the first half
			if (!lastMatchBumped)
				results->push_back(string(input.begin() + offset, input.begin() + match->MatchStart()));

			lastMatchBumped = false;
			offset = match->MatchEnd();
		}
	}

	// everything left is the last split
	if (offset < inputLen && !lastMatchBumped)
		results->push_back(string(input.begin() + offset, input.end()));

	return results;
}
