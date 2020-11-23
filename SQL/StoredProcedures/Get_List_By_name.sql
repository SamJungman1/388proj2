CREATE DEFINER=`root`@`localhost` PROCEDURE `Get_List_By_Name`(In name1 varchar(45))
BEGIN
select * from listings where Listingname like concat('%',name1,'%');
END