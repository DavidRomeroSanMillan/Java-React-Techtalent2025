CREATE DATABASE proveedores

USE proveedores

CREATE TABLE piezas(
    id_pieza INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_pieza));

CREATE TABLE proveedores(
    id_proveedor CHAR(4),
    nombre VARCHAR(100),
    PRIMARY KEY (id_proveedor));

CREATE TABLE suministra(
    precio INT,
    codigo_pieza INT,
    codigo_proveedor CHAR (4),
    PRIMARY KEY (codigo_pieza, codigo_proveedor),
    FOREIGN KEY (codigo_pieza) REFERENCES piezas(id_pieza)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (codigo_proveedor) REFERENCES proveedores (id_proveedor)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);