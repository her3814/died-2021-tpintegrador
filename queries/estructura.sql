-- died.estaciones 
CREATE TABLE `estaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(16) NOT NULL,
  `hora_apertura` time NOT NULL,
  `hora_cierre` time NOT NULL,
  PRIMARY KEY (`id`)
);

-- died.estaciones_tareas_mantenimiento
CREATE TABLE `estaciones_tareas_mantenimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_estacion` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `observaciones` varchar(120),
  PRIMARY KEY (`id`),
  KEY `id_estacion` (`id_estacion`),
  CONSTRAINT `estaciones_tareas_mantenimiento_ibfk_1` FOREIGN KEY (`id_estacion`) REFERENCES `estaciones` (`id`) ON DELETE CASCADE
); 


-- died.lineas_transporte
CREATE TABLE `lineas_transporte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(32) NOT NULL,
  `color` varchar(16) NOT NULL,
  `estado` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
);

-- died.lineas_trayecto
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
  CONSTRAINT `lineas_trayecto_ibfk_1` FOREIGN KEY (`id_linea_transporte`) REFERENCES `lineas_transporte` (`id`) ON DELETE CASCADE,
  CONSTRAINT `lineas_trayecto_ibfk_2` FOREIGN KEY (`id_estacion_origen`) REFERENCES `estaciones` (`id`) ON DELETE CASCADE,
  CONSTRAINT `lineas_trayecto_ibfk_3` FOREIGN KEY (`id_estacion_destino`) REFERENCES `estaciones` (`id`) ON DELETE CASCADE
);

-- died.boletos 
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

-- died.boleto_recorrido 
CREATE TABLE `boleto_recorrido` (
  `boleto_numero` int(11) NOT NULL,
  `boleto_recorrido_orden` int(11) NOT NULL,
  `trayecto_linea_id` int(11) NOT NULL,
  `trayecto_orden` int(11) NOT NULL,
  PRIMARY KEY (`boleto_numero`,`boleto_recorrido_orden`),
  KEY `boletos_trayecto_FK` (`trayecto_linea_id`,`trayecto_orden`),
  CONSTRAINT `boleto_recorrido_FK` FOREIGN KEY (`boleto_numero`) REFERENCES `boletos` (`numero`),
  CONSTRAINT `boletos_trayecto_FK` FOREIGN KEY (`trayecto_linea_id`, `trayecto_orden`) REFERENCES `lineas_trayecto` (`id_linea_transporte`, `trayecto_orden`)
);