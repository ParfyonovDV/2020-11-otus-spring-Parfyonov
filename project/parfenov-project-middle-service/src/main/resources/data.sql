-- SCRIPT
insert into SCRIPT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR)
values (1, 'Кредитный договор для ЮЛ', 'ЮЛ','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ЮЛ','Иван Иванович');
insert into SCRIPT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR)
values (2, 'Кредитный договор для ИП', 'ИП','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ИП','Иван Иванович');
insert into SCRIPT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR)
values (3, 'Договор гарантии для ЮЛ', 'ЮЛ', 'Договор гарантии', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Договор гарантии для ЮЛ','Иван Иванович');
insert into SCRIPT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR)
values (4, 'Договор гарантии для ИП', 'ИП', 'Договор гарантии', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Договор гарантии для ИП','Иван Иванович');

--REPORT
insert into report (ID, AUTHOR, NAME, DATE_EXECUTE) values (1, 'Иван Иванович','Тестирование релиза 1','2021-01-01 00:00:00.000');
insert into report (ID, AUTHOR, NAME, DATE_EXECUTE) values (2, 'Иван Иванович','Тестирование релиза 2','2021-06-01 00:00:00.000');
insert into report (ID, AUTHOR, NAME, DATE_EXECUTE) values (3, 'Иван Иванович','Тестирование релиза 3','2021-10-01 00:00:00.000');

-- RESULT
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (1, 'Кредитный договор для ЮЛ', 'ЮЛ','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ЮЛ','Иван Иванович','FAIL');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (2, 'Кредитный договор для ИП', 'ИП','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ИП','Иван Иванович','OK');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (3, 'Кредитный договор для ЮЛ', 'ЮЛ','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ЮЛ','Иван Иванович','FAIL');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (4, 'Кредитный договор для ИП', 'ИП','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ИП','Иван Иванович','OK');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (5, 'Договор гарантии для ЮЛ', 'ЮЛ', 'Договор гарантии', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Договор гарантии для ЮЛ','Иван Иванович','OK');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (6, 'Кредитный договор для ЮЛ', 'ЮЛ','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ЮЛ','Иван Иванович','FAIL');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (7, 'Кредитный договор для ИП', 'ИП','Кредитный договор', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Кредитный договор для ИП','Иван Иванович','OK');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (8, 'Договор гарантии для ЮЛ', 'ЮЛ', 'Договор гарантии', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Договор гарантии для ЮЛ','Иван Иванович','OK');
insert into RESULT (ID, NAME, SCRIPT_KEY, DOC_NAME, DATE_CREATED, DATE_MODIFY, DATA, EXAMPLE, AUTHOR, RESULT)
values (9, 'Договор гарантии для ИП', 'ИП', 'Договор гарантии', '2021-01-01 00:00:00.000', '2021-01-01 00:00:00.000', '','Договор гарантии для ИП','Иван Иванович','OK');


insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (1, 1);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (1, 2);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (2, 3);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (2, 4);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (2, 5);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (3, 6);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (3, 7);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (3, 8);
insert into REPORT_RESULT(REPORT_ID, RESULT_ID) values (3, 9);