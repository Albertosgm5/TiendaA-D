CREATE DATABASE IF NOT EXISTS `Tienda_Online`;
USE `Tienda_Online`;

DROP TABLE IF EXISTS `Cliente`;
CREATE TABLE `Cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(45) NOT NULL,
  `nombreUsuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `LineasDeCompra`;
CREATE TABLE `LineasDeCompra` (
  `idLineaCompra` bigint(20) NOT NULL AUTO_INCREMENT,
  `idProducto` bigint(20) NOT NULL,
  `idVenta` bigint(20) NOT NULL,
  `precioProducto` decimal(5,0) NOT NULL,
  PRIMARY KEY (`idLineaCompra`),
  KEY `FK_idProducto_idx` (`idProducto`),
  KEY `FK_idVenta_idx` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Producto`;
CREATE TABLE `Producto` (
  `idProducto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(45) NOT NULL,
  `Precio` decimal(5,0) NOT NULL,
  `Stock` bigint(20) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Venta`;
CREATE TABLE `Venta` (
  `idVenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaVenta` datetime NOT NULL,
  `descuento` varchar(45) NOT NULL,
  PRIMARY KEY (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;