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

DECLARE @tests TABLE (
	fn VARCHAR(100) NULL,
	input VARCHAR(100) NULL,
	pattern VARCHAR(100) NULL,
	extra VARCHAR(100) NULL,
	expected VARCHAR(100) NULL,
	actual VARCHAR(100) NULL
)

INSERT @tests VALUES ('match', '123', '\d+', NULL, '1', NULL)
INSERT @tests VALUES ('match', 'abc', '\d+', NULL, '0', NULL)
INSERT @tests VALUES ('match', 'abc', '\', NULL, NULL, NULL)
INSERT @tests VALUES ('match', '', '\s*', NULL, '1', NULL)
INSERT @tests VALUES ('match_count', '123', '\d+', NULL, '1', NULL)
INSERT @tests VALUES ('match_count', '123', '\d', NULL, '3', NULL)
INSERT @tests VALUES ('match_count', '123', '\s*', NULL, '3', NULL)
INSERT @tests VALUES ('match_count', '123', '\s+', NULL, '0', NULL)
INSERT @tests VALUES ('match_count', 'abc123abc456', '\d+', NULL, '2', NULL)
INSERT @tests VALUES ('split', 'a, bc ,123', '\s*,\s*', 1, 'a', NULL)
INSERT @tests VALUES ('split', 'a, bc ,123', '\s*,\s*', 2, 'bc', NULL)
INSERT @tests VALUES ('split', 'a, bc ,123', '\s*,\s*', 3, '123', NULL)
INSERT @tests VALUES ('split', 'a, bc ,123', '\s*,\s*', 4, NULL, NULL)
INSERT @tests VALUES ('split', 'abc', '\s*', 1, 'a', NULL)
INSERT @tests VALUES ('split', 'abc', '\s*', 2, 'b', NULL)
INSERT @tests VALUES ('split', 'abc', '\s*', 3, 'c', NULL)
INSERT @tests VALUES ('split', 'abc', '\s*', 4, NULL, NULL)
INSERT @tests VALUES ('replace', 'abc', '\s*', '!', '!a!b!c!', NULL)
INSERT @tests VALUES ('replace', 'a b c', '\s*', '!', '!a!!b!!c!', NULL)
INSERT @tests VALUES ('replace', ' a b c', '\s*', '!', '!!a!!b!!c!', NULL) 
INSERT @tests VALUES ('replace', ' a b c ', '\s*', '!', '!!a!!b!!c!!', NULL) 
INSERT @tests VALUES ('replace', '  a b c  ', '\s*', '!', '!!a!!b!!c!!', NULL) 
INSERT @tests VALUES ('replace', '', '\s*', '!', '!', NULL)
INSERT @tests VALUES ('replace', 'abc', '(\w)', '$1$1', 'aabbcc', NULL)
INSERT @tests VALUES ('replace', 'abc', '(\w)', '$1$2', 'abc', NULL)
INSERT @tests VALUES ('replace', '--a1b2c--', '(\w).+(\w).+(\w)', '$1$2$3', '--abc--', NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '$1$2$3', 'abc', NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '$1$2$3$4', 'abc', NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '$12', '', NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '${1}2', 'a2', NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '${1', NULL, NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '$1$', NULL, NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '$2\$x', 'b$x', NULL)
INSERT @tests VALUES ('format', '--a1b2c--', '(\w).+(\w).+(\w)', '$2\\x', 'b\x', NULL)

UPDATE @tests
SET actual = master.dbo.fn_pcre_match(input, pattern)
WHERE fn = 'match'

UPDATE @tests
SET actual = master.dbo.fn_pcre_match_count(input, pattern)
WHERE fn = 'match_count'

UPDATE @tests
SET actual = master.dbo.fn_pcre_split(input, pattern, extra)
WHERE fn = 'split'

UPDATE @tests
SET actual = master.dbo.fn_pcre_replace(input, pattern, extra)
WHERE fn = 'replace'

UPDATE @tests
SET actual = master.dbo.fn_pcre_format(input, pattern, extra)
WHERE fn = 'format'

SELECT *,
	CASE
		WHEN expected IS NULL AND actual IS NULL THEN 'pass'
		WHEN expected = actual THEN 'pass'
		ELSE 'FAILED!!!'
	END as status
FROM @tests


