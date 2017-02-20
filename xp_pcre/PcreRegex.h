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

#include <string>
#include <vector>
#include <boost/shared_ptr.hpp>
#include "PcreMatch.h"
#include "pcre.h"
#include "DebugStream.h"

#ifdef NDEBUG
#pragma comment(lib, "pcre5.lib")
#else
#pragma comment(lib, "pcre5_d.lib")
#endif

class PcreRegex
{
public:
	PcreRegex(const std::string& pattern, int flags=0);
	~PcreRegex()
	{
#ifndef NDEBUG
		DebugStream debug;
		debug << "~PcreRegex()" << std::endl;
#endif
		if (m_pcre)
		{
#ifndef NDEBUG
			debug << "Freeing m_pcre for " << m_pattern << std::endl;
#endif
			pcre_free(m_pcre);
		}
		if (m_pcreExtra)
		{
#ifndef NDEBUG
			debug << "Freeing m_pcreExtra for " << m_pattern << std::endl;
#endif
			pcre_free(m_pcreExtra);
		}
	}

	boost::shared_ptr<PcreMatch> Match(const std::string& input, int options=0, int startIndex=0) const;
	std::string Replace(const std::string& input, const std::string& replacement) const;
	boost::shared_ptr<std::vector<std::string> > Split(const std::string& input) const;
	int MatchCount(const std::string& input) const;

	std::string Pattern() const { return m_pattern; }

	bool operator == (const std::string &rhs) const
	{
		return m_pattern == rhs;
	}

	bool operator != (const std::string &rhs) const
	{
		return m_pattern != rhs;
	}

private:
	// no copy or assignment is allowed
	PcreRegex(const PcreRegex&);
	PcreRegex& operator=(const PcreRegex&);

	pcre *m_pcre;
	pcre_extra *m_pcreExtra;
	int m_ovectorSize;
	std::string m_pattern;
};
