CREATE DEFINER=`root`@`localhost` PROCEDURE `Check_Token`(In token1 varchar(200),In time1 BigInt(45)  )
BEGIN
SELECT Case When Exists(select val from Tokens where val = token1 AND expires >= time1) Then 1  Else 0  End AS isLoggedIn;
END