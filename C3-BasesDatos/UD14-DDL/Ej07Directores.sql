CREATE DATABASE directores

USE directores

CREATE TABLE despachos(
    id_despacho INT NOT NULL AUTO_INCREMENT,
    capacidad INT,
    PRIMARY KEY (id_despacho));

CREATE TABLE directores(
    dni VARCHAR(9) NOT NULL,
    nom_apellido NVARCHAR(255),
    dni_jefe VARCHAR(9),
    despacho INT,
    PRIMARY KEY (dni),
    FOREIGN KEY (dni_jefe) REFERENCES directores(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (despacho) REFERENCES despachos (id_despacho)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);