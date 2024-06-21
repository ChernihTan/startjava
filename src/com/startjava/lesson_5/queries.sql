-- ����� � ��������� ���� protokol.txt
\o log_queries.txt

--     1. ����� ���� �������
\qecho 1. ����� ���� �������

SELECT *
  FROM Jaegers;

--     2. ����� ������ �� ������������ �������
\qecho 2. ����� ������ �� ������������ �������

SELECT *
  FROM Jaegers
 WHERE status = '';

--     3. ����� ������ ������� ����� Mark-1 � Mark-4
\qecho 3. ����� ������ ������� ����� Mark-1 � Mark-4

SELECT *
  FROM Jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');

--     4. ����� ���� �������, ����� Mark-1 � Mark-4, ������������ ������� �� �������� �� ������� mark
\qecho 4. ����� ���� �������, ����� Mark-1 � Mark-4, ������������ ������� �� �������� �� ������� mark

SELECT *
  FROM Jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

--     5. ����� ���������� � ����� ������ �������
\qecho 5. ����� ���������� � ����� ������ �������

SELECT *
  FROM Jaegers
 WHERE launch = 
       (SELECT MIN(launch)
          FROM Jaegers);

--     6. ����� ���-��� �� �������� model_name, mark, launch, kaiju_kill ��� �������,
--     ������� ���������� ������ ���� kaiju
\qecho 6. ����� ���-��� �� �������� model_name, mark, launch, kaiju_kill ��� �������,
\qecho ������� ���������� ������ ���� kaiju

SELECT model_name, mark, launch, kaiju_kill
  FROM Jaegers 
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill) AS max_kaiju_kill
          FROM Jaegers);

--     7. ����� �������� ���� �������, �������� ��� �� ���� ������ ����� �������
\qecho 7. ����� �������� ���� �������, �������� ��� �� ���� ������ ����� �������

SELECT CAST(AVG(weight) AS DECIMAL(15,3))
  FROM Jaegers;

--     8. ���������� �� ������� ���������� ������������ kaiju � ������������� �������,
--     � ����� ����������� �������
\qecho 8. ���������� �� ������� ���������� ������������ kaiju � ������������� �������,
\qecho � ����� ����������� �������

UPDATE Jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = '';

SELECT *
  FROM Jaegers
 WHERE status  = '';


--     9. �������� ������������ �������, � ����� ����� ����������
\qecho 9. �������� ������������ �������, � ����� ����� ����������
DELETE FROM Jaegers
 WHERE status  = '���������';

SELECT * FROM Jaegers;

-- ����� � �������
\o