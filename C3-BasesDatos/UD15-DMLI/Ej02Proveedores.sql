INSERT INTO proveedores (id_proveedor, nombre) VALUES
    (1111, 'Alfonso Jimenez'),
    (2222, 'María Torres'),
    (3333, 'Luis Fernández'),
    (4444, 'Ana Martínez'),
    (5555, 'Jorge Ramírez'),
    (6666, 'Carmen Pérez'),
    (7777, 'Ricardo Gómez'),
    (8888, 'Lucía Herrera'),
    (9999, 'Andrés Navarro'),
    (1010, 'Elena Morales');

INSERT INTO piezas (nombre) VALUES
    ('Tuerca 9 1/2'),
    ('Tornillo 3'),
    ('Arandela 5'),
    ('Perno 12'),
    ('Tornillo Allen 6x40'),
    ('Tuerca mariposa 8'),
    ('Remache 4mm'),
    ('Tornillo hexagonal 10'),
    ('Tuerca autoblocante 7'),
    ('Pasador cilíndrico 3x20');

INSERT INTO suministra (precio, codigo_pieza, codigo_proveedor) VALUES
    (12, 1, 1111),
    (3, 2, 2222),
    (21, 3, 3333),
    (9, 4, 4444),
    (6, 5, 5555),
    (9, 6, 6666),
    (1, 7, 7777),
    (3, 8, 8888),
    (30, 9, 9999),
    (2, 10, 1010);
