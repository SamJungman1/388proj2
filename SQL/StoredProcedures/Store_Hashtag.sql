CREATE DEFINER=`root`@`localhost` PROCEDURE `Store_Hashtag`(In val1 varchar(45))
BEGIN
INSERT INTO hashtags (val)
VALUES (val1);
END