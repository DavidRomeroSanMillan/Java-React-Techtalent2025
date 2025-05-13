INSERT INTO peliculas (nombre, calificacion_edad) VALUES
('Titanic', 13), ('Avatar', 7), ('Event Horizon', 13), ('Wild Robot', 3),
('Madagascar', 3), ('As Above So Below', 18), ('Sharknado', 18), ('Sharknado 2', 7);

INSERT INTO peliculas (nombre) VALUES
('The Substance'), ('Watership Down');

INSERT INTO salas (nombre, pelicula) VALUES
('3D', 8), ('3D DOLBY', 8), ('4D ULTRAHD', 7), ('Normal', 1), ('HD', 7), 
('DOLBY SURROUND', 10), ('Sharknado', 5);

INSERT INTO salas (nombre) VALUES
('4D'), ('5D'), ('6D');

-- 4.1. Mostrar el nombre de todas las películas.
SELECT nombre FROM peliculas;

-- 4.2. Mostrar las distintas calificaciones de edad que existen.
SELECT calificacion_edad FROM peliculas GROUP BY calificacion_edad;

-- 4.3. Mostrar todas las películas que no han sido calificadas.
SELECT * FROM peliculas WHERE calificacion_edad IS NULL;

-- 4.4. Mostrar todas las salas que no proyectan ninguna película.
SELECT * FROM salas WHERE pelicula IS NULL;

-- 4.5. Mostrar la información de todas las salas y, si se proyecta
-- alguna película en la sala, mostrar también la información de la película.
SELECT id_sala, s.nombre, pelicula, p.nombre, calificacion_edad FROM salas s INNER JOIN peliculas p ON id_pelicula=pelicula;

-- 4.6. Mostrar la información de todas las películas y, si se proyecta
-- en alguna sala, mostrar también la información de la sala.
SELECT p.nombre, calificacion_edad, id_sala, s.nombre 
FROM peliculas p 
INNER JOIN salas s 
ON id_pelicula=pelicula;

-- 4.7. Mostrar los nombres de las películas que no se proyectan en ninguna sala.
SELECT p.nombre FROM peliculas p LEFT JOIN salas s ON p.id_pelicula=s.pelicula WHERE s.pelicula IS NULL;

-- 4.8. Añadir una nueva película 'Uno, Dos, Tres', para mayores de 7 años.
INSERT INTO peliculas (nombre, calificacion_edad) VALUES
('Un, Dos, Tres', 7);

-- 4.9. Hacer constar que todas las películas no calificadas han sido calificadas para mayores de 13.
UPDATE peliculas SET calificacion_edad=13 WHERE calificacion_edad IS NULL;

-- 4.10. Eliminar todas las salas que proyectan películas recomendadas para todos los públicos.
DELETE FROM salas WHERE pelicula IN (SELECT id_pelicula FROM peliculas WHERE calificacion_edad=3);