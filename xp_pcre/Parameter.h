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

// The Parameter class template handles extracting the
// parameter from SQL Server.
template<class T>
class Parameter
{
public:
	Parameter(SRV_PROC *pSrvProc, int paramNum);
	T Value() const;
	bool IsNull() const
	{
		return m_isNull;
	}

private:
	Parameter(const Parameter<T>&);
	Parameter<T>& operator=(const Parameter<T>&);

	typedef std::vector<BYTE> ByteVector;

	void ExtractAndStoreValue(const ByteVector &buffer);
	const void ValidateParameterType(BYTE bType) const;
	T m_value;
	bool m_isNull;
	int m_paramNum;
};

typedef Parameter<std::string> StringParameter;
typedef Parameter<int> IntParameter;

template<class T>
Parameter<T>::Parameter(SRV_PROC *pSrvProc, const int paramNum) :
	m_isNull(false),
	m_paramNum(paramNum)
{
	BYTE bType = 0;
	ULONG cbMaxLen = 0;
	ULONG cbActualLen = 0;
	BOOL fNull = FALSE;

	// call first to get the size of the parameter
	if (srv_paraminfo(pSrvProc, paramNum, &bType, &cbMaxLen, &cbActualLen, NULL, &fNull) != SUCCEED)
		throw XpException(
			StringBuilder()
			<< "Error calling srv_paraminfo (first time) on parameter "
			<< paramNum
			);

	// verify the correct parameter type
	ValidateParameterType(bType);

	// see if we're null. If so, set m_isNull and return
	if (fNull)
	{
		m_isNull = true;
		return;
	}

	// allocate the buffer
	ByteVector buffer(cbActualLen);

	if (!buffer.empty())
	{
		// populate the buffer
		if (srv_paraminfo(pSrvProc, paramNum, &bType, &cbMaxLen, &cbActualLen, &buffer[0], &fNull) != SUCCEED)
			throw XpException(
				StringBuilder()
				<< "Error calling srv_paraminfo (second time) on parameter "
				<< paramNum
				);
	}

	// Get the value from the buffer and store it in m_value
	// (This function is specialized for each template
	// parameter type)
	ExtractAndStoreValue(buffer);
}
