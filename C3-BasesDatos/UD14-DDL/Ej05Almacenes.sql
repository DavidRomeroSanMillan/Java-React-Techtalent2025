CREATE DATABASE almacenes

USE almacenes

CREATE TABLE almacenes(
    id_almacenes INT NOT NULL AUTO_INCREMENT,
    lugar VARCHAR(100),
    capacidad INT,
    PRIMARY KEY (id_almacenes));

CREATE TABLE cajas(
    num_referencia CHAR(5) NOT NULL,
    contenido VARCHAR(100),
    valor INT,
    almacen INT,
    PRIMARY KEY (num_referencia),
    FOREIGN KEY (almacen) REFERENCES almacenes (id_almacenes)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);