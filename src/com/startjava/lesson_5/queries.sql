-- вывод в текстовый файл protokol.txt
\o log_queries.txt

--     1. вывод всей таблицы
\qecho 1. вывод всей таблицы

SELECT *
  FROM Jaegers;

--     2. вывод только не уничтоженных роботов
\qecho 2. вывод только не уничтоженных роботов

SELECT *
  FROM Jaegers
 WHERE status = '';

--     3. вывод только роботов серии Mark-1 и Mark-4
\qecho 3. вывод только роботов серии Mark-1 и Mark-4

SELECT *
  FROM Jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');

--     4. вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark
\qecho 4. вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark

SELECT *
  FROM Jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

--     5. вывод информации о самых старых роботах
\qecho 5. вывод информации о самых старых роботах

SELECT *
  FROM Jaegers
 WHERE launch = 
       (SELECT MIN(launch)
          FROM Jaegers);

--     6. вывод инф-ции из столбцов model_name, mark, launch, kaiju_kill тех роботов,
--     которые уничтожили больше всех kaiju
\qecho 6. вывод инф-ции из столбцов model_name, mark, launch, kaiju_kill тех роботов,
\qecho которые уничтожили больше всех kaiju

SELECT model_name, mark, launch, kaiju_kill
  FROM Jaegers 
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill) AS max_kaiju_kill
          FROM Jaegers);

--     7. вывод среднего веса роботов, округлив его до трех знаков после запятой
\qecho 7. вывод среднего веса роботов, округлив его до трех знаков после запятой

SELECT CAST(AVG(weight) AS DECIMAL(15,3))
  FROM Jaegers;

--     8. Увеличение на единицу количество уничтоженных kaiju у неразрушенных роботов,
--     а затем отображение таблицы
\qecho 8. Увеличение на единицу количество уничтоженных kaiju у неразрушенных роботов,
\qecho а затем отображение таблицы

UPDATE Jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = '';

SELECT *
  FROM Jaegers
 WHERE status  = '';


--     9. Удаление уничтоженных роботов, а затем показ оставшихся
\qecho 9. Удаление уничтоженных роботов, а затем показ оставшихся
DELETE FROM Jaegers
 WHERE status  = 'Уничтожен';

SELECT * FROM Jaegers;

-- вывод в консоль
\o