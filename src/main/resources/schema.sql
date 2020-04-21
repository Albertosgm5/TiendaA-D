drop database if exists tienda;
create database tienda;
use tienda;

DROP TABLE IF EXISTS `lineadc`;
DROP TABLE IF EXISTS `ventas`;
DROP TABLE IF EXISTS `producto`;
DROP TABLE IF EXISTS `cliente`;
DROP TABLE IF EXISTS `rol`;
DROP TABLE IF EXISTS `cliente_rol`;

CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `banco` varchar(255) DEFAULT NULL,
  `codigoSeguridad` int(11) DEFAULT NULL,
  `direccionEnvio` varchar(255) DEFAULT NULL,
  `direccionFacturacion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fechaNacimniento` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) DEFAULT NULL,
  `numTarjeta` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `titular` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `producto` (
  `idProducto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(255) NOT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ventas` (
  `idVenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaVenta` date NOT NULL,
  `descuento` float NOT NULL,
  `idCliente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `fk_idCliente` (`idCliente`),
  CONSTRAINT `fk_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `lineadc` (
  `idLineaCompra` bigint(20) NOT NULL AUTO_INCREMENT,
  `idProducto` bigint(20) NOT NULL,
  `idVenta` bigint(20) NOT NULL,
  `precioProducto` float NOT NULL,
  PRIMARY KEY (`idLineaCompra`),
  KEY `idProducto` (`idProducto`),
  KEY `idVenta` (`idVenta`),
  CONSTRAINT `idProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `idVenta` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rol` (
  `id_rol` bigint NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(255) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cliente_rol` (
  `id_cliente` bigint NOT NULL,
  `id_rol` bigint NOT NULL,
  PRIMARY KEY (`id_cliente`,`id_rol`),
  KEY `fk_rolrol_idx` (`id_rol`),
  CONSTRAINT `fk_clienterol` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE,
  CONSTRAINT `fk_rolrol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
