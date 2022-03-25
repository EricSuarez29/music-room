
-- RESERVATIONS
INSERT INTO reservation(length, date, message, status) VALUES(130, NOW(), "Hello World", 1);
INSERT INTO reservation(length, date, message, status) VALUES(100, NOW(), "Deseo una coca de vidrio", 1);
INSERT INTO reservation(length, date, message, status) VALUES(80, NOW(), "Llegare un poco tarde", 1);

-- ARTICLES
INSERT INTO article(name, model, branch) VALUES("Guitarra", "Les Paul", "Gibson");
INSERT INTO article(name, model, branch) VALUES("Guitarra", "Stratocaster", "Fender");
INSERT INTO article(name, model, branch) VALUES("Guitarra", "Basic", "Squire");

-- USER
INSERT INTO user(email, password, role) VALUES("eric@gmail.com", "eric", "admin");
INSERT INTO user(email, password, role) VALUES("luis@gmail.com", "luis", "customer");
INSERT INTO user(email, password, role) VALUES("fabrizio@gmail.com", "fabrizio", "customer");

-- CUSTOMERS
INSERT INTO customer(name, lastName, phone, create_at) VALUES("Luis", "Alvarez", "2343234", NOW());
INSERT INTO customer(name, lastName, phone, create_at) VALUES("Fabrizio", "Saldivar", "1234556", NOW());

-- SCHEDULE 
INSERT INTO schedule(start, end) VALUES("10:00", "11:00");
INSERT INTO schedule(start, end) VALUES("11:00", "12:00");

-- BRANCH OFFICE
INSERT INTO branch_office(name, length, latitud, status, address) VALUES("Sucursal Centro", 120.04324, 1240.2352305, 1, "Zona Centro Av Insurgentes #233");
INSERT INTO branch_office(name, length, latitud, status, address) VALUES("Sucursal Sur", 120.04324, 1240.2352305, 1, "Zona Sur Av Paseo del Chico #123");

-- ROOMS
INSERT INTO room(name, type, description, price_hour, status, sucursal_id) VALUES("Sala Pation Rococo", "Premium", "En un lugar de la mancha", 200, 1, 1);
INSERT INTO room(name, type, description, price_hour, status, sucursal_id) VALUES("Sala Last Dinosaurs", "Black Diamon", "En un lugar de la mancha", 400, 1, 2);