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



-- NOTE:
-- You'll need to copy xp_pcre.dll to your SQL Server "binn" directory
-- prior to running this script.
-- (i.e.: "c:\Program Files\Microsoft SQL Server\MSSQL\Binn")
-- Also, change the "USE master" under "User-defined function installation"
-- if you'd like to use the functions from a database other than "master"


USE master
GO

EXEC sp_addextendedproc xp_pcre_replace, 'xp_pcre.dll'
EXEC sp_addextendedproc xp_pcre_format, 'xp_pcre.dll'
EXEC sp_addextendedproc xp_pcre_match, 'xp_pcre.dll'
EXEC sp_addextendedproc xp_pcre_match_count, 'xp_pcre.dll'
EXEC sp_addextendedproc xp_pcre_split, 'xp_pcre.dll'
EXEC sp_addextendedproc xp_pcre_show_cache, 'xp_pcre.dll'

GO

USE master
GO

CREATE FUNCTION [dbo].[fn_pcre_split]
(
	@input VARCHAR(8000),		-- the input text
	@regex VARCHAR(8000),		-- the "delimiter" as a regular expression
	@itemNumber INT			   -- which item out of the resulting string array should be returned
)
RETURNS VARCHAR(8000) AS  
BEGIN 
	DECLARE @captureText VARCHAR(8000)
	EXEC master.dbo.xp_pcre_split @input, @regex, @itemNumber, @captureText OUT
	RETURN @captureText
END

GO

CREATE FUNCTION [dbo].[fn_pcre_match]
(
	@input VARCHAR(8000),		-- the input text
	@regex VARCHAR(8000)		   -- a regular expression
)
RETURNS CHAR(1) AS  
BEGIN 
	DECLARE @out CHAR(1)
	EXEC master.dbo.xp_pcre_match @input, @regex, @out OUT

	RETURN @out
END

GO

CREATE FUNCTION [dbo].[fn_pcre_match_count]
(
	@input VARCHAR(8000),		-- the input text
	@regex VARCHAR(8000)		   -- a regular expression
)
RETURNS CHAR(1) AS  
BEGIN 
	DECLARE @out VARCHAR(20)
	EXEC master.dbo.xp_pcre_match_count @input, @regex, @out OUT

	RETURN CAST(@out AS INT)
END

GO

CREATE FUNCTION [dbo].[fn_pcre_replace]
(
	@input VARCHAR(8000),		-- the input text
	@regex VARCHAR(8000),		-- a regular expression
	@replacement VARCHAR(8000) -- replace all matches with this
)
RETURNS VARCHAR(8000) AS  
BEGIN 
	DECLARE @out VARCHAR(8000)
	EXEC master.dbo.xp_pcre_replace @input, @regex, @replacement, @out OUT
	RETURN @out
END

GO

CREATE FUNCTION [dbo].[fn_pcre_format]
(
	@input VARCHAR(8000),		-- the input text
	@regex VARCHAR(8000),		-- a regular expression
	@format VARCHAR(8000) -- the format string (i.e. '($1) $2-$3')
)
RETURNS VARCHAR(8000) AS  
BEGIN 
	DECLARE @out VARCHAR(8000)
	EXEC master.dbo.xp_pcre_format @input, @regex, @format, @out OUT
	RETURN @out
END

GO

