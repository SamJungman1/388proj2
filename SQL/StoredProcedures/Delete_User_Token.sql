CREATE PROCEDURE `Delete_User_Tokens` (IN Email1 varchar(45))
BEGIN
delete from Tokens where email = Email1;
END
