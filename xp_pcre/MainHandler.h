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

#include <srv.h>

enum xp_pcre_action
{
	XP_PCRE_SPLIT,
	XP_PCRE_REPLACE,
	XP_PCRE_MATCH,
	XP_PCRE_MATCH_COUNT,
	XP_PCRE_FORMAT,
	XP_PCRE_SHOW_CACHE
};

// extended stored proc. return codes
enum xp_error
{
	XP_NOERROR = 0,
	XP_ERROR = 1,
	MAX_SERVER_ERROR = 20000,
	XP_PCRE_ERROR = MAX_SERVER_ERROR + 1
};

SRVRETCODE MainHandler(SRV_PROC* pSrvProc, xp_pcre_action action);
