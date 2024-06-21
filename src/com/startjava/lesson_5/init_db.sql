--     1. вывод в текстовый файл log_init_db.txt
\o log_init_db.txt
\qecho 1. вывод в текстовый файл

--     2. переключение на кодировку windows1251
\qecho 2. переключение на кодировку windows1251
\! chcp 1251
set client_encoding='win1251';

--     3. подключение к БД robots
\qecho 3. подключение к БД robots
\c robots


--     4. Удаление таблицы
\qecho 4. Удаление таблицы
\c robots
DROP TABLE Jaegers;

--     5. Создание таблицы Jaegers
\qecho 5. Создание таблицы Jaegers
CREATE TABLE Jaegers (
    PRIMARY KEY (id),
	id          SERIAL,
	model_name  TEXT,
	mark        CHAR(7),
	height      REAL,
	weight      REAL,
	status      TEXT,
	origin      TEXT,
	launch      DATE,
	kaiju_kill  INTEGER
);

--     6. Заполнение таблицы, заполненной в кодировке WIN-1251
\qecho 6. Заполнение таблицы, заполненной в кодировке WIN-1251
\i populate.sql

--     7. Выполнение запросов
\qecho 7.  Выполнение запросов
\i queries.sql

--8. Вывод в консоль
\o
