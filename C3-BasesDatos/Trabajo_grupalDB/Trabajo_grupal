CREATE TABLE clientes(
    id_cliente INT NOT NULL AUTO_INCREMENT,
    dni CHAR(9),
	correo VARCHAR(100),
    nombre VARCHAR(100),
    PRIMARY KEY (id_cliente));

CREATE TABLE proveedores(
    id_proveedor INT NOT NULL AUTO_INCREMENT,
    nif_dni CHAR(9),
    nombre VARCHAR(100),
    PRIMARY KEY (id_proveedor));

CREATE TABLE productos(
    num_serie INT,
    nombre VARCHAR(100),
    inventario INT,
    precio DOUBLE,
    PRIMARY KEY (num_serie));

CREATE TABLE ventas_compras(
    num_pedido INT NOT NULL,
    importe_total DOUBLE,
    impuesto1 DOUBLE,
    impuesto2 DOUBLE,
    PRIMARY KEY (num_pedido));
    
CREATE TABLE se_compone(
    num_pedido INT, 
    num_serie INT,
    cantidad INT,
    PRIMARY KEY(num_pedido, num_serie),
    FOREIGN KEY (num_pedido) REFERENCES ventas_compras(num_pedido),
    FOREIGN KEY (num_serie) REFERENCES productos(num_serie));

CREATE TABLE facturas_venta(
    num_factura INT,
    fecha DATE,
    cliente INT,
    venta INT,
    impuesto DOUBLE,
    importe DOUBLE,
    PRIMARY KEY (num_factura),
    FOREIGN KEY (cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (venta) REFERENCES ventas_compras(num_pedido));

CREATE TABLE facturas_compra(
    num_factura INT,
    fecha DATE,
    proveedor INT,
    compra INT,
    impuesto DOUBLE,
    importe DOUBLE,
    FOREIGN KEY (proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (compra) REFERENCES ventas_compras(num_pedido),
    PRIMARY KEY (num_factura));

INSERT INTO clientes(dni, correo, nombre) VALUES
('34128865P', 'correo@mail.com', 'Jaime'),
('99327764K', 'prueba2@mail.com', 'María'),
('42255541L', 'personareal@invent.com', 'Carlos');

INSERT INTO proveedores(nif_dni, nombre) VALUES
('S77490234', 'Verduras Paola, S.A.'),
('R11302242', 'Productos lácteos I.P.A.'),
('J50027731', 'Harinas Manolo, S.A.');

INSERT INTO productos(num_serie, nombre, inventario) VALUES
(493002, 'Calabaza', 65),
(322001, 'Mantequilla', 100),
(009416, 'Harina de centeno', 32);

INSERT INTO ventas_compras (num_pedido) VALUES
(1), (2), (3), (4), (5);

INSERT INTO facturas_compra (num_factura, fecha, proveedor, compra, impuesto, importe) VALUES
(3, 2024-01-02, 1, 1, 4, 5.85),
(2, 2024-07-05, 2, 2, 21, 1.98),
(1, 2024-07-21, 3, 3, 21, 6.70);

INSERT INTO facturas_venta (num_factura, fecha, cliente, venta, impuesto, importe) VALUES
(1, 2025-02-03, 1, 4, 21, 25),
(2, 2025-03-20, 2, 5, 21, 50.25);

INSERT INTO se_compone (num_pedido, num_serie, cantidad) VALUES
(1, 322001, 1),
(1, 493002, 1),
(2, 9416, 2),
(3, 322001, 2),
(4, 493002, 10),
(5, 322001, 15);

UPDATE facturas_compra SET impuesto=4 WHERE num_factura=2;
UPDATE productos SET inventario=-15 WHERE num_serie=322001;
UPDATE clientes SET correo=correofalso@gmail.com WHERE id_cliente=1;

DELETE FROM clientes WHERE id_cliente=3;
DELETE FROM productos WHERE num_serie=1234;
DELETE FROM proveedores WHERE id_proveedor=4;

SELECT nombre AS 'Nombre' FROM proveedores WHERE id_proveedor=2;
SELECT AVG(precio) AS 'Precio medio productos' FROM productos;
SELECT COUNT(num_serie) AS 'Número de productos' FROM productos WHERE inventario > 50;