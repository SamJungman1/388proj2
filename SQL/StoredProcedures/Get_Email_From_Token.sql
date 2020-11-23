CREATE PROCEDURE `Get_Email_From_Token` (In token1 varchar(200))
BEGIN
select email from tokens where val = token1;
END
