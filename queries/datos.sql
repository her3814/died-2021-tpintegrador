USE `died`;

INSERT INTO `estaciones` (`id`, `nombre`, `hora_apertura`, `hora_cierre`) VALUES
(1,	'A',	'01:00:00',	'03:00:00'),
(2,	'B',	'06:30:00',	'20:30:00'),
(3,	'D',	'03:30:00',	'18:30:00'),
(4,	'E',	'03:30:00',	'20:30:00'),
(5,	'F',	'03:00:00',	'04:00:00'),
(6,	'G',	'03:00:00',	'22:00:00'),
(7,	'H',	'04:00:00',	'22:30:00'),
(8,	'X',	'03:30:00',	'20:00:00'),
(9,	'Y',	'04:00:00',	'04:30:00'),
(10,	'Z',	'01:00:00',	'01:30:00'),
(12,	'C',	'08:00:00',	'12:00:00');

INSERT INTO `estaciones_tareas_mantenimiento` (`id`, `id_estacion`, `fecha_inicio`, `fecha_fin`, `observaciones`) VALUES
(1,	1,	'2021-08-01',	'2021-08-06',	'Mantenimiento de Escaleras mecanicas');

INSERT INTO `lineas_transporte` (`id`, `nombre`, `color`, `estado`, `tipo_transporte`) VALUES
(1,	'VERDE CLARO',	'verde_claro',	'ACT',	'SUBTE'),
(2,	'NARANJA',	'naranja',	'ACT',	'COLECTIVO'),
(3,	'AZUL',	'azul',	'ACT',	'COLECTIVO'),
(4,	'AMARILLA',	'amarillo',	'ACT',	'SUBTE'),
(5,	'VERDE',	'verde',	'ACT',	'TREN'),
(6,	'ROJA',	'rojo',	'ACT',	'COLECTIVO');

INSERT INTO `lineas_trayecto` (`id_linea_transporte`, `trayecto_orden`, `id_estacion_origen`, `id_estacion_destino`, `cant_pasajeros`, `duracion_min`, `costo`, `distancia`, `estado`) VALUES
(1,	1,	1,	2,	12,	30,	87,	20,	'ACT'),
(1,	2,	2,	3,	5,	45,	25,	22,	'ACT'),
(1,	3,	3,	4,	4,	12,	73,	14,	'ACT'),
(2,	1,	1,	12,	23,	52,	45,	35,	'ACT'),
(2,	2,	12,	5,	24,	43,	15,	200,	'ACT'),
(2,	3,	5,	6,	26,	16,	75,	20,	'ACT'),
(3,	1,	8,	12,	8,	24,	68,	31,	'ACT'),
(3,	2,	12,	3,	10,	65,	32,	24,	'ACT'),
(3,	3,	3,	4,	7,	45,	12,	12,	'ACT'),
(3,	4,	4,	7,	12,	21,	54,	12,	'ACT'),
(4,	1,	6,	4,	13,	42,	78,	54,	'ACT'),
(4,	2,	4,	7,	18,	13,	65,	24,	'ACT'),
(5,	1,	1,	8,	8,	28,	8,	212,	'ACT'),
(5,	2,	8,	9,	12,	75,	6,	18,	'ACT'),
(5,	3,	9,	10,	10,	20,	4,	28,	'ACT'),
(6,	1,	3,	5,	9,	12,	30,	54,	'ACT'),
(6,	2,	5,	8,	11,	45,	45,	98,	'ACT'),
(6,	3,	8,	9,	16,	65,	40,	142,	'ACT'),
(6,	4,	9,	10,	13,	12,	45,	123,	'ACT');

INSERT INTO `boletos` (`numero`, `nombre_cliente`, `correo_cliente`, `fecha_venta`, `costo`, `nombre_estacion_origen`, `nombre_estacion_fin`) VALUES
(1,	'Hernan',	'her@hotmail.com',	'2021-08-01',	89.00,	'A',	'F'),
(2,	'Clarisa',	'clari@hotamil',	'2021-08-02',	150.00,	'B',	'D');

INSERT INTO `boleto_trayecto` (`boleto_numero`, `trayecto_orden`, `linea_nombre`, `linea_color`, `linea_tipo_transporte`, `estacion_origen_nombre`, `estacion_destino_nombre`, `trayecto_duracion_min`, `trayecto_costo`, `trayecto_distancia`) VALUES
(1,	1,	'NARANJA',	'naranja',	'COLECTIVO',	'A',	'D',	52,	45,	35),
(1,	2,	'AZUL',	'azul',	'COLECTIVO',	'D',	'E',	65,	32,	24),
(1,	3,	'AZUL',	'azul',	'COLECTIVO',	'E',	'F',	45,	12,	12),
(2,	1,	'VERDE CLARO',	'verde_claro',	'SUBTE',	'B',	'E',	45,	25,	22),
(2,	2,	'AZUL',	'azul',	'COLECTIVO',	'E',	'F',	45,	12,	12),
(2,	3,	'ROJA',	'rojo',	'COLECTIVO',	'F',	'X',	45,	45,	98),
(2,	4,	'AZUL',	'azul',	'COLECTIVO',	'X',	'D',	24,	68,	31);
