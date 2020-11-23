CREATE DEFINER=`root`@`localhost` PROCEDURE `Update_User_Password`(IN email1 varchar(45),IN Password1 varchar(45))
BEGIN
update User SET Password = sha2(Password1,512) where email = email1;
END