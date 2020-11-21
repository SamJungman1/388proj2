CREATE DEFINER=`root`@`localhost` PROCEDURE `Check_Tag`(IN Username1 varchar(45), IN Tag1 varchar(45))
BEGIN
SELECT 
	Case 
		When Exists(select username from user where username = Username1 AND tag = Tag1) Then 0
		Else 1
	End AS tagIsFree;
END