CREATE DEFINER=`root`@`localhost` PROCEDURE `Store_New_User`(
	IN Email1 varchar(45), 
	IN Username1 varchar(45),
	IN Password1 varchar(45),
    IN tag1 varchar(45),
	IN First_Name1 varchar(45),
    IN Last_Name1 varchar(45),
	IN Address1 varchar(45), 
    IN City1 varchar(45),
    IN Zip_Code1 varchar(45),
    IN State1 varchar(45) ,
    IN Country1 varchar(45),
    IN Picture_Pointer1 varchar(100))
BEGIN
INSERT INTO user (Email,Username,Password,Tag,FirstName,LastName,Address,City,Zip_Code,State,Country,PicturePointer)
VALUES (Email1,Username1,sha2(Password1,512),tag1,First_Name1,Last_Name1,Address1,City1,Zip_Code1,State1,Country1,Picture_Pointer1);
END