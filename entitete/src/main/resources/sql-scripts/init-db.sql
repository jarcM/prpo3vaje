INSERT INTO uporabnik (ime, priimek) VALUES ('Petra', 'Kos');
INSERT INTO uporabnik (ime, priimek) VALUES ('Miha', 'Novak');
INSERT INTO uporabnik (ime, priimek) VALUES ('Nika', 'Novak');
INSERT INTO prostor (trenutnaZasedenost, dovoljenoStObiskovalcev) VALUES (69, 420);
INSERT INTO prostor (trenutnaZasedenost, dovoljenoStObiskovalcev) VALUES (5, 7);
INSERT INTO prehodi(id_vhoda, id_izhoda, casVstopa, casIzstopa, uporabnik_id, prostor_id) VALUES (1,2,'12:05','15:04', 1, 1);
INSERT INTO prehodi(id_vhoda, id_izhoda, casVstopa, casIzstopa, uporabnik_id, prostor_id) VALUES (2,1,'12:05','15:04', 2, 2);
INSERT INTO prehodi(id_vhoda, id_izhoda, casVstopa, casIzstopa, uporabnik_id, prostor_id) VALUES (2,1,'12:05','15:04', 2, 1);
INSERT INTO prehodi(id_vhoda, id_izhoda, casVstopa, casIzstopa, uporabnik_id, prostor_id) VALUES (2,1,'12:05','15:04', 3, 1);
