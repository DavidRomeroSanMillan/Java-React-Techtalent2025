INSERT INTO productos (id_producto, nombre, precio) VALUES
    (213, 'Patatas', 4),
    (933, 'Hojaldre', 5),
    (304, 'Pan de molde', 2),
    (844, 'Fuet', 4),
    (552, 'Mascarpone', 7),
    (553, 'Parmesado DOP', 9),
    (554, 'Ricotta', 3),
    (215, 'Cebollas' 2),
    (216, 'Cebolla roja 1kg', 6),
    (300, 'Baguette industrial', 1);

INSERT INTO cajeros (id_cajero, nom_apellido) VALUES
    (101, 'Pascual Muñoz'),
    (102, 'Frederic Muntz'),
    (103, 'Nuño Cansado'),
    (104, 'Laura Sánchez'),
    (105, 'Iván Ortega'),
    (106, 'Clara Gutiérrez'),
    (107, 'Samuel Vidal'),
    (108, 'Beatriz Navarro'),
    (109, 'Héctor Molina'),
    (110, 'Diana Ríos');

INSERT INTO maquinas_registradoras (piso) VALUES
    (0), (1), (1), (0), (2), (0), (1), (1), (0), (2);

INSERT INTO venta (cajero, producto, caja) VALUES
    (101, 552, 1),
    (102, 213, 3),
    (103, 933, 2),
    (104, 304, 4),
    (105, 844, 1),
    (106, 553, 5),
    (107, 554, 6),
    (108, 215, 10),
    (109, 216, 8),
    (110, 300, 7);