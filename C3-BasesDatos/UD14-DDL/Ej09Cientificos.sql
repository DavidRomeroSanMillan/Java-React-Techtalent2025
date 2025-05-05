CREATE DATABASE cientificos

USE cientificos

CREATE TABLE cientificos(
    dni VARCHAR(9) NOT NULL,
    nom_apellido VARCHAR(255),
    PRIMARY KEY (dni));

CREATE TABLE proyectos(
    id_proyecto CHAR(4),
    nombre VARCHAR(255),
    horas INT,
    PRIMARY KEY (id_proyecto));

CREATE TABLE asignado_a(
    cientifico VARCHAR(9),
    proyecto CHAR(4),
    PRIMARY KEY (cientifico, proyecto),
    FOREIGN KEY (cientifico) REFERENCES cientificos(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (proyecto) REFERENCES proyectos(id_proyecto)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);