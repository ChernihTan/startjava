--     1. ����� � ��������� ���� log_init_db.txt
\o log_init_db.txt
\qecho 1. ����� � ��������� ����

--     2. ������������ �� ��������� windows1251
\qecho 2. ������������ �� ��������� windows1251
\! chcp 1251
set client_encoding='win1251';

--     3. ����������� � �� robots
\qecho 3. ����������� � �� robots
\c robots


--     4. �������� �������
\qecho 4. �������� �������
\c robots
DROP TABLE Jaegers;

--     5. �������� ������� Jaegers
\qecho 5. �������� ������� Jaegers
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

--     6. ���������� �������, ����������� � ��������� WIN-1251
\qecho 6. ���������� �������, ����������� � ��������� WIN-1251
\i populate.sql

--     7. ���������� ��������
\qecho 7.  ���������� ��������
\i queries.sql

--8. ����� � �������
\o
