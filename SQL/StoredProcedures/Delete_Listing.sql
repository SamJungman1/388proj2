CREATE DEFINER=`root`@`localhost` PROCEDURE `Delete_Listing`(IN id1 int(11))
BEGIN
delete from listings where id = id1;
END