-- create TABLE worker

CREATE TABLE worker
(
    ID IDENTITY PRIMARY KEY,
    NAME     VARCHAR(1000) NOT NULL,
    CHECK (LENGTH(NAME) > 2),
    BIRTHDAY DATE,
    LEVEL    enum ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    SALARY   INTEGER CHECK (SALARY >= 100 AND SALARY <= 100000)
);

-- create table client

CREATE TABLE client
(
    ID IDENTITY PRIMARY KEY,
    NAME VARCHAR(1000) NOT NULL,
    CHECK (LENGTH(NAME) > 2)
);

-- create table project

CREATE TABLE project
(
    ID IDENTITY PRIMARY KEY,
    NAME        VARCHAR(1000) NOT NULL,
    CHECK (LENGTH(NAME) > 2),
    CLIENT_ID   BIGINT        NOT NULL,
    START_DATE  DATE,
    FINISH_DATE DATE
);


-- CREATE table project_worker
CREATE TABLE project_worker
(
    PROJECT_ID BIGINT,
    FOREIGN KEY (PROJECT_ID) REFERENCES project (ID),
    WORKER_ID  BIGINT,
    FOREIGN KEY (WORKER_ID) REFERENCES worker (ID),
    PRIMARY KEY (PROJECT_ID, WORKER_ID)
);
