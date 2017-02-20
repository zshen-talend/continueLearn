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

#pragma comment(lib, "opends60.lib")
#ifdef _DEBUG
#pragma comment(lib, "pcre5_d.lib")
#else
#pragma comment(lib, "pcre5.lib")
#endif

#include "RegexCache.h"
#include "MainHandler.h"
#include "CriticalSectionWrapper.h"
#include "XpException.h"
#include "DebugStream.h"
#include <stdexcept>

using namespace std;
using namespace boost;

BOOL APIENTRY DllMain(HANDLE /* hModule */, const DWORD ul_reason_for_call, LPVOID /* lpReserved */)
{
#ifndef NDEBUG
	DebugStream debug;
	debug << "DllMain " << ul_reason_for_call << endl;
#endif
			
	// Note: the return value of DllMain is only relevant
	// when ul_reason_for_call == DLL_PROCESS_ATTACH
	BOOL retval = TRUE;

	if (ul_reason_for_call == DLL_PROCESS_ATTACH)
	{
		RegexCache::Initialize();
	}
	else if (ul_reason_for_call == DLL_PROCESS_DETACH)
	{
		RegexCache::CleanUp();
	}

	return retval;
}


extern "C" __declspec(dllexport) ULONG __GetXpVersion()
{
	// required for XP development
	return ODS_VERSION;
}

extern "C" __declspec(dllexport) SRVRETCODE xp_pcre_split(SRV_PROC *pSrvProc)
{
	return MainHandler(pSrvProc, XP_PCRE_SPLIT);
}

extern "C" __declspec(dllexport) SRVRETCODE xp_pcre_replace(SRV_PROC *pSrvProc)
{
	return MainHandler(pSrvProc, XP_PCRE_REPLACE);
}

extern "C" __declspec(dllexport) SRVRETCODE xp_pcre_match(SRV_PROC *pSrvProc)
{
	return MainHandler(pSrvProc, XP_PCRE_MATCH);
}

extern "C" __declspec(dllexport) SRVRETCODE xp_pcre_match_count(SRV_PROC *pSrvProc)
{
	return MainHandler(pSrvProc, XP_PCRE_MATCH_COUNT);
}

extern "C" __declspec(dllexport) SRVRETCODE xp_pcre_format(SRV_PROC *pSrvProc)
{
	return MainHandler(pSrvProc, XP_PCRE_FORMAT);
}

extern "C" __declspec(dllexport) SRVRETCODE xp_pcre_show_cache(SRV_PROC *pSrvProc)
{
	return MainHandler(pSrvProc, XP_PCRE_SHOW_CACHE);
}

