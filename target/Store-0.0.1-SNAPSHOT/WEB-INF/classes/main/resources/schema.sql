drop database if exists tienda;
create database tienda;
use tienda;

DROP TABLE IF EXISTS `lineadc`;
DROP TABLE IF EXISTS `ventas`;
DROP TABLE IF EXISTS `producto`;
DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) NOT NULL,
  `nombreUsuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
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
