-- вывод в текстовый файл protokol.txt
--\o protokol.txt

-- вывод всей таблицы
\qecho 6.1. display the full table
\qecho SELECT * FROM Jaegers;
\qecho
SELECT * FROM Jaegers;

-- вывод только не уничтоженных роботов
\qecho  6.2. display undestroyed robots
\qecho SELECT * FROM Jaegers WHERE status = '''''';
\qecho
SELECT * FROM Jaegers WHERE status = '';

-- вывод только роботов серии Mark-1 и Mark-4
\qecho  6.3. output of the Mark-1 and Mark-4 series robots only
\qecho SELECT * FROM Jaegers WHERE mark = '''Mark-1''' OR mark = '''Mark-4''';
\qecho
SELECT * FROM Jaegers WHERE mark = 'Mark-1' OR mark = 'Mark-4';

\qecho SELECT * FROM jaegers WHERE mark IN ('''Mark-1''', '''Mark-4''');
\qecho
SELECT * FROM Jaegers WHERE mark IN ('Mark-1', 'Mark-4');

--вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark
\qecho  6.4. output all robots except Mark-1 and Mark-4, sorting the table in descending order by the mark column
\qecho SELECT * FROM Jaegers WHERE mark NOT IN ('''Mark-1''', '''Mark-4''') ORDER BY mark DESC;
\qecho
SELECT * FROM Jaegers WHERE mark NOT IN ('Mark-1', 'Mark-4') ORDER BY mark DESC;

--5.вывод информации о самых старых роботах
\qecho  6.5. display information about the oldest robots
\qecho SELECT * FROM Jaegers WHERE launch = (SELECT MIN(launch) FROM Jaegers);
\qecho
SELECT * FROM Jaegers WHERE launch = (SELECT MIN(launch) FROM Jaegers);

--6.вывод инф-ции из столбцов model_name, mark, launch, kaiju_kill тех роботов,
-- которые уничтожили больше всех kaiju
\qecho  6.6. the information of those robots that have destroyed the most kaiju
\qecho SELECT model_name, mark, launch, kaiju_kill FROM Jaegers WHERE
\qecho kaiju_kill = (SELECT MAX(kaiju_kill) FROM Jaegers);
\qecho

SELECT model_name, mark, launch, kaiju_kill FROM Jaegers WHERE
kaiju_kill = (SELECT MAX(kaiju_kill) FROM Jaegers);

--7. вывод среднего веса роботов, округлив его до трех знаков после запятой
\qecho  6.7. average robot weight output, rounded to three decimal places
\qecho SELECT CAST(AVG(weight) AS DECIMAL(15,3)) FROM Jaegers;

SELECT CAST(AVG(weight) AS DECIMAL(15,3)) FROM Jaegers;
\qecho

--8. Увеличение на единицу количество уничтоженных kaiju у неразрушенных роботов,
-- а затем отображение таблицы
\qecho  6.8. An increment by one in the number of destroyed kaiju in undestroyed robots,
\qecho  and then displaying a table
\qecho UPDATE Jaegers SET kaiju_kill = kaiju_kill + 1 WHERE status = '''''';
\qecho SELECT * FROM Jaegers WHERE status  = '''''';

UPDATE Jaegers SET kaiju_kill = kaiju_kill + 1
WHERE status = '';
SELECT * FROM Jaegers WHERE status  = '';
\qecho

--9. Удаление уничтоженных роботов, а затем показ оставшихся
\qecho  6.9. Removing the destroyed robots and then displaying the remaining ones
\qecho DELETE FROM Jaegers WHERE status  = 'Destroyed ';
\qecho SELECT * FROM Jaegers;

DELETE FROM Jaegers WHERE status  = 'Уничтожен';
SELECT * FROM Jaegers;

-- вывод в консоль
\o
