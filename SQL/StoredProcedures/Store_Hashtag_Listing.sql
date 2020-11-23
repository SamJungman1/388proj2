CREATE DEFINER=`root`@`localhost` PROCEDURE `Store_Hashtag_To_Listing`(IN Listingid1 int(11), In Hashtagid1 int(11) )
BEGIN
INSERT INTO Hashtagstolistings (Listingid, Hashtagid)
VALUES (Listingid1, Hashtagid1);
END