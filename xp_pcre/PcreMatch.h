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

#pragma once

#include <string>
#include <vector>
#include "XpException.h"

class PcreMatch
{
public:
	// Constructor used for successful matches
	PcreMatch(const std::string& input, const std::vector<int>& ovector, int captureCount);

	// Constructor for failed matches
	PcreMatch() : m_success(false) { }

	void PcreMatch::Format(const std::string& format, std::string& result) const;
	std::string Format(const std::string& format) const;
	
	bool Success() const { return m_success; }
	int MatchStart() const
	{
		if (!m_success)
			throw XpException("Cannot call MatchStart() on failed match");

		return m_matchStart;
	}
	int MatchEnd() const
	{
		if (!m_success)
			throw XpException("Cannot call MatchStart() on failed match");

		return m_matchEnd;
	}
	
private:
	// Copy and assignment are not allowed
	PcreMatch(const PcreMatch&);
	PcreMatch& operator=(const PcreMatch&);

	void PcreMatch::AppendCapture(std::string& result, const std::string& captureNum) const;

	std::vector<std::string> m_captures;
	bool m_success;
	int m_matchStart;
	int m_matchEnd;
};
