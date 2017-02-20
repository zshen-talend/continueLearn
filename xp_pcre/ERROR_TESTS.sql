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


SET NOCOUNT ON

DECLARE @out VARCHAR(8000)

print 'Should return "xp_pcre_XXX requrires # parameters"'
EXEC master.dbo.xp_pcre_split
EXEC master.dbo.xp_pcre_replace
EXEC master.dbo.xp_pcre_format
EXEC master.dbo.xp_pcre_match
EXEC master.dbo.xp_pcre_show_cache 1

print ''
print 'Should return "Parameter # should be an ASCII character type."'
EXEC master.dbo.xp_pcre_split 1, '\d+', 1, @out OUT
EXEC master.dbo.xp_pcre_split 'a1b2c3', 1, 1, @out OUT

print ''
print 'Should return "Parameter 3 should be an INT."'
EXEC master.dbo.xp_pcre_split 'a1b2c3', '\d+', '1', @out OUT


print ''
print 'Should return "Parameter 4 should be an output parameter."'
EXEC master.dbo.xp_pcre_split 'a', 'a', 1, 'a'

print ''
print 'Should return "Split index must be 1 or greater"'
EXEC master.dbo.xp_pcre_split 'a, bc ,123', '\s*,\s*', 0, @out OUTPUT


print ''
print 'Should print "pcre_compile() failed: \ at end of pattern at character 1"'
EXEC master.dbo.xp_pcre_match 'abc', '\', @out OUTPUT

print ''
print 'Should print "The escape character "\" cannot appear alone at the end of the string. Use "\\" instead."'
EXEC master.dbo.xp_pcre_format 'abc', '(\w)', '$1\', @out OUTPUT

print ''
print 'Should print "$ at end of format string is not allowed."'
EXEC master.dbo.xp_pcre_format 'abc', '(\w)', '$1$', @out OUTPUT

print ''
print 'Should print "Only digits are allowed inside of ${} in the format string"'
EXEC master.dbo.xp_pcre_format 'abc', '(\w)', '${12345a}', @out OUTPUT

print ''
print 'Should print "You must put at least one digit after a $ in the format string."'
EXEC master.dbo.xp_pcre_format 'abc', '(\w)', '$a', @out OUTPUT

print ''
print 'Should print "Unrecognized escape sequence: \a"'
EXEC master.dbo.xp_pcre_format 'abc', '(\w)', '\a', @out OUTPUT

