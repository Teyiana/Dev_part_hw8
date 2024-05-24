-- insert data into table worker

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('PAVLO', '1989-07-11', 'Senior', '4000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Bill', '1991-06-16', 'junior', '1000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Max', '1993-02-15', 'Middle', '2000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Taras', '1987-05-12', 'Middle', '3000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Helen', '1992-07-13', 'Trainee', '500');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Liza', '1994-08-18', 'Junior', '600');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Ivan', '1996-03-22', 'Senior', '5000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Tatiana', '1985-04-17', 'Trainee', '400');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Mary', '1991-08-20', 'Middle', '5000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Petro', '1995-01-18', 'Senior', '7000');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES('Elizabeth', '1999-04-18', 'Senior', '8000'),
      ('Victoria', '2005-05-12', 'Trainee', '200'),
      ('Natalie', '2001-07-09', 'Middle', '3000');


--insert data into table client

INSERT INTO client (NAME)
VALUES('Robert'), ('Elon'), ('Steve'), ('Stepan'), ('Olivia'),('Camila'), ('Sofia'), ('William'), ('Henry'), ('Nora');

--insert data into table project

INSERT INTO project (ID, NAME, CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    ('1', 'Green Air', '5', '1999-01-10', '1999-02-11'),
    ('2', 'Pure Plants', '4', '2018-02-11', '2023-03-12'),
    ('3', 'Infotech Innovations', '3', '2012-08-15', '2016-09-12'),
    ('4', 'Green Energy', '2', '2018-04-19', '2021-07-02'),
    ('5', 'CyberGuardians', '1', '2019-011-17', '2023-04-09'),
    ('6', 'WebMinds Solutions', '10', '2020-07-25', '2024-03-20'),
    ('7','FixEmerge Services', '9', '2019-09-17', '2022-05-02'),
    ('8', 'InnoData IT Experts', '7', '2017-09-21', '2021-03-30'),
    ('9', 'MindMatrix IT', '8', '2010-05-07', '2014-07-08'),
    ('10', 'NimbusTech Solutions', '6', '2015-06-17', '2018-08-04'),
    ('11', 'WebTech Solutions', '6', '2017-05-17', '2018-04-04'),
    ('12', 'Clear Air', '4', '2019-03-12', '2021-04-05');



--insert data into table project_worker

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(1,1), (1,4), (1,6), (1,12), (1,13);


INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(2,2), (2,7), (2,8);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES (3,10), (3,3), (3,5), (3,6);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(4,4), (4,9), (4,11);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(5, 13), (5, 7), (5, 8), (5, 2);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(6, 11), (6, 12), (6, 2), (6, 4);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(7, 6), (7, 7), (7, 8);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(8, 9), (8, 10), (8, 11);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(9, 13), (9, 10), (9, 1);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID )
VALUES(10, 4), (10, 8), (10, 7);







