CREATE PROCEDURE `Store_Token` (In val1 varchar(200) , In email1 VARCHAR(45), In expires1 int(255) )
BEGIN
INSERT INTO tokens (val,email,expires)
VALUES (val1,email1,expires1);
END
