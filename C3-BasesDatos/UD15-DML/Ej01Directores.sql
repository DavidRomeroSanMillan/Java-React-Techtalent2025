INSERT INTO despachos (capacidad) VALUES 
    (5), (12), (15), (10), (6), (4), (9), (20), (22), (7);

INSERT INTO directores (dni, nom_apellido, despacho) VALUES
   ('22334455W', 'María López', 2);

INSERT INTO directores (dni, nom_apellido, despacho, dni_jefe) VALUES
    ('11223344Q', 'José Vallejo', 1, '22334455W'),
    ('33445566E', 'Carlos Jiménez', 3, '22334455W'),
    ('44556677R', 'Laura Gómez', 4, '22334455W'),
    ('55667788T', 'Antonio Ruiz', 5, '22334455W'),
    ('66778899Y', 'Isabel Martínez', 6, '22334455W'),
    ('77889900U', 'Javier Sánchez', 7, '22334455W'),
    ('88990011I', 'Elena Fernández', 8, '22334455W'),
    ('99001122O', 'Manuel Ortega', 9, '55667788T'),
    ('00112233A', 'Patricia Navarro', 10, '22334455W');

