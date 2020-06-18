INSERT INTO user (id, nombre, username, password) VALUES(1,"Nicolas","nicolask","$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uty")
INSERT INTO user (id, nombre, username, password) VALUES(2,"Axel","axel","$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uty")
INSERT INTO user (id, nombre, username, password) VALUES(3,"Ulises","ulises","$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uty")
INSERT INTO user (id, nombre, username, password) VALUES(4,"Damian","damian","$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uty")
INSERT INTO user (id, nombre, username, password) VALUES(5,"Lucas","lucas","$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uty")

INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_ADMIN', 'ADMIN');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('3', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('4', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('5', '1');