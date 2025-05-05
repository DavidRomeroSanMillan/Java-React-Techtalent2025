INSERT INTO facultades (nombre) VALUES
    ('Historia'),
    ('Geografía'),
    ('Educación'),
    ('Traducción'),
    ('Matemáticas'),
    ('Ingeniería'),
    ('Medicina'),
    ('Veterinaria'),
    ('Humanidades'),
    ('Telecomunicaciones');

INSERT INTO investigadores (dni, nom_apellido, facultad) VALUES
    ('71332187P', 'Nacho Castaño', 3),
    ('60293471L', 'María Ibáñez', 1),
    ('71829364M', 'Luis Ramiro', 4),
    ('82936475X', 'Claudia Vega', 2),
    ('91028364K', 'Tomás Herrero', 7),
    ('19283746Z', 'Elena Alcázar', 5),
    ('37485920N', 'Andrés Gil', 6),
    ('48592017T', 'Lucía Prado', 9),
    ('59610384Y', 'Javier Lorente', 8),
    ('68719203R', 'Patricia Romero', 10);

INSERT INTO equipos (num_serie, nombre, facultad) VALUES
    (3455, 'Desarrollo I+D', 6),
    (3456, 'Microscopio Electrónico', 3),
    (3457, 'Cámara Termográfica', 1),
    (3458, 'Impresora 3D', 7),
    (3459, 'Servidor de Datos', 2),
    (3460, 'Equipo de Resonancia', 9),
    (3461, 'Analizador de Espectros', 4),
    (3462, 'Sistema de Simulación', 10),
    (3463, 'Plataforma Robótica', 5),
    (3464, 'Sensor de Partículas', 8);

INSERT INTO reservas (dni, num_serie, comienzo, fin) VALUES
    ('71332187P', 3456, '2025-05-01 09:00:00', '2025-05-01 12:00:00'),
    ('60293471L', 3457, '2025-04-30 14:30:00', '2025-04-30 16:00:00'),
    ('71829364M', 3461, '2025-05-03 10:00:00', '2025-05-03 13:00:00'),
    ('82936475X', 3459, '2025-05-02 08:00:00', '2025-05-02 10:30:00'),
    ('91028364K', 3458, '2025-05-01 15:00:00', '2025-05-01 18:00:00'),
    ('19283746Z', 3463, '2025-05-04 09:00:00', '2025-05-04 11:30:00'),
    ('37485920N', 3455, '2025-05-03 13:00:00', '2025-05-03 16:00:00'),
    ('48592017T', 3460, '2025-04-29 10:00:00', '2025-04-29 12:00:00'),
    ('59610384Y', 3464, '2025-05-05 11:00:00', '2025-05-05 13:00:00'),
    ('68719203R', 3462, '2025-05-02 14:00:00', '2025-05-02 17:00:00');