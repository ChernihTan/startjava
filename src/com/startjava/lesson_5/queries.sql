-- ����� � ��������� ���� protokol.txt
\o log_queries.txt

\qecho 1. ����� ���� �������

SELECT *
  FROM Jaegers
 ORDER BY model_name;

\qecho 2. ����� ������ �� ������������ �������

SELECT *
  FROM Jaegers
 WHERE status = '�� ��������'
 ORDER BY model_name;

\qecho 3. ����� ������ ������� ����� Mark-1 � Mark-4

SELECT *
  FROM Jaegers
 WHERE mark IN ('Mark-1', 'Mark-4')
 ORDER BY model_name;

\qecho 4. ����� ���� �������, ����� Mark-1 � Mark-4, ������������ ������� �� �������� �� ������� mark

SELECT *
  FROM Jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

\qecho 5. ����� ���������� � ����� ������ �������

SELECT *
  FROM Jaegers
 WHERE launch = 
       (SELECT MIN(launch)
          FROM Jaegers)
 ORDER BY model_name;

\qecho 6. ����� ���-��� �� �������� model_name, mark, launch, kaiju_kill ��� �������,
\qecho ������� ���������� ������ ���� kaiju

SELECT model_name, mark, launch, kaiju_kill
  FROM Jaegers 
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill) AS max_kaiju_kill
          FROM Jaegers)
 ORDER BY model_name;

\qecho 7. ����� �������� ���� �������, �������� ��� �� ���� ������ ����� �������

SELECT ROUND(AVG(weight),3) AS avg_weight
  FROM Jaegers;

--\qecho ������� ������
--SELECT CAST(AVG(weight) AS DECIMAL(15,3)) AS avg2_weight
--  FROM Jaegers;

\qecho 8. ���������� �� ������� ���������� ������������ kaiju � ������������� �������,
\qecho � ����� ����������� �������

UPDATE Jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = '�� ��������';

SELECT *
  FROM Jaegers
 WHERE status  = '�� ��������'
 ORDER BY model_name;


\qecho 9. �������� ������������ �������, � ����� ����� ����������
DELETE FROM Jaegers
 WHERE status  = '���������';

SELECT * FROM Jaegers
 ORDER BY model_name;

-- ����� � �������
\o