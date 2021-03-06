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

#include <windows.h>

class CriticalSectionWrapper
{
public:
	explicit CriticalSectionWrapper(CRITICAL_SECTION& critSec) : m_pCritSec(critSec)
	{
		EnterCriticalSection(&m_pCritSec);
	}

	~CriticalSectionWrapper()
	{
		LeaveCriticalSection(&m_pCritSec);
	}

private:
	// There should be no copying allowed. This class is only used for RAII purposes.
	CriticalSectionWrapper(const CriticalSectionWrapper&);
	CriticalSectionWrapper& operator=(const CriticalSectionWrapper&);

	CRITICAL_SECTION& m_pCritSec;
};

