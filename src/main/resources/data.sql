INSERT INTO airport (id, code) VALUES ( default, 'DEL');
INSERT INTO airport (id, code) VALUES ( default, 'BLR');
INSERT INTO airport (id, code) VALUES ( default, 'MAA');
INSERT INTO airport (id, code) VALUES ( default, 'JFK');
INSERT INTO airport (id, code) VALUES ( default, 'AMS');
INSERT INTO airport (id, code) VALUES ( default, 'DXB');

INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'IND0001', 'DEL', 'BLR', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'IND0002', 'BLR', 'DEL', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'IND0003', 'DEL', 'MAA', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'IND0004', 'MAA', 'DEL', 9000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'IND0005', 'MAA', 'BLR', 7200000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'IND0006', 'BLR', 'MAA', 7200000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'KLM0001', 'DEL', 'JFK', 64800000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'KLM0002', 'JFK', 'DEL', 64800000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'KLM0003', 'DEL', 'DXB', 12600000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'KLM0004', 'DXB', 'DEL', 12600000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'KLM0005', 'DEL', 'AMS', 27000000);
INSERT INTO flight (id, flightnumber, origin_code, destination_code, duration) VALUES (default, 'KLM0006', 'AMS', 'DEL', 27000000);

