-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2020 a las 19:39:00
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
  `numTarjeta` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `titular` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `apellidos`, `banco`, `codigoSeguridad`, `direccionEnvio`, `direccionFacturacion`, `email`, `fechaNacimniento`, `nombre`, `nombreUsuario`, `numTarjeta`, `password`, `titular`) VALUES
(1, 'G M', 'Bankia', 111, 'Av.Europa', 'Av.Europa', 'alberto@gmail.com', '1992-06-05 00:00:00', 'Alberto', 'Albert', 1000999900001111, 'A5GM', 'AlbertGM'),
(2, 'N', 'Bankia', 222, 'Av.America', 'Av.America', 'daniel@gmail.com', '1997-08-05 00:00:00', 'Daniel', 'Dani', 2200999900001211, 'dani', 'DaniN'),
(3, 'F P', 'Bankia', 333, 'Av.FP', 'Av.FP', 'marcos@gmail.com', '1992-07-07 00:00:00', 'Marcos', 'Marcos', 3300999900001311, '12345', 'MarcosFP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_rol`
--

CREATE TABLE `cliente_rol` (
  `ID_ROL` bigint(20) NOT NULL,
  `ID_CLIENTE` bigint(20) NOT NULL
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
(1),
(1);

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
(1, 'Camara', 53, 34, 'Fotografia', 'Esto es una camara'),
(2, 'Pantalla', 153, 3, 'Perifericos', 'Esto es una pantalla'),
(3, 'Teclado Gamer', 253, 4, 'Perifericos', 'Esto es un teclado'),
(4, 'Portatil hp v7', 353, 30, 'Portatiles', 'Este es un portatil'),
(5, 'Portatil Acer 45', 453, 31, 'Portatiles', 'Este es un portatil'),
(6, 'Xbox one + 6 juegos', 553, 14, 'Consolas', 'Esto es una consola'),
(7, 'Movil hn7', 653, 3, 'Smartphones', 'Esto es un telefono'),
(8, 'Movil Apple 78', 753, 4, 'Smartphones', 'Esto es un telefono');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` bigint(20) NOT NULL,
  `nombre_rol` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
-- Indices de la tabla `cliente_rol`
--
ALTER TABLE `cliente_rol`
  ADD PRIMARY KEY (`ID_ROL`,`ID_CLIENTE`),
  ADD KEY `FK4jcnldwcc7ryao7yxy8xtm1n2` (`ID_CLIENTE`);

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
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `lineadc`
--
ALTER TABLE `lineadc`
  MODIFY `idLineaCompra` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` bigint(20) NOT NULL AUTO_INCREMENT;

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
