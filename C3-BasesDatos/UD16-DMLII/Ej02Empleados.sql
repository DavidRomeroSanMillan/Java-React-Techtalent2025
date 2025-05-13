INSERT INTO departamentos (id_departamento, nombre, presupuesto) VALUES
(77, 'Investigación', 95000),
(14, 'Informática', 45000),
(21, 'Ventas', 85000),
(37, 'Recursos humanos', 38000),
(42, 'Dirección', 100000);

INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES
('76442098T', 'Juan', 'Soriano Mendoza', 14),
('44900231K', 'Maria', 'Lagos Navaja', 77),
('32008433L', 'Karen', 'Muñoz Vázquez', 14),
('81112029J', 'Sílvia', 'Hinojoso Gómez', 21),
('65526541N', 'Juan', 'López León', 77),
('11032284V', 'Felicia', 'López Valdez', 14),
('10422124Q', 'Marcos', 'Pérez Zambrano', 37),
('08843765I', 'Maria', 'Carrión Mendoza', 77),
('42210989F', 'Paula', 'Mendoza Pérez', 37),
('65091165A', 'José', 'Castro Bermejo', 42);

-- 2.1. Obtener los apellidos de los empleados.
SELECT apellidos AS 'Apellidos' FROM empleados;

-- 2.2. Obtener los apellidos de los empleados sin repeticiones.
SELECT apellidos AS 'Apellidos sin repetir' FROM empleados
GROUP BY apellidos;

-- 2.3. Obtener todos los datos de los empleados que se apellidan 'López'.
SELECT * FROM empleados WHERE apellidos='López';

-- 2.4. Obtener todos los datos de los empleados que se apellidan 'López' y 'Pérez'.
SELECT * FROM empleados WHERE apellidos IN ('López', 'Pérez');

-- 2.5. Obtener todos los datos de los empleados que trabajan en el departamento 14.
SELECT * FROM empleados WHERE departamento=14;

-- 2.6. Obtener todos los datos de los empleados que trabajan para el departamento 37 y 77.
SELECT * FROM empleados WHERE departamento IN (37, 77);

-- 2.7. Obtener todos los datos de los empleados cuyo apellido comience por 'P'.
SELECT * FROM empleados WHERE apellidos LIKE 'P%';

-- 2.8. Obtener el presupuesto total de todos los departamentos.
SELECT SUM(presupuesto) AS 'Presupuesto total' FROM departamentos;

-- 2.9. Obtener el número de empleados de cada departamento.
SELECT id_departamento AS 'Departamento', COUNT(dni) AS 'Número de empleados' FROM empleados 
INNER JOIN departamentos ON departamento=id_departamento
GROUP BY departamento;

-- 2.10. Obtener un listado completo de empleados, incluyendo por cada empleado sus datos 
-- y los de su departamento.
SELECT dni AS 'DNI' , e.nombre AS 'Nombre', apellidos AS 'Apellidos', departamento AS 'Nº Departamento', 
d.nombre AS 'Departamento', d.presupuesto AS 'Presupuesto' FROM empleados e
INNER JOIN departamentos d ON departamento=id_departamento;

-- 2.11. Obtener un listado completo de empleados, incluyendo el nombre y apellidos del empleado
-- junto al nombre y presupuesto de su departamento.
SELECT e.nombre AS 'Nombre', apellidos AS 'Apellidos', 
d.nombre AS 'Departamento', d.presupuesto AS 'Presupuesto' FROM empleados e
INNER JOIN departamentos d ON departamento=id_departamento;

-- 2.12. Obtener los nombres y apellidos de los empleados que trabajen en departamentos 
-- con presupuesto > 60.000.
SELECT e.nombre AS 'Nombre', apellidos AS 'Apellidos', presupuesto AS 'Presupuesto'FROM empleados e 
INNER JOIN departamentos ON departamento=id_departamento
WHERE presupuesto > 60000;

-- 2.13. Obtener los datos de los departamentos cuyo presupuesto es superior al presupuesto medio 
-- de todos los departamentos.
SELECT * FROM departamentos WHERE presupuesto > (SELECT AVG(presupuesto) FROM departamentos);

-- 2.14. Obtener los nombres (únicamente) de los departamentos que tienen más de dos empleados.
SELECT d.nombre AS 'Depts. con más de 2 empleados' FROM departamentos d
INNER JOIN empleados ON departamento=id_departamento
WHERE (SELECT COUNT(departamento) FROM empleados)
GROUP BY d.nombre HAVING COUNT(departamento) > 2;

-- 2.15. Añadir un nuevo departamento "Calidad", con presupuesto 40000 y código 11. 
-- Añadir un empleado vinculado al departamento recién creado: Esther Vázquez, DNI: 89267109.
INSERT INTO departamentos(id_departamento, nombre, presupuesto) VALUES
(11, 'Calidad', 40000);
INSERT INTO empleados(dni, nombre, apellidos, departamento) VALUES
('89267109', 'Esther', 'Vázquez', 11);

-- 2.16. Aplicar un recorte presupuestario del 10% a todos los departamentos.
UPDATE departamentos SET presupuesto=presupuesto*0.9;

-- 2.17. Reasignar a los empleados del departamento 77 al 14.
UPDATE empleados SET departamento=14
WHERE departamento = 77;

-- 2.18. Despedir a todos los empleados del departamento 14.
DELETE * FROM empleados WHERE departamento = 14;

-- 2.19. Despedir a todos los empleados de los departamentos con presupuesto > 60000.
DELETE FROM empleados WHERE departamento IN 
(SELECT id_departamento FROM departamentos WHERE presupuesto > 60000);

-- 2.20 Despedir a todos los empleados.
DELETE FROM empleados;