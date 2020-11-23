CREATE DEFINER=`root`@`localhost` PROCEDURE `Check_Hashtag`(In val1 varchar(45))
BEGIN
SELECT Case When Exists(select val from hashtags where val = val1) Then 1  Else 0  End AS isHashTag;
END