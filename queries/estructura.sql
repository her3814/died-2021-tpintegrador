USE `died`;

CREATE TABLE `boletos` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(32) NOT NULL,
  `correo_cliente` varchar(32) NOT NULL,
  `fecha_venta` date NOT NULL,
  `costo` decimal(8,2) NOT NULL,
  `nombre_estacion_origen` varchar(16) NOT NULL,
  `nombre_estacion_fin` varchar(16) NOT NULL,
  PRIMARY KEY (`numero`)
);

-- La tabla boleto_trayecto guardará una copia 'cruda' de los datos correspondiente a los trayectos
-- elegidos por el cliente. Esto a fin de que, si los trayectos, lineas o estaciones se ven afectados
-- al ser una 'entidad' que representa algo fisico emitido dado el estado especifico del sistema en un momento
-- estos datos son 'congelados', al igual que se haria en un sistema de, por ej, facturacion. Si un producto
-- deja de venderse, o un precio cambia, la factura (boleto) no debera reflejar ese cambio en ningun momento
CREATE TABLE `boleto_trayecto` (
  `boleto_numero` int(11) NOT NULL,
  `trayecto_orden` int(11) NOT NULL,
  `linea_nombre` varchar(32) NOT NULL,
  `linea_color` varchar(16) NOT NULL,
  `linea_tipo_transporte` varchar(16) NOT NULL,
  `estacion_origen_nombre` varchar(16) NOT NULL,
  `estacion_destino_nombre` varchar(16) NOT NULL,
  `trayecto_duracion_min` double NOT NULL,
  `trayecto_costo` decimal(10,0) NOT NULL,
  `trayecto_distancia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`boleto_numero`,`trayecto_orden`),
  CONSTRAINT `fk_trayecto_boleto` FOREIGN KEY (`boleto_numero`) REFERENCES `boletos` (`numero`)
);


CREATE TABLE `estaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(16) NOT NULL,
  `hora_apertura` time NOT NULL,
  `hora_cierre` time NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `estaciones_tareas_mantenimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_estacion` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `observaciones` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_estacion` (`id_estacion`),
  CONSTRAINT `fk_tarea-mantenimiento_estacion` FOREIGN KEY (`id_estacion`) REFERENCES `estaciones` (`id`) ON DELETE NO ACTION
);


CREATE TABLE `lineas_transporte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(32) NOT NULL,
  `color` varchar(16) NOT NULL,
  `estado` varchar(3) NOT NULL,
  `tipo_transporte` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `lineas_trayecto` (
  `id_linea_transporte` int(11) NOT NULL,
  `trayecto_orden` int(11) NOT NULL,
  `id_estacion_origen` int(11) NOT NULL,
  `id_estacion_destino` int(11) NOT NULL,
  `cant_pasajeros` int(11) NOT NULL,
  `duracion_min` double NOT NULL,
  `costo` decimal(10,0) NOT NULL,
  `distancia` decimal(10,0) NOT NULL,
  `estado` varchar(3) NOT NULL,
  PRIMARY KEY (`id_linea_transporte`,`trayecto_orden`),
  KEY `id_estacion_origen` (`id_estacion_origen`),
  KEY `id_estacion_destino` (`id_estacion_destino`),
  KEY `id_linea_transporte` (`id_linea_transporte`),
  CONSTRAINT `fk_trayecto_linea` FOREIGN KEY (`id_linea_transporte`) REFERENCES `lineas_transporte` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_trayectos_estacion_ori` FOREIGN KEY (`id_estacion_origen`) REFERENCES `estaciones` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_trayectos_estacion_des` FOREIGN KEY (`id_estacion_destino`) REFERENCES `estaciones` (`id`) ON DELETE CASCADE
);