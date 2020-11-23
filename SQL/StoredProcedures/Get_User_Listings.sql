CREATE PROCEDURE `Get_User_Listings` (IN userid1 int(11))
BEGIN
select * from listings where Userid = userid1;
END
