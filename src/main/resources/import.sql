-- ARTICLES
INSERT INTO article(name, model, branch, status) VALUES("Guitarra", "Les Paul", "Gibson", 1);
INSERT INTO article(name, model, branch, status) VALUES("Guitarra", "Stratocaster", "Fender", 1);
INSERT INTO article(name, model, branch, status) VALUES("Guitarra", "Basic", "Squire", 1);
INSERT INTO article(name, model, branch, status) VALUES("Bajo", "Basic", "Squire", 1);

-- USER
INSERT INTO user(email, password, role) VALUES("eric@gmail.com", "eric", "admin");
INSERT INTO user(email, password, role) VALUES("luis@gmail.com", "luis", "customer");
INSERT INTO user(email, password, role) VALUES("fabrizio@gmail.com", "fabrizio", "customer");
INSERT INTO user(email, password, role) VALUES("roberto@gmail.com", "roberto", "customer");

-- CUSTOMERS
INSERT INTO customer(name, last_name, phone, create_at, status) VALUES("Luis", "Alvarez", "2343234", NOW(), 1);
INSERT INTO customer(name, last_name, phone, create_at, status) VALUES("Fabrizio", "Saldivar", "1234556", NOW(), 1);
INSERT INTO customer(name, last_name, phone, create_at, status) VALUES("Roberto", "Fierros", "32432556", NOW(), 1);
INSERT INTO customer(name, last_name, phone, create_at, status) VALUES("Martin", "Garrix", "23482934", NOW(), 1);

-- SCHEDULE 
INSERT INTO schedule(start, end) VALUES("10:00", "11:00");
INSERT INTO schedule(start, end) VALUES("11:00", "12:00");
INSERT INTO schedule(start, end) VALUES("13:00", "14:00");
INSERT INTO schedule(start, end) VALUES("14:00", "15:00");

-- BRANCH OFFICE
INSERT INTO branch_office(name, length, latitud, status, address) VALUES("Sucursal Centro", 120.04324, 1240.2352305, 1, "Zona Centro Av Insurgentes #233");
INSERT INTO branch_office(name, length, latitud, status, address) VALUES("Sucursal Sur", 120.04324, 1240.2352305, 1, "Zona Sur Av Paseo del Chico #123");

-- ROOMS
INSERT INTO room(name, type, description, price_hour, status, branch_office_id) VALUES("Sala Pation Rococo", "Premium", "En un lugar de la mancha", 200, 1, 1);
INSERT INTO room(name, type, description, price_hour, status, branch_office_id) VALUES("Sala AC/DC", "Brack Diamon", "En un lugar de la mancha", 400, 1, 1);
INSERT INTO room(name, type, description, price_hour, status, branch_office_id) VALUES("Sala Last Dinosaurs", "Black Diamon", "En un lugar de la mancha", 400, 1, 2);
INSERT INTO room(name, type, description, price_hour, status, branch_office_id) VALUES("Sala Muse", "Premium", "En un lugar de la mancha", 200, 1, 2);

-- RESERVATIONS
INSERT INTO reservation(date, message, status, customer_id, room_id) VALUES(NOW(), "Hello World", 1, 1, 1);
INSERT INTO reservation(date, message, status, customer_id, room_id) VALUES(NOW(), "Deseo una coca de vidrio", 1, 2, 2);
INSERT INTO reservation(date, message, status, customer_id, room_id) VALUES(NOW(), "Llegare un poco tarde", 1, 1, 2);