-- вывод в текстовый файл protokol.txt
\o log_queries.txt

\qecho 1. вывод всей таблицы

SELECT *
  FROM Jaegers
 ORDER BY model_name;

\qecho 2. вывод только не уничтоженных роботов

SELECT *
  FROM Jaegers
 WHERE status = 'Ќе разрушен'
 ORDER BY model_name;

\qecho 3. вывод только роботов серии Mark-1 и Mark-4

SELECT *
  FROM Jaegers
 WHERE mark IN ('Mark-1', 'Mark-4')
 ORDER BY model_name;

\qecho 4. вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark

SELECT *
  FROM Jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

\qecho 5. вывод информации о самых старых роботах

SELECT *
  FROM Jaegers
 WHERE launch = 
       (SELECT MIN(launch)
          FROM Jaegers)
 ORDER BY model_name;

\qecho 6. вывод инф-ции из столбцов model_name, mark, launch, kaiju_kill тех роботов,
\qecho которые уничтожили больше всех kaiju

SELECT model_name, mark, launch, kaiju_kill
  FROM Jaegers 
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill) AS max_kaiju_kill
          FROM Jaegers)
 ORDER BY model_name;

\qecho 7. вывод среднего веса роботов, округлив его до трех знаков после зап€той

SELECT ROUND(AVG(weight),3) AS avg_weight
  FROM Jaegers;

--\qecho вариант второй
--SELECT CAST(AVG(weight) AS DECIMAL(15,3)) AS avg2_weight
--  FROM Jaegers;

\qecho 8. ”величение на единицу количество уничтоженных kaiju у неразрушенных роботов,
\qecho а затем отображение таблицы

UPDATE Jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = 'Ќе разрушен';

SELECT *
  FROM Jaegers
 WHERE status  = 'Ќе разрушен'
 ORDER BY model_name;


\qecho 9. ”даление уничтоженных роботов, а затем показ оставшихс€
DELETE FROM Jaegers
 WHERE status  = '”ничтожен';

SELECT * FROM Jaegers
 ORDER BY model_name;

-- вывод в консоль
\o