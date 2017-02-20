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

// we want any DebugStream statements to fail to compile when we're in release mode
#ifndef NDEBUG

#include <Windows.h>
#include <ostream>
#include <sstream>
#include <string>

#pragma warning(disable: 4511)
#pragma warning(disable: 4512)

template <class CharT, class TraitsT=std::char_traits<CharT> >
class basic_debugbuf : public std::basic_stringbuf<CharT, TraitsT>
{
public:

    virtual ~basic_debugbuf()
    {
        sync();
    }

protected:


    int sync()
    {
        output_debug_string(str().c_str());
        str(std::basic_string<CharT>());    // Clear the string buffer

        return 0;
    }

    void output_debug_string(const CharT *text) const {}
};


template<class CharT, class TraitsT=std::char_traits<CharT> >
class basic_dostream : public std::basic_ostream<CharT, TraitsT>
{
public:
    basic_dostream() : std::basic_ostream<CharT, TraitsT>
       (new basic_debugbuf<CharT, TraitsT>()) {}
    ~basic_dostream() 
    {
        delete rdbuf(); 
    }
};

template<>
void basic_debugbuf<char>::output_debug_string(const char *text) const
{
    ::OutputDebugStringA(text);
}

typedef basic_dostream<char> DebugStream;

#endif