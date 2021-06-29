CREATE DATABASE project01;
USE project01;
ALTER DATABASE project01 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;


CREATE TABLE Member (
	id VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255),
    name VARCHAR(255),
    birth DATE,
    inserted TIMESTAMP
);


CREATE TABLE Board
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
    body VARCHAR(2047) NOT NULL,
    memberId VARCHAR(255) NOT NULL,
    inserted TIMESTAMP DEFAULT NOW()
);

ALTER TABLE Board
ADD FOREIGN KEY (memberId)
REFERENCES Member(id);


CREATE TABLE Comment
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	comment VARCHAR(2047) NOT NULL,
    memberId VARCHAR(255) NOT NULL,
    boardId INT NOT NULL,
    inserted TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (memberId) REFERENCES Member (id),
    FOREIGN KEY (boardId) REFERENCES Board (id)
);
