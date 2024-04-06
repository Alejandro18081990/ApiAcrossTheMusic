--Sentencias de inserción de prueba
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Alex@gmail.com','Alejandro','Núñez','Rodríguez',33,19,'Estudios_de_música',true);
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Raquel@gmail.com','Raquel','Romero','Reina',32,12,'Estudios_de_músicoterapia',true);

INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Metal_progresivo');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Rock');

INSERT IGNORE INTO INSTRUMENTO(nombre_instrumento) values ('Guitarra_eléctrica');
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Bateria");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Piano");

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(id_musico,id_instrumento) values (1,1);
INSERT IGNORE INTO MUSICO_TOCA_ESTILO(id_musico,id_estilo)values (1,1);
INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(id_musico,id_instrumento)values (2,2);
insert into musico_toca_estilo (id_musico,id_estilo) values (2,2);

