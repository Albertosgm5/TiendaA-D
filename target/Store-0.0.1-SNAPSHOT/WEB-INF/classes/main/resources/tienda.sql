-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-04-2020 a las 17:29:29
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL,
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
  `titular` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2),
(2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineadc`
--

CREATE TABLE `lineadc` (
  `idLineaCompra` bigint(20) NOT NULL,
  `idProducto` bigint(20) NOT NULL,
  `idVenta` bigint(20) NOT NULL,
  `precioProducto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` bigint(20) NOT NULL,
  `nombreProducto` varchar(255) NOT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL,
  `categoria` varchar(55) NOT NULL,
  `descripcion` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `precio`, `stock`, `categoria`, `descripcion`) VALUES
(5, 'u', 78, 7, 'u', 'u'),
(1377, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1378, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1379, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1380, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1381, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1382, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1383, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1384, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1385, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1386, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1387, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1388, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1389, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1390, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1391, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1392, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1393, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1394, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1395, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1396, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1397, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1398, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1399, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1400, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1401, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1402, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1403, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1404, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1405, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1406, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1407, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1408, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1409, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1410, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1411, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1412, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1413, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1414, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1415, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1416, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1417, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1418, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1419, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1420, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1421, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1422, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1423, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1424, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1425, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1426, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1427, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1428, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1429, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1430, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1431, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1432, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1433, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1434, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1435, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1436, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1437, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1438, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1439, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1440, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1441, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1442, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1443, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1444, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1445, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1446, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1447, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1448, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono'),
(1449, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(1450, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(1451, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(1452, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(1453, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(1454, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(1455, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(1456, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` bigint(20) NOT NULL,
  `fechaVenta` date NOT NULL,
  `descuento` float NOT NULL,
  `idCliente` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `lineadc`
--
ALTER TABLE `lineadc`
  ADD PRIMARY KEY (`idLineaCompra`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idVenta` (`idVenta`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `lineadc`
--
ALTER TABLE `lineadc`
  MODIFY `idLineaCompra` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1457;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lineadc`
--
ALTER TABLE `lineadc`
  ADD CONSTRAINT `idProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `idVenta` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
