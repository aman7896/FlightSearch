INSERT INTO airport (id, code) VALUES ( 1, 'DEL');
INSERT INTO airport (id, code) VALUES ( 2, 'BLR');
INSERT INTO airport (id, code) VALUES ( 3, 'MAA');
INSERT INTO airport (id, code) VALUES ( 4, 'JFK');
INSERT INTO airport (id, code) VALUES ( 5, 'AMS');
INSERT INTO airport (id, code) VALUES ( 6, 'DXB');

INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 1, 'IND0001', 'DEL', 'BLR', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 2, 'IND0002', 'BLR', 'DEL', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 3, 'IND0003', 'DEL', 'MAA', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 4, 'IND0004', 'MAA', 'DEL', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 5, 'IND0005', 'MAA', 'BLR', 7200000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 6, 'IND0006', 'BLR', 'MAA', 7200000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 7, 'KLM0001', 'DEL', 'JFK', 64800000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 8, 'KLM0002', 'JFK', 'DEL', 64800000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 9, 'KLM0003', 'DEL', 'DXB', 12600000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 10, 'KLM0004', 'DXB', 'DEL', 12600000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 11, 'KLM0005', 'DEL', 'AMS', 27000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES ( 12, 'KLM0006', 'AMS', 'DEL', 27000000);

