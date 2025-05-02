CREATE DATABASE estacion_meteo

USE estacion_meteo

CREATE TABLE estacion(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    lat VARCHAR(14) NOT NULL,
    longitud VARCHAR(15) NOT NULL,
    alt MEDIUMINT NOT NULL,
    PRIMARY KEY (id));


CREATE TABLE muestra (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    idestacion MEDIUMINT NOT NULL,
    fecha DATE NOT NULL,
    tempmin TINYINT,
    tempmax TINYINT,
    precip SMALLINT UNSIGNED,
    hummin TINYINT UNSIGNED,
    hummax TINYINT UNSIGNED,
    velmin TINYINT UNSIGNED,
    velmax TINYINT UNSIGNED,
    PRIMARY KEY (id),
    KEY (idestacion), FOREIGN KEY (idestacion)
    REFERENCES estacion (id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE);
