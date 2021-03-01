USE ферма
CREATE TABLE IF NOT EXISTS паспорт (
  Название varchar(255) NOT NULL PRIMARY KEY,
  Тип varchar(255) NOT NULL,
  ДатаПостройки date,
  Водоизмещение int
  );

CREATE TABLE IF NOT EXISTS должность(
  КодДолжности int UNSIGNED PRIMARY KEY,
  Название varchar(255) NOT NULL);

CREATE TABLE IF NOT EXISTS Банка(
  idБанка int UNSIGNED PRIMARY KEY,
  ДатаПрихода date,
  ДатаОтплытия date);

CREATE TABLE IF NOT EXISTS команда(
  idКоманда int UNSIGNED PRIMARY KEY,
  КодДолжность int UNSIGNED,
  Фамилия varchar(255) NOT NULL,
  Имя varchar(255) NOT NULL,
  Отчество varchar(255) NOT NULL,
  адрес varchar(255) NOT NULL,
  CONSTRAINT FOREIGN KEY(КодДолжность) REFERENCES должность(КодДолжности)
  );

  CREATE TABLE IF NOT EXISTS регистрация(
  idРегистрация int UNSIGNED PRIMARY KEY,
  idКоманда int UNSIGNED,
  КодДолжность int UNSIGNED,
  Название varchar(255) NOT NULL,
  ДатаВыхода date,
  ДатаВозвращения date,
  CONSTRAINT FOREIGN KEY(idКоманда) REFERENCES команда(idКоманда),
  CONSTRAINT FOREIGN KEY(КодДолжность) REFERENCES команда(КодДолжность),
  CONSTRAINT FOREIGN KEY(Название) REFERENCES паспорт(Название)
);

CREATE TABLE IF NOT EXISTS СписокБанок(
idБанка int UNSIGNED,
  idСписок int UNSIGNED PRIMARY KEY,
  idРегистрация int UNSIGNED,
  idКоманда int UNSIGNED,
  КодДолжность int UNSIGNED,
  Название varchar(255),
  CONSTRAINT FOREIGN KEY(idБанка) REFERENCES Банка(idБанка),
  CONSTRAINT FOREIGN KEY(idРегистрация) REFERENCES регистрация(idРегистрация),
  CONSTRAINT FOREIGN KEY(idКоманда) REFERENCES команда(idКоманда),
  CONSTRAINT FOREIGN KEY(КодДолжность) REFERENCES должность(КодДолжности),
  CONSTRAINT FOREIGN KEY(Название) REFERENCES регистрация(Название)
  );

CREATE TABLE IF NOT EXISTS улов(
  idБанка int UNSIGNED,
  idСписок int UNSIGNED,
  idРегистрация int UNSIGNED,
  idКоманда int UNSIGNED,
  КодДолжность int UNSIGNED,
  Название varchar(255) NOT NULL,
  Сорт varchar(255) NOT NULL,
  Вес int UNSIGNED,
  CONSTRAINT FOREIGN KEY(idБанка) REFERENCES СписокБанок(idБанка),
  CONSTRAINT FOREIGN KEY(idСписок) REFERENCES СписокБанок(idСписок),
  CONSTRAINT FOREIGN KEY(idРегистрация) REFERENCES СписокБанок(idРегистрация),
  CONSTRAINT FOREIGN KEY(idКоманда) REFERENCES СписокБанок(idКоманда),
  CONSTRAINT FOREIGN KEY(КодДолжность) REFERENCES СписокБанок(КодДолжность),
  CONSTRAINT FOREIGN KEY(Название) REFERENCES СписокБанок(Название)
);

