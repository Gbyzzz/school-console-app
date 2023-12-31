-- DROP DATABASE IF EXISTS school_db;
--
-- CREATE DATABASE school_db
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'English_Israel.1251'
--     LC_CTYPE = 'English_Israel.1251'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1;


DROP TABLE IF EXISTS courses_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS groups;

CREATE TABLE groups
(
    group_id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    group_name varchar(255) NOT NULL,
    UNIQUE(group_name)

);

WITH myVar(char_array) AS (values('ABCDEFGHIJKLMNOPQRSTUVWXYZ'))
INSERT INTO groups(group_name)
SELECT
    concat(substring(myVar.char_array, CAST(round(random()*24)+1 AS int), 1),
           substring(myVar.char_array,CAST(round(random()*24)+1 AS int), 1),'-', round(random()*89)+10)
FROM generate_series(1,10), myVar
ON CONFLICT DO NOTHING;

SELECT setval('groups_group_id_seq', (SELECT MAX(group_id) from "groups"));

CREATE TABLE students
(
    student_id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    group_id   bigint REFERENCES groups (group_id),
    first_name varchar(20) NOT NULL,
    last_name  varchar(20) NOT NULL
);

INSERT INTO students (
    group_id,
    first_name,
    last_name
) SELECT
      round(random()*9+1),
      (ARRAY['Adam','Sam', 'Dan', 'Johnny', 'Tom', 'Andy', 'William', 'Lenny', 'Kenny', 'Charles',
       'Randy', 'Billy', 'Mike', 'Kelly', 'Sally', 'Vivian', 'Theresa', 'Natalie', 'Greg', 'Kim'])[round(random()*19)+1],
      (ARRAY['Johnson', 'Green', 'West', 'Marley', 'Pierce', 'Smith', 'Williams', 'Brown', 'Anderson', 'Jackson',
        'White', 'Young', 'King', 'Scott', 'Hill', 'Mitchel', 'Carter', 'Parker', 'Morris', 'Murphy'])[round(random()*19)+1]
FROM generate_series(1,200);

SELECT setval('students_student_id_seq', (SELECT MAX(student_id) from "students"));

CREATE TABLE courses
(
    course_id          bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    course_name        varchar(20) NOT NULL,
    course_description varchar(100) NOT NULL
);
INSERT INTO courses
VALUES (1, 'Math', 'Math lessons'),
       (2, 'Biology', 'Biology lessons'),
       (3, 'Physics', 'Physics lessons'),
       (4, 'IT', 'IT lessons'),
       (5, 'English', 'English lessons'),
       (6, 'Literature', 'Literature lessons'),
       (7, 'Foreign language', 'Foreign language lessons'),
       (8, 'Sport', 'Sport activity'),
       (9, 'Astronomy', 'Astronomy lessons'),
       (10, 'History', 'History lessons');
SELECT setval('courses_course_id_seq', (SELECT MAX(course_id) from "courses"));


CREATE TABLE courses_students
(
    course_id  bigint NOT NULL REFERENCES courses (course_id),
    student_id bigint NOT NULL REFERENCES students (student_id) ON DELETE CASCADE,
    UNIQUE (course_id, student_id)
);

DO
$do$
BEGIN
FOR i IN 1..200 LOOP
   FOR j IN 1..round(random()*3) LOOP
      INSERT INTO courses_students
         (course_id, student_id)


SELECT  round(random()*9+1), i ON CONFLICT (course_id, student_id) DO NOTHING;
END LOOP;
END LOOP;
END
$do$;