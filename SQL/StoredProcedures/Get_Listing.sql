CREATE PROCEDURE `Get_Listing` (IN id1 int(11))
BEGIN
select * from listings where Id = id1;
END
