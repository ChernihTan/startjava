\o log_init_db.txt
\qecho 1. вывод в текстовый файл

\qecho 2. переключение на кодировку windows1251
\! chcp 1251
set client_encoding='win1251';

\qecho 3. подключение к БД robots
\c robots

\qecho 4. Удаление таблицы
\c robots
DROP TABLE IF EXISTS Jaegers;

\qecho 5. Создание таблицы Jaegers
CREATE TABLE Jaegers (
    PRIMARY KEY (id),
    id          SERIAL,
    model_name  TEXT,
    mark        CHAR(7),
    height      REAL,
    weight      DECIMAL(15,2),
    status      TEXT,
    origin      TEXT,
    launch      DATE,
    kaiju_kill  INTEGER
);

\qecho 6. Заполнение таблицы, заполненной в кодировке WIN-1251
\i populate.sql

\qecho 7.  Выполнение запросов
\i queries.sql

--8. Вывод в консоль
\o