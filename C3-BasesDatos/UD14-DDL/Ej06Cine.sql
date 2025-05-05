CREATE DATABASE cines

USE cines

CREATE TABLE peliculas(
    id_pelicula INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    calificacion_edad INT,
    PRIMARY KEY (id_pelicula));

CREATE TABLE salas(
    id_sala INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    pelicula INT,
    PRIMARY KEY (id_sala),
    FOREIGN KEY (pelicula) REFERENCES peliculas (id_pelicula)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);