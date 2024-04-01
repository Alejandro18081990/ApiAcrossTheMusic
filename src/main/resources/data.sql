--Sentencias de inserción de prueba
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion)
	VALUES('Alex@gmail.com','Alejandro','Núñez','Rodríguez',33,19,'Estudios de música',true);
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Metal progresivo');
INSERT IGNORE INTO INSTRUMENTO(nombre_instrumento) values ('Guitarra eléctrica');
INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(id_musico,email,id_instrumento) values (1,"Alex@gmail.com",1);
INSERT IGNORE INTO MUSICO_TOCA_ESTILO(id_musico,email,id_estilo)values (1,"Alex@gmail.com",1);
