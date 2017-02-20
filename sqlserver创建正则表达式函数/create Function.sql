use tbi
go
exec sp_configure 'clr enabled', 1;
reconfigure;
go
--在SQL Server中开启CLR调用功能
use tbi
go
create assembly RegExp from 'F:\Program Files\Microsoft SQL Server\100\Tools\Binn\regexTest.dll'
--注册dll到assembly
go
create function [dbo].[RegexMatch](
@input as NVARCHAR(4000),
@pattern as NVARCHAR(4000)
)
returns NCHAR(1)
as external Name [RegExp].[regexTest.RegExBase].[RegExMatch]
go
--创建正则表达式函数