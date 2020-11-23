CREATE DEFINER=`root`@`localhost` PROCEDURE `Get_Hashtag_Id`(In val1 varchar(45))
BEGIN
select id from hashtags where val = val1;
END