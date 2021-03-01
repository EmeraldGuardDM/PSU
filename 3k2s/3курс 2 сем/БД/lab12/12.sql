USE ферма
INSERT INTO паспорт  VALUES ('1', '1', CURDATE(), 100);
INSERT INTO паспорт  VALUES ('2', '2', DATE_ADD(CURDATE(), INTERVAL -1 DAY), 200);
INSERT INTO паспорт  VALUES ('3', '3', DATE_ADD(CURDATE(), INTERVAL -2 DAY), 300);

INSERT INTO должность  VALUES (0, 'Должность1');
INSERT INTO должность  VALUES (1, 'Должность2');
INSERT INTO должность  VALUES (2, 'Должность3');

INSERT INTO банка  VALUES (0, DATE_ADD(CURDATE(), INTERVAL +2 DAY), CURDATE());
INSERT INTO банка  VALUES (1, DATE_ADD(CURDATE(), INTERVAL +3 DAY), CURDATE());
INSERT INTO банка  VALUES (2, DATE_ADD(CURDATE(), INTERVAL +4 DAY), CURDATE());

INSERT INTO команда  VALUES (0, 0, '1', '1', '1', '1');
INSERT INTO команда  VALUES (1, 1, '1', '1', '1', '1');
INSERT INTO команда  VALUES (2, 2, '1', '1', '1', '1');

INSERT INTO регистрация  VALUES (0, 0, 0, '1', CURDATE(), DATE_ADD(CURDATE(), INTERVAL +2 DAY));
INSERT INTO регистрация  VALUES (1, 1, 1, '2', CURDATE(), DATE_ADD(CURDATE(), INTERVAL +3 DAY));
INSERT INTO регистрация  VALUES (2, 2, 2, '3', CURDATE(), DATE_ADD(CURDATE(), INTERVAL +4 DAY));

INSERT INTO списокбанок  VALUES (0, 0, 0, 0, 0, '1');
INSERT INTO списокбанок  VALUES (1, 1, 1, 1, 1, '2');
INSERT INTO списокбанок  VALUES (2, 2, 2, 2, 2, '3');

INSERT INTO улов  VALUES (0, 0, 0, 0, 0, '1', 'Сорт1', 1000);
INSERT INTO улов  VALUES (1, 1, 1, 1, 1, '2', 'Сорт2', 2000);
INSERT INTO улов  VALUES (2, 2, 2, 2, 2, '3', 'Сорт3', 3000);

