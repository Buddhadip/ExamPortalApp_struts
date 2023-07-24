-- Database creation
Drop database exam_master;
create database exam_master;
use exam_master;
-- Creating Tables:
-- 1.
CREATE TABLE user (
    uid VARCHAR(50) PRIMARY KEY,
    uname VARCHAR(255),
    uroll VARCHAR(255),
    urole VARCHAR(255),
    emailid  VARCHAR(255)
);

-- 2.
CREATE TABLE Exam (
    Eid INT PRIMARY KEY AUTO_INCREMENT,
    ETitle VARCHAR(255),
    EDuration INT,
    EStart DATETIME,
    EEnd DATETIME
);

-- 3.

CREATE TABLE Question (
    Qid INT PRIMARY KEY  AUTO_INCREMENT,
    QText TEXT,
    QMarks INT,
    QImage VARCHAR(255)
);
    

CREATE TABLE QuestionToExam (
    Qid int,
	Eid Int,
    FOREIGN KEY (Qid) REFERENCES Question(Qid)  ON DELETE CASCADE,
    FOREIGN KEY (Eid) REFERENCES Exam(Eid)  ON DELETE CASCADE
    );
    
    
-- 4.

CREATE TABLE Options (
    Oid INT PRIMARY KEY  AUTO_INCREMENT,
    OText VARCHAR(255),
    OImage VARCHAR(255),
    Qid INT,
    isAns boolean
);

-- 5. Modifying Tables

-- --------------------------------------------

-- 6.
CREATE TABLE Results (
    Rid INT PRIMARY KEY   AUTO_INCREMENT,
    Uid VARCHAR(50),
    Eid INT,
    RTotal INT,
    RScore INT,
    SubmissionTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Uid) REFERENCES User(Uid)  ON DELETE CASCADE,
    FOREIGN KEY (Eid) REFERENCES Exam(Eid)  ON DELETE CASCADE
);

-- 7.
CREATE TABLE Notifications (
    Nid INT PRIMARY KEY  AUTO_INCREMENT,
    Uid VARCHAR(255),
    Eid INT,
    Rid INT,
    Timestamp DATETIME  DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Uid) REFERENCES User(Uid)  ON DELETE CASCADE,
    FOREIGN KEY (Eid) REFERENCES Exam(Eid)  ON DELETE CASCADE,
    FOREIGN KEY (Rid) REFERENCES Results(Rid)  ON DELETE CASCADE
);

-- 8.
CREATE TABLE ExamUser (
    eid INT,
    uid VARCHAR(255),
    FOREIGN KEY (eid) REFERENCES Exam(Eid)  ON DELETE CASCADE,
    FOREIGN KEY (uid) REFERENCES User(Uid)  ON DELETE CASCADE
);

-- 9. Creating Triggers
DELIMITER $$
CREATE TRIGGER GenerateUID
BEFORE INSERT ON User
FOR EACH ROW
BEGIN
  DECLARE counter INT;
  
  SET NEW.UID = CONCAT(LEFT(NEW.uname, 1), SUBSTRING_INDEX(SUBSTRING_INDEX(NEW.uname, ' ', -1), ' ', 1));
  SET NEW.UID = LEFT(NEW.UID, 2); -- Limit the UID to the first two characters
  
  SELECT COUNT(*) INTO counter FROM User WHERE UID LIKE CONCAT(NEW.UID, '%');
  
  IF counter > 0 THEN
    SET NEW.UID = CONCAT(NEW.UID, LPAD(counter + 1, 2, '0'));
  ELSE
    SET NEW.UID = CONCAT(NEW.UID, '01');
  END IF;
END$$
DELIMITER ;

-- 10. Inserting Values

INSERT INTO User (uname, uroll, urole, emailid)
VALUES
  ('Mainak Deb', 'M2023013', 'Admin', 'mainakdeb@gmail.com'),
  ('Buddhadip Mukherjee', 'B2023014', 'Admin', 'buddhadip@gmail.com'),
  ('Michael Thompson', 'M2023015', 'Student', 'mthompson@example.com'),
  ('Jessica Rodriguez', 'J2023016', 'Student', 'jrodriguez@example.com');


-- select * from user ORDER BY uname;
-- select * from Exam;

-- select * from ExamUser;

-- SELECT *
-- FROM Exam
-- WHERE Eend > NOW();

-- SELECT *
-- FROM Exam
-- WHERE Eend > NOW()
-- and estart<NOW() order by estart;


select * from question;
select * from options;
-- select * from QuestionToExam;

select isAns from options where Qid=4 and oid=14;

select sum(qmarks) as total from questiontoexam join question 
where question.qid=questiontoexam.qid
and eid=1
;

select * from results;
select * from Notifications;