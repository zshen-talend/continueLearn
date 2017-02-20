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

#include "Parameter.h"
#include "StringBuilder.h"

using namespace std;

template<>
void StringParameter::ExtractAndStoreValue(const ByteVector& buffer)
{
	if (!buffer.empty())
		m_value.assign(buffer.begin(), buffer.end());
}

template<>
string StringParameter::Value() const
{
	return m_value;
}

template<>
const void StringParameter::ValidateParameterType(const BYTE bType) const
{
	switch (bType)
	{
	case SRVBIGCHAR:
	case SRVBIGVARCHAR:
	case SRVTEXT:
		break;
	default:
		throw XpException(
			StringBuilder()
			<< "Parameter "
			<< m_paramNum
			<< " should be an ASCII character type."
			);
	}
}


template<>
void IntParameter::ExtractAndStoreValue(const ByteVector& buffer)
{
	if (buffer.size() == sizeof(int))
		m_value = *reinterpret_cast<const int*>(&buffer[0]);
	else
		throw XpException(
			StringBuilder()
			<< "INT parameter should be "
			<< static_cast<int>(sizeof(int))
			<< " bytes. Parameter was "
			<< static_cast<int>(buffer.size())
			<< " bytes."
			);
}

template<>
int IntParameter::Value() const
{
	return m_value;
}

template<>
const void IntParameter::ValidateParameterType(const BYTE bType) const
{
	if (bType != SRVINT4 && bType != SRVINTN)
		throw XpException(
			StringBuilder()
			<< "Parameter "
			<< m_paramNum
			<< " should be an INT."
			);
}
