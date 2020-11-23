CREATE PROCEDURE `Delete_Token` (In token1 varchar(200))
BEGIN
Delete From tokens where val = token1;
END
