CREATE DATABASE empleados

USE empleados

CREATE TABLE departamentos(
    id_departamento INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    presupuesto INT,
    PRIMARY KEY (id_departamento));

CREATE TABLE empleados(
    dni VARCHAR(8) NOT NULL,
    nombre VARCHAR(100),
    apellidos VARCHAR(255),
    departamento INT,
    PRIMARY KEY (dni),
    FOREIGN KEY (departamento) REFERENCES departamentos (id_departamento)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);


