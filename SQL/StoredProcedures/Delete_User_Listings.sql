CREATE PROCEDURE `Delete_User_Listings`(In userid1 int(11))
BEGIN
delete from listings where UserId = userid1;
END
