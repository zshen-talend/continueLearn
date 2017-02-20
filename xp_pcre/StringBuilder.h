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

#include <sstream>
#include <string>

class StringBuilder
{
public:
	StringBuilder() { }

	StringBuilder& operator<< (const char *t)
	{
		m_oss << t;
		return *this;
	}

	template<typename T>
	StringBuilder& operator<< (const T& t)
	{
		m_oss << t;
		return *this;
	}

	operator const char* () const
	{
		return m_oss.str().c_str();
	}

	operator const std::string () const
	{
		return m_oss.str();
	}

private:
	StringBuilder(const StringBuilder&);
	StringBuilder& operator=(const StringBuilder&);
	std::ostringstream m_oss;
};
