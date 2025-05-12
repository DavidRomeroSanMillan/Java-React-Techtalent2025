INSERT INTO fabricantes (nombre) VALUES
    ('Nvidia'), ('AMD'), ('Intel'), ('Qualcomm'), ('Apple'), 
    ('Samsung'), ('ARM'), ('ASUS'), ('MediaTek'), ('IBM');

INSERT INTO articulos (nombre, precio, fabricante) VALUES
    ('Pantalla', 120, 3),
    ('Memoria RAM', 60, 2),
    ('Ventilador', 50, 5),
    ('Luces LED', 25, 8),
    ('Tarjeta gráfica', 400, 9),
    ('Fuente de alimentación', 90, 4),
    ('Horno inteligente', 550, 6),
    ('Consola de videojuego', 650, 1),
    ('Ordenador portátil', 840, 8),
    ('Disco duro SSD', 175, 7);
--Ej 1.1. Obtener los nombres de los productos de la tienda.
SELECT nombre FROM articulos;

--Ej 1.2. Obtener los nombres y los precios de los productos de la tienda.
SELECT nombre, precio FROM articulos;

--Ej 1.3. Obtener el nombre de los productos cuyo precio seya igual o inferior a 200.
SELECT nombre FROM articulos WHERE precio <= 200;

--Ej 1.4. Obtener todos los datos de los artículos cuyo precio esté entre los 60 y 120 (ambos incluidos)
SELECT * FROM articulos WHERE precio BETWEEN 60 AND 120;

--Ej 1.5. Obtener el nombre y el precio en pesetas (precio * 166'386).
SELECT nombre, precio*166.386 AS 'Precio en pesetas' FROM articulos;

--Ej 1.6. Seleccionar el precio medio de todos los productos.
SELECT AVG(precio) AS 'Precio medio' FROM articulos;

--Ej 1.7. Obtener el precio medio de los artículos cuyo código de fabricante sea 2.
SELECT AVG(precio) AS 'Precio medio de artículos AMD' FROM articulos WHERE fabricante=2;

--Ej 1.8. Obtener el número de artículos cuyo precio sea mayor o igual a 180.
SELECT COUNT(id_articulo) FROM articulos WHERE precio >= 180;

--Ej 1.9. Obtener nombre y precio de artículos cuyo precio sea >=180 y ordenar DESC por precio, ASC por nombre.
SELECT nombre, precio FROM articulos WHERE precio >= 180 ORDER BY precio DESC nombre ASC;

--Ej 1.10. Obtener listado de artículos, incluyendo nombre, precio y datos del fabricante.
SELECT a.nombre AS 'Articulo', precio AS 'Precio', f.id_fabricante 
AS 'ID Fabricante', f.nombre AS 'Fabricante' FROM articulos a
INNER JOIN fabricantes f
ON a.fabricante = f.id_fabricante;

--Ej 1.11. Obtener un listado de artículos, incluyendo el nombre del artículo, 
--su precio y el nombre del fabricante.
SELECT a.nombre AS 'Articulo', precio AS 'Precio', f.nombre AS 'Fabricante' FROM articulos a
INNER JOIN fabricantes f
ON a.fabricante = f.id_fabricante;

--Ej 1.12. Obtener el precio medio de los productos de cada fabricante, mostrando solo los códigos de fabricante.
SELECT AVG(precio) AS 'Precio medio', f.id_fabricante AS 'Fabricante' FROM articulos a
INNER JOIN fabricantes f
ON a.fabricante = f.id_fabricante
GROUP BY fabricante;

--Ej 1.13. Obtener el precio medio de los productos de cada fabricante, mostrando el nombre del fabricante.
SELECT AVG(precio) AS 'Precio medio', f.nombre AS 'Fabricante' FROM articulos a
INNER JOIN fabricantes f
ON a.fabricante = f.id_fabricante
GROUP BY fabricante;

--Ej 1.14. Obtener los nombres de los fabricantes que ofrezcan productos cuyo precio medio sea mayor o igual a 150.
SELECT f.nombre AS 'Fabricante', AVG(precio) AS 'Precio medio' FROM articulos a 
INNER JOIN fabricantes f
ON a.fabricante = f.id_fabricante
WHERE precio >= 150
GROUP BY fabricante;

--Ej 1.15. Obtener el nombre y precio del artículo más barato.
SELECT nombre AS 'Artículo más barato', precio AS 'Precio ' FROM articulos 
WHERE precio = (SELECT MIN(precio) FROM articulos);

--Ej 1.16. Obtener una lista con el nombre y precio de los artículos más caros
--de cada proveedor (incluyendo el nombre del proveedor).
SELECT nombre AS 'Artículo más caro', MAX(precio) AS 'Precio' FROM articulos
GROUP BY fabricante;

--Ej 1.17. Añadir un nuevo producto: Altavoces de 70€ del fabricante 2.
INSERT INTO articulos (nombre, precio, fabricante) VALUES ('Altavoces', 70, 2);

--Ej 1.18. Cambiar el nombre del producto 8 a 'Impresora Laser'.
UPDATE articulos SET nombre='Impresora Laser'
WHERE id_articulo=8;

--Ej 1.19. Aplicar un descuento del 10% a todos los productos.
UPDATE articulos SET precio=precio*0.9;

--Ej 1.20. Aplicar un descuento de 10€ a todos los productos cuyo precio sea mayor o igual a 120.
UPDATE articulos SET precio=precio-10 WHERE precio >= 120;