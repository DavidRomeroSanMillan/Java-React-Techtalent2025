CREATE DATABASE investigadores

USE investigadores

CREATE TABLE facultades(
    id_facultad INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_facultad));

CREATE TABLE investigadores(
    dni VARCHAR(9),
    nom_apellido varchar (255),
    facultad INT,
    PRIMARY KEY (dni),
    FOREIGN KEY (facultad) REFERENCES facultades(id_facultad)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE equipos(
    num_serie CHAR(4) NOT NULL,
    nombre VARCHAR(100),
    facultad INT,
    PRIMARY KEY (num_serie),
    FOREIGN KEY (facultad) REFERENCES facultades(id_facultad)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE reservas(
    dni VARCHAR(9),
    num_serie CHAR(4),
    comienzo DATETIME,
    fin DATETIME,
    PRIMARY KEY (dni, num_serie),
    FOREIGN KEY (dni) REFERENCES investigadores(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (num_serie) REFERENCES equipos(num_serie)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);