INSERT INTO cientificos (dni, nom_apellido) VALUES
    ('43768463P', 'Carla Machado'),
    ('52837462L', 'Diego Ramírez'),
    ('61928374M', 'Lucía Fernández'),
    ('70293847X', 'Manuel Ortega'),
    ('81374629Y', 'Sofía Herrera'),
    ('90485736K', 'Pablo Giménez'),
    ('19583746Z', 'Elena Ruiz'),
    ('28637495N', 'Javier Torres'),
    ('37465928Q', 'Marina Castro'),
    ('46382917T', 'Andrés Morales');

INSERT INTO proyectos (id_proyecto, nombre, horas) VALUES
    (3209, 'Simios', 21),
    (5205, 'Algas', 90),
    (1094, 'Poliuretano', 85),
    (2301, 'Titanio', 45),
    (6742, 'Neuronas', 120),
    (4810, 'Óptica', 60),
    (9153, 'Quarks', 100),
    (3478, 'Cianobacterias', 75),
    (7632, 'Nanotubos', 110),
    (1540, 'Vacunas', 95);

INSERT INTO asignado_a (cientifico, proyecto) VALUES
    ('43768463P', 4810),
    ('46382917T', 5205),
    ('90485736K', 3209),
    ('19583746Z', 1094),
    ('37465928Q', 9153),
    ('61928374M', 1540),
    ('28637495N', 2301),
    ('70293847X', 6742),
    ('81374629Y', 3478),
    ('52837462L', 7632);