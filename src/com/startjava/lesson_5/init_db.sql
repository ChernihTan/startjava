-- 1. вывод в текстовый файл protokol.txt
\o protokol.txt
--out protokol.txt
\qecho 1. output to a text file protokol.txt
\qecho out protokol.txt

-- 2. переключение на кодировку windows1251
\qecho 2. witching to windows1251 encoding
\! chcp 1251

-- 3. подключение к БД robots
\qecho 3. connecting to the database robots
\c robots
\qecho

--  информация по всей БД robots
--\d
-- информация по конкретной таблицы БД robots
--\d jaegers

-- 4. удаление таблицы
\qecho 4. deleting a table
\qecho DROP TABLE Jaegers;
DROP TABLE Jaegers;
\qecho

-- 5. создание таблицы
\qecho 4. creation of a table
\qecho CREATE TABLE Jaegers (
\qecho id		SERIAL PRIMARY KEY,
\qecho model_name	TEXT,
\qecho mark		CHAR(7),
\qecho height	REAL,
\qecho weight	REAL,
\qecho status	TEXT,
\qecho origin 	TEXT,
\qecho launch 	DATE,
\qecho kaiju_kill INTEGER);

CREATE TABLE Jaegers (
	id		SERIAL PRIMARY KEY,
	model_name	TEXT,
	mark		CHAR(7),
	height	REAL,
	weight	REAL,
	status	TEXT,
	origin 	TEXT,
	launch 	DATE,
	kaiju_kill INTEGER)
;
-- 5. Заполнение таблицы, заполненной в кодировке WIN1251
\qecho 5. Filling in the table in code WIN1251
\i populate.sql

\qecho 6. ------------Query execution ---------------------
\i queries.sql