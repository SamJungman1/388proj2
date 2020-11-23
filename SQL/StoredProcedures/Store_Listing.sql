CREATE DEFINER=`root`@`localhost` PROCEDURE `Store_Listing`(In userid1 int(11) , In Listingname1 VARCHAR(45), Listingdescription1 varchar(200),Listingdate1 int(255))
BEGIN
INSERT INTO listings (userid,Listingname,Listingdescription,Listingdate)
VALUES (userid1,Listingname1,Listingdescription1,Listingdate1);
END