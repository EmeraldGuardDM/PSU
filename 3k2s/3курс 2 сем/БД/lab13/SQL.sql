USE гостиница;

CREATE TABLE IF NOT EXISTS фирмы (
  Ид int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  Название char(30) NOT NULL
  );

CREATE TABLE IF NOT EXISTS гостиницы (
  Ид int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  Название char(30) NOT NULL,
  Страна char(30) NOT NULL,
  Класс tinyint(1) NOT NULL CHECK (Класс > 1 AND Класс < 6),
  КолЭтаж tinyint(1) NOT NULL CHECK (КолЭтаж > 0),
  КолКомнат int NOT NULL CHECK(КолКомнат > 0),
  КолМест int NOT NULL
);

CREATE TABLE IF NOT EXISTS номера(
  Ид int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ИдГостиницы int NOT NULL,
  этаж tinyint(2) NOT NULL CHECK (этаж > 0),
  корпус tinyint(1) NOT NULL CHECK (корпус > 0),
  местность tinyint(1) NOT NULL CHECK (местность > 0),
  CONSTRAINT ФК_гостн FOREIGN KEY(ИдГостиницы) REFERENCES гостиницы (Ид)
  );

CREATE TABLE IF NOT EXISTS брони(
  ИдБрони int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ИдГостиницы int NOT NULL,
  ИдФирмы int NOT NULL,
  КолМест int NOT NULL,
  Цена int NOT NULL CHECK(Цена > 500000),
  НоваяЦена int NULL CHECK (НоваяЦена > Цена),
  ДатаБрони int(11) NOT NULL,
  CONSTRAINT ФК_Гост FOREIGN KEY(ИдГостиницы) REFERENCES гостиницы (Ид),
  CONSTRAINT ФК_Фирма FOREIGN KEY(ИдФирмы) REFERENCES фирмы (Ид)
);

DROP TRIGGER IF EXISTS отм_брони;
CREATE TRIGGER отм_брони BEFORE DELETE ON брони
  FOR EACH ROW
  BEGIN
    IF @@timestamp + (3600*60*24*7) > OLD.ДатаБрони   THEN  
    BEGIN
        SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = "нельзя просто так взять и отменить бронь меньше чем за неделю"; 
    END;
    END IF;
  END;

DROP TRIGGER IF EXISTS под_брони;
CREATE TRIGGER под_брони BEFORE UPDATE ON брони
  FOR EACH ROW
  BEGIN
        IF NEW.Цена < OLD.Цена THEN
        BEGIN
          SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = "asd"; 
        END;
        END IF;
 END;

DROP PROCEDURE IF EXISTS коррекция;
CREATE PROCEDURE коррекция (IN процент float)
  BEGIN
    DECLARE нЦена int;
    SELECT б.Цена INTO нЦена;
    SET нЦена = нЦена + нЦена * процент;
END;

DROP PROCEDURE IF EXISTS поиск;
CREATE PROCEDURE поиск (IN назФирм char(30), начПер int(11), конецПер int(11))
  BEGIN
    SELECT ф.* FROM фирмы ф, брони б WHERE ф.Ид = б.ИдФирмы AND ф.Название = назФирм AND б.ДатаБрони BETWEEN начПер AND конецПер;
  END;

DROP PROCEDURE IF EXISTS выборка;
CREATE PROCEDURE выборка (IN вЦена int)
  BEGIN
    SELECT ф.* FROM фирмы ф, брони б WHERE ф.Ид = б.ИдФирмы AND б.Цена < вЦена;
  END;

DROP PROCEDURE IF EXISTS вычисления;
CREATE PROCEDURE вычисления (IN назФирм char(30))
  BEGIN
    SELECT SUM(б.Цена)/COUNT(б) FROM брони б WHERE б.ИдФирмы = (SELECT Ид FROM фирмы WHERE Название = назФирм);
  END;

DROP PROCEDURE IF EXISTS таблОтчет;
CREATE PROCEDURE таблОтчет ()
  BEGIN
  SELECT ф.* FROM фирмы ф, брони б GROUP BY б.КолМест ORDER BY ф.Название ASC INTO OUTFILE 'table.xls' FIELDS TERMINATED BY ','; 
  END;

DROP VIEW IF EXISTS картотека;
CREATE VIEW картотека AS SELECT ф.*, COUNT(б.ИдБрони) FROM фирмы ф, брони б WHERE б.ИдФирмы = ф.Ид  ORDER BY ф.Название LIMIT 5;

DROP VIEW IF EXISTS бр;
CREATE VIEW бр AS SELECT * FROM брони б ORDER BY б.ИдБрони;
DROP VIEW IF EXISTS стр;
CREATE VIEW стр AS SELECT * FROM гостиницы ORDER BY гостиницы.Страна;
DROP VIEW IF EXISTS фрм;
CREATE VIEW фрм AS SELECT * FROM фирмы ф ORDER BY ф.Название;
DROP VIEW IF EXISTS цн;
CREATE VIEW цн AS SELECT * FROM брони б  ORDER BY б.Цена;

DROP TRIGGER IF EXISTS инс_бронь;
CREATE TRIGGER инс_бронь BEFORE INSERT ON брони
  FOR EACH ROW
  BEGIN
  DECLARE пЦена int;
  DECLARE местн int;
  DECLARE корп int;
  SELECT NEW.Цена INTO пЦена;
  SET NEW.Цена = пЦена + (местн * 100000) + (корп * 250000); 
  END;