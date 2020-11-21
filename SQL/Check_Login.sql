CREATE DEFINER=`root`@`localhost` PROCEDURE `Check_Login`(IN Email1 varchar(45), IN Password1 varchar(45))
BEGIN
Declare pass varchar(200) default sha2(Password1, '512');
SELECT 
	Case 
		When Exists(select Email from user where Email = Email1 AND Password = pass) Then 1
        When Exists(select Email from user where Email = Email1) Then 0
		Else -1
	End;

END