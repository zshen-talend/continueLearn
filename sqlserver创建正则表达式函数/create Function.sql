use tbi
go
exec sp_configure 'clr enabled', 1;
reconfigure;
go
--��SQL Server�п���CLR���ù���
use tbi
go
create assembly RegExp from 'F:\Program Files\Microsoft SQL Server\100\Tools\Binn\regexTest.dll'
--ע��dll��assembly
go
create function [dbo].[RegexMatch](
@input as NVARCHAR(4000),
@pattern as NVARCHAR(4000)
)
returns NCHAR(1)
as external Name [RegExp].[regexTest.RegExBase].[RegExMatch]
go
--����������ʽ����