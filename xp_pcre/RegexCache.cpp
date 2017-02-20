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

#include "RegexCache.h"
#include "CriticalSectionWrapper.h"

using namespace std;
using namespace boost;

RegexCache::cache_type RegexCache::s_cache;
CRITICAL_SECTION RegexCache::s_critSec = { 0 };

shared_ptr<PcreRegex> RegexCache::GetRegex(const string &pattern)
{
#ifndef NDEBUG
	DebugStream debug;
#endif

	shared_ptr<PcreRegex> re;

	// make sure the cache isn't accessed while we're iterating it
	CriticalSectionWrapper csw(s_critSec);

	// search for the regex/modifier combination
	for (cache_type::const_iterator it = s_cache.begin(); it != s_cache.end(); ++it)
	{
		if (**it == pattern)
		{
			// found it in the cache
#ifndef NDEBUG
			debug << "Found \"" << pattern << "\" in cache" << endl;
#endif
			return *it;
		}
	}

	// trim the cache if required
	if (s_cache.size() == CACHE_SIZE)
	{
#ifndef NDEBUG
		re = s_cache.back();
		debug << "Trimmed \"" << re->Pattern() << "\" from cache" << endl;
#endif
		s_cache.pop_back();

		if (s_cache.size() >= CACHE_SIZE)
			throw XpException("Trimmed cache too large. (This should never happen!)");
	}

	// create the new PcreRegex and add it to the cache
	re.reset(new PcreRegex(pattern));
	s_cache.push_front(re);

#ifndef NDEBUG
	debug << "Added \"" << pattern << "\" to cache" << endl;
#endif

	return re;
}

shared_ptr<vector<string> > RegexCache::GetPatternSnapshot()
{
	// make sure the cache isn't accessed while we're iterating it
	CriticalSectionWrapper csw(s_critSec);

	shared_ptr<vector<string> > v(new vector<string>);
	for (cache_type::const_iterator it = s_cache.begin(); it != s_cache.end(); ++it)
	{
		v->push_back((*it)->Pattern());
	}

	return v;
}
