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

#include <list>
#include <windows.h>
#include <vector>
#include <string>
#include <boost/shared_ptr.hpp>
#include "PcreRegex.h"
#include "DebugStream.h"

/*
RegexCache stores the most recently used PcreRegex objects.
The cache is protected with a CRITICAL_SECTION.
The RegexCache is also responsible for creating, if necessary,
any new PcreRegex objects.

Initialize() is called when the DLL is loaded, CleanUp() is called on unload.
*/
class RegexCache
{
public:
	static void Initialize()
	{
		InitializeCriticalSection(&s_critSec);

#ifndef NDEBUG
		DebugStream debug;
		debug << "Initializing RegexCache\n";
#endif
	}

	static void CleanUp()
	{
		DeleteCriticalSection(&s_critSec);
		s_cache.clear();

#ifndef NDEBUG
		DebugStream debug;
		debug << "Cleaned up RegexCache\n";
#endif
	}

	static boost::shared_ptr<PcreRegex> GetRegex(const std::string &pattern);
	static boost::shared_ptr<std::vector<std::string> > GetPatternSnapshot();

private:
	typedef std::list<boost::shared_ptr<PcreRegex> > cache_type;
	static const cache_type::size_type CACHE_SIZE = 50;

	static cache_type s_cache;
	static CRITICAL_SECTION s_critSec;
};
