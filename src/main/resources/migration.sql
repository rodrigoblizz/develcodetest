CREATE DATABASE DevelcodeTest;

CREATE TABLE user_account(
id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
birthdate DATE,
image VARCHAR(100),
PRIMARY KEY ( id )
);