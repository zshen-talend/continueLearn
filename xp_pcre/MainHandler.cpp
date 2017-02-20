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
#include "RegexCache.h"
#include "OutputParameter.h"
#include "MainHandler.h"
#include <boost/shared_ptr.hpp>
#include <stdexcept>

using namespace std;
using namespace boost;

void HandleException(SRV_PROC* pSrvProc, const char *message, shared_ptr<OutputParameter> op)
{
	try
	{
		// set the output parameter to NULL (if there was one)
		if (op.get())
			op->SetNull();
	}
	catch (...)
	{
		// we'll ignore any errors while setting the output parameter
	}

	// handle any std::exception OR XpException (our own custom exception)
	// We'll send the error text (ex.what()) back to SQL server
	srv_sendmsg(
		pSrvProc,
		SRV_MSG_ERROR,
		XP_PCRE_ERROR,
		16,
		1,
		NULL,
		0,
		0,
		const_cast<char*>(message),
		SRV_NULLTERM
		);

	srv_senddone(pSrvProc, (SRV_DONE_ERROR | SRV_DONE_MORE), 0, 0);
}

SRVRETCODE MainHandler(SRV_PROC* pSrvProc, const xp_pcre_action action)
{
	// this will hold a pointer to the output parameter
	shared_ptr<OutputParameter> op;

	try
	{
		// SHOW CACHE
		if (action == XP_PCRE_SHOW_CACHE)
		{
			if (srv_rpcparams(pSrvProc) != -1)
				throw XpException("xp_pcre_show_cache requires 0 parameters.");

			shared_ptr<vector<string> > cache = RegexCache::GetPatternSnapshot();

			// describe the column
			int result = srv_describe(
				pSrvProc, 1,
				"pattern", SRV_NULLTERM,
				SRVBIGVARCHAR, 8000,
				SRVBIGVARCHAR, 0,
				NULL
				);

			if (0 == result)
				throw XpException("Error calling srv_describe");

			for (vector<string>::const_iterator it = cache->begin(); it != cache->end(); ++it)
			{
				// set the column size (cap it at 8000)
				result = srv_setcollen(pSrvProc, 1, min(static_cast<int>(it->length()), 8000));
				if (result != SUCCEED)
					throw XpException("Error calling srv_setcollen");

				// tell SQL server where the row's data is
				result = srv_setcoldata(pSrvProc, 1, const_cast<char*>(it->c_str()));
				if (result != SUCCEED)
					throw XpException("Error calling srv_setcoldata");

				result = srv_sendrow(pSrvProc);
				if (result != SUCCEED)
					throw XpException("Error calling srv_sendrow");
			}
		}
		// FORMAT
		else if (action == XP_PCRE_FORMAT)
		{
			if (srv_rpcparams(pSrvProc) != 4)
				throw XpException("xp_pcre_format requires 4 parameters.");

			// get the output parameter
			op.reset(new OutputParameter(pSrvProc, 4));

			// get the input parameters
			StringParameter input(pSrvProc, 1);
			StringParameter pattern(pSrvProc, 2);
			StringParameter format(pSrvProc, 3);

			// if either input or regex is NULL, we should just exit right now
			if (!input.IsNull() && !pattern.IsNull() && !format.IsNull())
			{
				// get the regex from the cache
				shared_ptr<PcreRegex> re = RegexCache::GetRegex(pattern.Value());

				shared_ptr<PcreMatch> match = re->Match(input.Value());
				if (match->Success())
					op->SetValue(match->Format(format.Value()));
			}
		}
		// SPLIT
		else if (action == XP_PCRE_SPLIT)
		{
			if (srv_rpcparams(pSrvProc) != 4)
				throw XpException("xp_pcre_split requires 4 parameters.");

			// get the output parameter
			op.reset(new OutputParameter(pSrvProc, 4));

			// xp_pcre_split takes an INT as the third parameter
			// this will be the 1-based index used to determine
			// which split to return
			StringParameter input(pSrvProc, 1);
			StringParameter pattern(pSrvProc, 2);
			IntParameter splitNumParam(pSrvProc, 3);

			if (!input.IsNull() && !pattern.IsNull() && !splitNumParam.IsNull())
			{
				// get the regex from the cache
				shared_ptr<PcreRegex> re = RegexCache::GetRegex(pattern.Value());

				// get the proper index
				int index = splitNumParam.Value() - 1;

				if (index >= 0)
				{
					// do the split
					shared_ptr<vector<string> > splits = re->Split(input.Value());

					// if the result is not NULL, set the output paramater
					// The only reason the result would be NULL is because
					// the index was greater than the number of splits returned
					// (NULL will be set below if we don't set a value here)
					if (index < static_cast<int>(splits->size()))
						op->SetValue(splits->at(index));
				}
				else
				{
					throw XpException("Split index must be 1 or greater");
				}
			}
		}
		// REPLACE
		else if (action == XP_PCRE_REPLACE)
		{
			if (srv_rpcparams(pSrvProc) != 4)
				throw XpException("xp_pcre_replace requires 4 parameters.");

			// get the output parameter
			op.reset(new OutputParameter(pSrvProc, 4));

			// get the input parameters
			StringParameter input(pSrvProc, 1);
			StringParameter pattern(pSrvProc, 2);
			StringParameter replacement(pSrvProc, 3);

			// if either input or regex is NULL, we should just exit right now
			if (!input.IsNull() && !pattern.IsNull() && !replacement.IsNull())
			{
				// get the regex from the cache
				shared_ptr<PcreRegex> re = RegexCache::GetRegex(pattern.Value());

				op->SetValue(re->Replace(input.Value(), replacement.Value()));
			}
		}
		// MATCH
		else if (action == XP_PCRE_MATCH)
		{
			if (srv_rpcparams(pSrvProc) != 3)
				throw XpException("xp_pcre_match requires 3 parameters.");

			// get the output parameter
			op.reset(new OutputParameter(pSrvProc, 3));

			// get the output parameter
			StringParameter input(pSrvProc, 1);
			StringParameter pattern(pSrvProc, 2);

			// if either input or regex is NULL, we should just exit right now
			if (!input.IsNull() && !pattern.IsNull())
			{
				// get the regex from the cache
				shared_ptr<PcreRegex> re = RegexCache::GetRegex(pattern.Value());

				op->SetValue(re->Match(input.Value())->Success() ? "1" : "0");
			}
		}
		else if (action == XP_PCRE_MATCH_COUNT)
		{
			if (srv_rpcparams(pSrvProc) != 3)
				throw XpException("xp_pcre_match_count requires 3 parameters.");

			// get the output parameter
			op.reset(new OutputParameter(pSrvProc, 3));

			// get the output parameter
			StringParameter input(pSrvProc, 1);
			StringParameter pattern(pSrvProc, 2);

			// if either input or regex is NULL, we should just exit right now
			if (!input.IsNull() && !pattern.IsNull())
			{
				// get the regex from the cache
				shared_ptr<PcreRegex> re = RegexCache::GetRegex(pattern.Value());

				vector<char> buffer(20);
				int count = re->MatchCount(input.Value());
				itoa(count, &buffer[0], 10);
				string countStr(&buffer[0]);
				op->SetValue(countStr);
			}
		}
		else
		{
			// should never get here!
			throw XpException("Unknown action code");
		}

		// if the output parameter was specified, but nothing above set a
		// return value, let's set it to NULL
		if (op.get() && !op->ValueAssigned())
			op->SetNull();

		// we need to set SRV_DONE_MORE upon successful completion
		srv_senddone(pSrvProc, (SRV_DONE_MORE), 0, 0);
		return XP_NOERROR;
	}
	catch (const exception &ex)
	{
		HandleException(pSrvProc, ex.what(), op);
		return XP_ERROR;
	}
	catch (...)
	{
		HandleException(pSrvProc, "Unknown exception", op);
		return XP_ERROR;
	}
}

