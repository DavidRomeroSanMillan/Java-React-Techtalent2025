CREATE DATABASE biblioteca

USE biblioteca

CREATE TABLE tema(
    id_tema INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40),
    PRIMARY KEY (id_tema));

CREATE TABLE autor(
    id_autor INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60),
    PRIMARY KEY (id_autor));

CREATE TABLE editorial(
    id_editorial INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(15),
    PRIMARY KEY (id_editorial));

CREATE TABLE libro(
    id_libro INT NOT NULL AUTO_INCREMENT,
    id_editorial INT NOT NULL,
    titulo VARCHAR(60),
    idioma VARCHAR(15),
    formato VARCHAR(15),
    PRIMARY KEY (id_libro),
    FOREIGN KEY (id_editorial) REFERENCES editorial (id_editorial)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE ejemplar(
    id_ejemplar INT NOT NULL AUTO_INCREMENT,
    id_libro INT NOT NULL,
    num_orden INT,
    edicion INT,
    ubicacion VARCHAR(15),
    categoria CHAR,
    PRIMARY KEY(id_ejemplar),
    FOREIGN KEY (id_libro) REFERENCES libro (id_libro)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE socio(
    id_socio INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(15),
    PRIMARY KEY (id_socio));

CREATE TABLE prestamo(
    id_ejemplar INT NOT NULL,
    id_socio INT NOT NULL,
    num_orden INT,
    edicion INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    notas BLOB,
    FOREIGN KEY (id_socio) REFERENCES socio (id_socio)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplar (id_ejemplar)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE trata_sobre(
    id_libro INT NOT NULL,
    id_tema INT NOT NULL,
    FOREIGN KEY (id_libro) REFERENCES libro (id_libro)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (id_tema) REFERENCES tema (id_tema)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE escrito_por(
    id_libro INT NOT NULL,
    id_autor INT NOT NULL,
    FOREIGN KEY (id_libro) REFERENCES libro (id_libro)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    FOREIGN KEY (id_autor) REFERENCES autor (id_autor)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);


