CREATE DATABASE grandes_almacenes

USE grandes_almacenes

CREATE TABLE cajeros(
    id_cajero INT NOT NULL,
    nom_apellido VARCHAR(255),
    PRIMARY KEY (id_cajero));

CREATE TABLE productos(
    id_producto INT NOT NULL,
    nombre VARCHAR(100),
    precio INT,
    PRIMARY KEY (id_producto));

CREATE TABLE maquinas_registradoras(
    id_caja INT NOT NULL AUTO_INCREMENT,
    piso INT,
    PRIMARY KEY (id_caja));

CREATE TABLE venta(
    cajero INT,
    producto INT,
    caja INT,
    PRIMARY KEY (cajero, producto, caja),
    FOREIGN KEY (cajero) REFERENCES cajeros(id_cajero)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (producto) REFERENCES productos (id_producto)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (caja) REFERENCES maquinas_registradoras (id_caja)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);