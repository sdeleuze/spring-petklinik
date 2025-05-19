INSERT INTO vet (first_name, last_name) SELECT 'James', 'Carter' WHERE NOT EXISTS (SELECT * FROM vet WHERE id=1);
INSERT INTO vet (first_name, last_name) SELECT 'Helen', 'Leary' WHERE NOT EXISTS (SELECT * FROM vet WHERE id=2);
INSERT INTO vet (first_name, last_name) SELECT 'Linda', 'Douglas' WHERE NOT EXISTS (SELECT * FROM vet WHERE id=3);
INSERT INTO vet (first_name, last_name) SELECT 'Rafael', 'Ortega' WHERE NOT EXISTS (SELECT * FROM vet WHERE id=4);
INSERT INTO vet (first_name, last_name) SELECT 'Henry', 'Stevens' WHERE NOT EXISTS (SELECT * FROM vet WHERE id=5);
INSERT INTO vet (first_name, last_name) SELECT 'Sharon', 'Jenkins' WHERE NOT EXISTS (SELECT * FROM vet WHERE id=6);

INSERT INTO specialty (name) SELECT 'radiology' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='radiology');
INSERT INTO specialty (name) SELECT 'surgery' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='surgery'); 
INSERT INTO specialty (name) SELECT 'dentistry' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='dentistry');

INSERT INTO vet_specialty VALUES (2, 1) ON CONFLICT (vet, specialty) DO NOTHING;
INSERT INTO vet_specialty VALUES (3, 2) ON CONFLICT (vet, specialty) DO NOTHING;
INSERT INTO vet_specialty VALUES (3, 3) ON CONFLICT (vet, specialty) DO NOTHING;
INSERT INTO vet_specialty VALUES (4, 2) ON CONFLICT (vet, specialty) DO NOTHING;
INSERT INTO vet_specialty VALUES (5, 1) ON CONFLICT (vet, specialty) DO NOTHING;

INSERT INTO pet_type (name) SELECT 'cat' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='cat');
INSERT INTO pet_type (name) SELECT 'dog' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='dog');
INSERT INTO pet_type (name) SELECT 'lizard' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='lizard');
INSERT INTO pet_type (name) SELECT 'snake' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='snake');
INSERT INTO pet_type (name) SELECT 'bird' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='bird');
INSERT INTO pet_type (name) SELECT 'hamster' WHERE NOT EXISTS (SELECT * FROM specialty WHERE name='cat');

INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=1);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=2);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=3);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=4);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=5);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=6);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=7);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=8);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=9);
INSERT INTO owner (first_name, last_name, address, city, telephone) SELECT 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487' WHERE NOT EXISTS (SELECT * FROM owner WHERE id=10);

INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Leo', '2000-09-07', 1, 1 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=1);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Basil', '2002-08-06', 6, 2 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=2);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Rosy', '2001-04-17', 2, 3 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=3);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Jewel', '2000-03-07', 2, 3 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=4);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Iggy', '2000-11-30', 3, 4 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=5);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'George', '2000-01-20', 4, 5 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=6);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Samantha', '1995-09-04', 1, 6 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=7);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Max', '1995-09-04', 1, 6 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=8);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Lucky', '1999-08-06', 5, 7 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=9);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Mulligan', '1997-02-24', 2, 8 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=10);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Freddy', '2000-03-09', 5, 9 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=11);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Lucky', '2000-06-24', 2, 10 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=12);
INSERT INTO pet (name, birth_date, type_id, owner_id) SELECT 'Sly', '2002-06-08', 1, 10 WHERE NOT EXISTS (SELECT * FROM pet WHERE id=13);

INSERT INTO visit (pet_id, visit_date, description) SELECT 7, '2010-03-04', 'rabies shot' WHERE NOT EXISTS (SELECT * FROM visit WHERE id=1);
INSERT INTO visit (pet_id, visit_date, description) SELECT 8, '2011-03-04', 'rabies shot' WHERE NOT EXISTS (SELECT * FROM visit WHERE id=2);
INSERT INTO visit (pet_id, visit_date, description) SELECT 8, '2009-06-04', 'neutered' WHERE NOT EXISTS (SELECT * FROM visit WHERE id=3);
INSERT INTO visit (pet_id, visit_date, description) SELECT 7, '2008-09-04', 'spayed' WHERE NOT EXISTS (SELECT * FROM visit WHERE id=4);
