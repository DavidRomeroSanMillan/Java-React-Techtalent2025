CREATE DATABASE informatica

USE informatica

CREATE TABLE fabricantes(
    id_fabricante INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_fabricante));

CREATE TABLE articulos(
    id_articulo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio INT,
    fabricante INT NOT NULL,
    PRIMARY KEY (id_articulo),
    FOREIGN KEY (fabricante) REFERENCES fabricantes (id_fabricante)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);