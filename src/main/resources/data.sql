--Sentencias de inserción de prueba
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Alex@gmail.com','Alejandro','Núñez','Rodríguez',33,19,'Estudios_de_música',true);
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Raquel@gmail.com','Raquel','Romero','Reina',32,12,'Estudios_de_músicoterapia',true);	
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Noah@gmail.com','Noah','Rivera','Núñez',11,2,'Musica_cole',true);	
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Leoh@gmail.com','Leo','Rivera','Núñez',15,2,'Musica_cole',true);	
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Lucia@gmail.com','Lucia','Rodríguez','Ramos',67,10,'-',false);	
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Manolo@gmail.com','Manolo','Núñez','Lopez',74,20,'-',false);	
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Esther@gmail.com','Esther','Núñez','Rodríguez',48,20,'Estudios_de_música',true);
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Pluk@gmail.com','Jose Luis','Núñez','Rodríguez',33,19,'Estudios_de_música',true);

--11 estilos
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Metal_progresivo');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Rock');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Pop');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Heavy_metal_clasico');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Jazz');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Funk');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Soul');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Musica_clasica');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Flamenco');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Rap');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Blues');
--11 instrumentos
INSERT IGNORE INTO INSTRUMENTO(nombre_instrumento) values ('Guitarra_eléctrica');
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Bateria");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Piano");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Guitarra_clasica");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Guitarra_espaniola");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Guitarra_espaniola");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Bajo");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Violin");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Contrabajo");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Clarinete");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Tuba");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Trompeta");

INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamMetalera",1, ('2024-08-18 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamMetaleraClasica",4, ('2024-08-18 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamJazzera",5, ('2024-08-19 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamPopera",3, ('2024-08-28 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamBlusera",9, ('2024-08-10 22:00:00'));

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento) values (1,1);
INSERT IGNORE INTO MUSICO_TOCA_ESTILO(musico,estilo)values (1,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (2,2);
insert into musico_toca_estilo (musico,estilo) values (2,2);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (3,5);
insert into musico_toca_estilo (musico,estilo) values (3,6);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (4,5);
insert into musico_toca_estilo (musico,estilo) values (4,3);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (5,9);
insert into musico_toca_estilo (musico,estilo) values (5,6);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (6,3);
insert into musico_toca_estilo (musico,estilo) values (6,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (7,3);
insert into musico_toca_estilo (musico,estilo) values (7,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (8,3);
insert into musico_toca_estilo (musico,estilo) values (8,1);

INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(1,1);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(2,2);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(3,3);