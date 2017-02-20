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

#include <vector>
#include <string>
#include <srv.h>
#include "XpException.h"
#include "StringBuilder.h"

class OutputParameter
{
public:
	OutputParameter(SRV_PROC *pSrvProc, const int paramNum) :
		m_valueAssigned(false),
		m_pSrvProc(pSrvProc),
		m_paramNum(paramNum),
		m_maxLen(0)
	{
		// make sure we have an output parameter
		if (!(srv_paramstatus(pSrvProc, paramNum) & SRV_PARAMRETURN))
		{
			throw XpException(
				StringBuilder()
				<< "Parameter "
				<< paramNum
				<< " should be an output parameter."
				);
		}

		// get the data type and size of the OUTPUT parameter
		BYTE bType = 0;
		ULONG cbActualLen = 0;
		BOOL fNull = FALSE;
		if (srv_paraminfo(m_pSrvProc, m_paramNum, &bType, &m_maxLen, &cbActualLen, NULL, &fNull) != SUCCEED)
		{
			throw XpException(
				StringBuilder()
				<< "Error obtaining information on parameter "
				<< paramNum
				<< "."
				);
		}

		// make sure we have an ASCII character data type
		switch (bType)
		{
		case SRVBIGCHAR:
		case SRVBIGVARCHAR:
			break;
		default:
			throw XpException(
				StringBuilder()
				<< "Invalid data type on parameter "
				<< paramNum
				<< " (should be CHAR or VARCHAR)."
				);
		}
	}

	void SetNull()
	{
		if (srv_paramsetoutput(
			m_pSrvProc,
			m_paramNum,
			NULL,
			0,
			TRUE
			) != SUCCEED)
		{
			throw XpException("Error setting output parameter to NULL");
		}

		m_valueAssigned = true;
	}

	void SetValue(const std::string &value)
	{
		// make sure the output parameter can hold the data
		if (value.length() > m_maxLen)
		{
			throw XpException(
				StringBuilder()
				<< "Cannot set output parameter. Parameter needs to hold at least " 
				<< static_cast<int>(value.length())
				<< " characters"
				);
		}

		if (srv_paramsetoutput(
			m_pSrvProc,
			m_paramNum,
			reinterpret_cast<BYTE*>(const_cast<char*>(value.c_str())),
			static_cast<ULONG>(value.length()),
			FALSE
			) != SUCCEED)
		{
			throw XpException("Error setting output parameter");
		}

		m_valueAssigned = true;
	}

	bool ValueAssigned() const
	{
		return m_valueAssigned;
	}

private:
	int m_paramNum;
	bool m_valueAssigned;
	ULONG m_maxLen;
	SRV_PROC *m_pSrvProc;
};
