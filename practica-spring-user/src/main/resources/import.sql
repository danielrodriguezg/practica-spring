INSERT INTO app_user(username, password, enabled, name, surname, email) VALUES ('admin','$2a$10$iJBCmsx1NJcKvwyaK3OVU.h/TnQc6PqibPqqxmt2f.dn7hcLfcdS.',1,'Administrador', 'Del Sistema', 'algo@gmail.com');
INSERT INTO app_user(username, password, enabled, name, surname, email) VALUES ('darodriguezg','$2a$10$B5bmHGMY8ikcAM46kiMYduot7Mn.BnQSs54lMzOo6KPrIpeFAKi5i',1,'Daniel Alejandro', 'Rodriguez Gomez', 'otro@gmail.com');

INSERT INTO role (name) VALUES ('Admin');
INSERT INTO role (name) VALUES ('User');

INSERT INTO app_user_roles (app_user_id, role_id) VALUES (1, 1);
INSERT INTO app_user_roles (app_user_id, role_id) VALUES (1, 2);
INSERT INTO app_user_roles (app_user_id, role_id) VALUES (2, 2);
