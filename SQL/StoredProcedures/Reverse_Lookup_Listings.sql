CREATE PROCEDURE `Reverse_Lookup_Listings` (In userid1 int(11),In timestamp1 int(255) )
BEGIN
select id from listings where userid = userid1 and listingdate = timestamp1;
END
