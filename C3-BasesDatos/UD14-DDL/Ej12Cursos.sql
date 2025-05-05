CREATE DATABASE cursos

USE cursos

CREATE TABLE profesores(
    dni CHAR(9) NOT NULL,
    nombre VARCHAR (100),
    apellido1 VARCHAR(100),
    apellido2 VARCHAR(100),
    CONSTRAINT unique_nombre UNIQUE (nombre, apellido1, apellido2),
    direccion VARCHAR(100),
    titulo VARCHAR(100),
    gana INT NOT NULL,
    PRIMARY KEY (dni));

CREATE TABLE cursos(
    id_curso INT NOT NULL,
    nombre VARCHAR(100),
    dni_profesor CHAR(9),
    max_alumnos INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    CONSTRAINT fecha_crono CHECK (fecha_inicio < fecha_fin),
    num_horas INT NOT NULL,
    UNIQUE (nombre),
    PRIMARY KEY (id_curso),
    FOREIGN KEY (dni_profesor) REFERENCES profesores (dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE alumnos(
    dni CHAR(9) NOT NULL,
    nombre VARCHAR (100),
    apellido1 VARCHAR(100),
    apellido2 VARCHAR(100),
    direccion VARCHAR(100),
    sexo CHAR(1),
    CONSTRAINT sexo_alumno CHECK (sexo IN ('H', 'M')),
    fecha_nacimiento DATE,
    curso INT NOT NULL,
    PRIMARY KEY (dni),
    FOREIGN KEY (curso) REFERENCES cursos(id_curso)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);