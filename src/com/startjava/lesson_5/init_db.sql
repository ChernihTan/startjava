\o log_init_db.txt
\qecho 1. ����� � ��������� ����

\qecho 2. ������������ �� ��������� windows1251
\! chcp 1251
set client_encoding='win1251';

\qecho 3. ����������� � �� robots
\c robots

\qecho 4. �������� �������
\c robots
DROP TABLE IF EXISTS Jaegers;

\qecho 5. �������� ������� Jaegers
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

\qecho 6. ���������� �������, ����������� � ��������� WIN-1251
\i populate.sql

\qecho 7.  ���������� ��������
\i queries.sql

--8. ����� � �������
\o