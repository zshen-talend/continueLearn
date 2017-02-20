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

#include "PcreMatch.h"
#include "StringBuilder.h"

using namespace std;

PcreMatch::PcreMatch(const string& input, const vector<int>& ovector, const int captureCount) :
	m_success(true),
	m_matchStart(ovector.at(0)),
	m_matchEnd(ovector.at(1))
{
	const int inputLen = static_cast<int>(input.length());

	for (int i = 0; i < captureCount; ++i)
	{
		const int start = ovector.at(i * 2);
		const int end = ovector.at(i * 2 + 1);

		// PCRE will return -1 for both start and end if a particular
		// subpattern didn't match.
		// Also, we'll only bother to extract the substrng if it contains at
		// least one character.
		if (start >= 0 && end >= 0 && end > start)
		{
			// validate the offsets
			if (start >= inputLen || end > inputLen)
				throw XpException(
					StringBuilder()
					<< "Capture offset returned by pcre_exec is too large. Capture number: "
					<< i
					<< ", start: "
					<< start
					<< ", end: "
					<< end
					);

			m_captures.push_back(string(input.begin() + start, input.begin() + end));
		}
		else
		{
			// this capture either didn't match or was empty
			m_captures.push_back(string());
		}
	}
}

string PcreMatch::Format(const string& format) const
{
	string result;

	Format(format, result);

	return result;
}

void PcreMatch::AppendCapture(string& result, const string& captureNum) const
{
	if (captureNum.empty())
		return;

	const int index = atoi(captureNum.c_str());

	// if the requested variable is out of range, we'll append nothing
	if (index < static_cast<int>(m_captures.size()))
	{
		// Copy that string from the vector of substrings
		const string& replacement = m_captures.at(index);
		copy(replacement.begin(), replacement.end(), back_inserter(result));
	}
}

void PcreMatch::Format(const string& format, string& result) const
{
	const char ESCAPE_CHAR = '\\';

	// after we see a $, we'll use this string to collect
	// all of the digits we see immediately following
	string captureNum;

	// store the end iterator since we'll be accessing it frequently
	const string::const_iterator formatEnd = format.end();

	// we won't do a for loop because we need to be able to do a "continue"
	// inside of the loop without incrementing the iterator
	string::const_iterator it = format.begin();
	while (it != formatEnd)
	{
		if (*it == ESCAPE_CHAR)
		{
			// we just saw the escape character
			// peek at the next character
			if (++it != formatEnd)
			{
				// the only things that need escaping are the $ and the escape character itself
				if (*it != ESCAPE_CHAR && *it != '$')
					throw XpException(
						StringBuilder()
						<< "Unrecognized escape sequence: "
						<< ESCAPE_CHAR
						<< *it
						);

				result.push_back(*it);
				++it;
			}
			else
			{
				// we're at the end of the string. Escape characters are not allowed at the end
				// of the format string
				throw XpException(
					StringBuilder()
					<< "The escape character \""
					<< ESCAPE_CHAR
					<< "\" cannot appear alone at the end of the string. Use \""
					<< ESCAPE_CHAR << ESCAPE_CHAR
					<< "\" instead."
					);
			}
		}
		else if (*it == '$')
		{
			// clear out this string so we can start collecting the digits following the $
			captureNum.clear();

			// we just saw a $, we need to peek at the next character
			++it;
			if (it == formatEnd)
			{
				// the $ is at the end of the string. Perl 5.8 doesn't allow this,
				// so we won't either
				throw XpException("$ at end of format string is not allowed.");
			}
			if (*it == '{')
			{
				// everything up until the next brace is the capture number
				for (++it; it != formatEnd && *it != '}'; ++it)
				{
					// only digits are allowed inside of braces
					if (!isdigit(*it))
						throw XpException("Only digits are allowed inside of ${} in the format string.");

					captureNum.push_back(*it);
				}

				if (it == formatEnd)
				{
					// we hit the end of the string without seeing the closing
					// brace. We'll throw an exception
					throw XpException("Couldn't find matching '}' (reached end of string).");
				}

				// increment so we don't end up processing the } again
				++it;
			}
			else
			{
				// the current character (the one immediately after the $) is
				// not a {. We need to take everything up until the next non-number
				// and use it as our capture number
				for(; it != formatEnd && isdigit(*it); ++it)
					captureNum.push_back(*it);
			}

			if (captureNum.empty())
				throw XpException("You must put at least one digit after a $ in the format string.");

			// now, append the capture
			AppendCapture(result, captureNum);
		}
		else
		{
			// not an escape or $. Just append the character literally
			result.push_back(*it);
			++it;
		}
	}
}
