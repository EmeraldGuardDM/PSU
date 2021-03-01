USE ферма;
DELETE FROM mysql.proc WHERE db = 'ферма' AND type = 'PROCEDURE';
CREATE PROCEDURE z1 (тип varchar(255), датНач date, датКонец date)
  BEGIN
  SELECT п.Название, р.ДатаВыхода, у.Вес FROM паспорт п, регистрация р, улов у 
    WHERE п.Тип = тип AND р.ДатаВыхода BETWEEN датНач AND датКонец AND у.idРегистрация = р.idРегистрация AND п.Название = р.Название;
  END;

CREATE PROCEDURE z2 (датНач date, датКонец date)
  BEGIN
  SELECT у.Сорт, у.Вес, у.Название FROM улов у, регистрация р 
    WHERE у.Вес = (
      SELECT MAX(у1.Вес) FROM улов у1 WHERE у1.Сорт = у.Сорт) 
    AND у.idРегистрация = р.idРегистрация AND р.ДатаВыхода BETWEEN датНач AND датКонец GROUP BY у.Сорт ORDER BY р.ДатаВыхода ASC;   
  END;

CREATE PROCEDURE z3 (датНач date, датКонец date)
  BEGIN
  SELECT б.idБанка, SUM(у.Вес)/COUNT(у.idБанка) AS среднийУлов, с.Название AS списокКатеров FROM банка б, улов у, списокбанок с 
    WHERE у.idБанка = б.idБанка AND с.idБанка = б.idБанка AND б.ДатаОтплытия BETWEEN датНач AND датКонец GROUP BY б.idБанка;
  END;

CREATE PROCEDURE z4 (банка int)
  BEGIN
  SELECT у.idБанка, р.Название FROM регистрация р, улов у 
    WHERE р.idРегистрация = у.idРегистрация AND у.idБанка = банка AND у.Вес > (
      SELECT SUM(у1.Вес)/COUNT(у1.idБанка) FROM улов у1 WHERE у1.idБанка = банка) GROUP BY у.idБанка;
  END;

CREATE PROCEDURE z5 (датНач date, датКонец date)
  BEGIN
  SELECT у.Сорт, р.idРегистрация, р.ДатаВыхода, р.ДатаВозвращения, у.Вес FROM улов у, регистрация р 
    WHERE р.ДатаВыхода >= датНач AND р.ДатаВозвращения <= датКонец AND у.idРегистрация = р.idРегистрация GROUP BY у.Сорт;
  END;

CREATE PROCEDURE z6 (банка int, сорт varchar(255))
  BEGIN
  SELECT р.idРегистрация, SUM(у.Вес) FROM регистрация р, улов у WHERE у.idРегистрация = р.idРегистрация AND у.idБанка = банка AND у.Сорт = сорт ORDER BY SUM(у.вес) DESC;
  END;