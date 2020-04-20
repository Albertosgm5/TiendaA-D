-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` bigint NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineadc`
--

DROP TABLE IF EXISTS `lineadc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineadc` (
  `idLineaCompra` bigint NOT NULL AUTO_INCREMENT,
  `idProducto` bigint NOT NULL,
  `idVenta` bigint NOT NULL,
  `precioProducto` float NOT NULL,
  PRIMARY KEY (`idLineaCompra`),
  KEY `idProducto` (`idProducto`),
  KEY `idVenta` (`idVenta`),
  CONSTRAINT `idProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `idVenta` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineadc`
--

LOCK TABLES `lineadc` WRITE;
/*!40000 ALTER TABLE `lineadc` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineadc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` bigint NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(255) NOT NULL,
  `precio` float NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Camara',53,34),(2,'Pantalla',153,3),(3,'Teclado Gamer',253,4),(4,'Portatil hp v7',353,30),(5,'Portatil Acer 45',453,31),(6,'Xbox one + 6 juegos',553,14),(7,'Movil hn7',653,3),(8,'Movil Apple 78',753,4),(9,'Camara',53,34),(10,'Pantalla',153,3),(11,'Teclado Gamer',253,4),(12,'Portatil hp v7',353,30),(13,'Portatil Acer 45',453,31),(14,'Xbox one + 6 juegos',553,14),(15,'Movil hn7',653,3),(16,'Movil Apple 78',753,4),(17,'Camara',53,34),(18,'Pantalla',153,3),(19,'Teclado Gamer',253,4),(20,'Portatil hp v7',353,30),(21,'Portatil Acer 45',453,31),(22,'Xbox one + 6 juegos',553,14),(23,'Movil hn7',653,3),(24,'Movil Apple 78',753,4),(25,'Camara',53,34),(26,'Pantalla',153,3),(27,'Teclado Gamer',253,4),(28,'Portatil hp v7',353,30),(29,'Portatil Acer 45',453,31),(30,'Xbox one + 6 juegos',553,14),(31,'Movil hn7',653,3),(32,'Movil Apple 78',753,4),(33,'Camara',53,34),(34,'Pantalla',153,3),(35,'Teclado Gamer',253,4),(36,'Portatil hp v7',353,30),(37,'Portatil Acer 45',453,31),(38,'Xbox one + 6 juegos',553,14),(39,'Movil hn7',653,3),(40,'Movil Apple 78',753,4),(41,'Camara',53,34),(42,'Pantalla',153,3),(43,'Teclado Gamer',253,4),(44,'Portatil hp v7',353,30),(45,'Portatil Acer 45',453,31),(46,'Xbox one + 6 juegos',553,14),(47,'Movil hn7',653,3),(48,'Movil Apple 78',753,4),(49,'Camara',53,34),(50,'Pantalla',153,3),(51,'Teclado Gamer',253,4),(52,'Portatil hp v7',353,30),(53,'Portatil Acer 45',453,31),(54,'Xbox one + 6 juegos',553,14),(55,'Movil hn7',653,3),(56,'Movil Apple 78',753,4),(57,'Camara',53,34),(58,'Pantalla',153,3),(59,'Teclado Gamer',253,4),(60,'Portatil hp v7',353,30),(61,'Portatil Acer 45',453,31),(62,'Xbox one + 6 juegos',553,14),(63,'Movil hn7',653,3),(64,'Movil Apple 78',753,4),(65,'Camara',53,34),(66,'Pantalla',153,3),(67,'Teclado Gamer',253,4),(68,'Portatil hp v7',353,30),(69,'Portatil Acer 45',453,31),(70,'Xbox one + 6 juegos',553,14),(71,'Movil hn7',653,3),(72,'Movil Apple 78',753,4),(73,'Camara',53,34),(74,'Pantalla',153,3),(75,'Teclado Gamer',253,4),(76,'Portatil hp v7',353,30),(77,'Portatil Acer 45',453,31),(78,'Xbox one + 6 juegos',553,14),(79,'Movil hn7',653,3),(80,'Movil Apple 78',753,4),(81,'Camara',53,34),(82,'Pantalla',153,3),(83,'Teclado Gamer',253,4),(84,'Portatil hp v7',353,30),(85,'Portatil Acer 45',453,31),(86,'Xbox one + 6 juegos',553,14),(87,'Movil hn7',653,3),(88,'Movil Apple 78',753,4),(89,'Camara',53,34),(90,'Pantalla',153,3),(91,'Teclado Gamer',253,4),(92,'Portatil hp v7',353,30),(93,'Portatil Acer 45',453,31),(94,'Xbox one + 6 juegos',553,14),(95,'Movil hn7',653,3),(96,'Movil Apple 78',753,4),(97,'Camara',53,34),(98,'Pantalla',153,3),(99,'Teclado Gamer',253,4),(100,'Portatil hp v7',353,30),(101,'Portatil Acer 45',453,31),(102,'Xbox one + 6 juegos',553,14),(103,'Movil hn7',653,3),(104,'Movil Apple 78',753,4),(105,'Camara',53,34),(106,'Pantalla',153,3),(107,'Teclado Gamer',253,4),(108,'Portatil hp v7',353,30),(109,'Portatil Acer 45',453,31),(110,'Xbox one + 6 juegos',553,14),(111,'Movil hn7',653,3),(112,'Movil Apple 78',753,4),(113,'Camara',53,34),(114,'Pantalla',153,3),(115,'Teclado Gamer',253,4),(116,'Portatil hp v7',353,30),(117,'Portatil Acer 45',453,31),(118,'Xbox one + 6 juegos',553,14),(119,'Movil hn7',653,3),(120,'Movil Apple 78',753,4),(121,'Camara',53,34),(122,'Pantalla',153,3),(123,'Teclado Gamer',253,4),(124,'Portatil hp v7',353,30),(125,'Portatil Acer 45',453,31),(126,'Xbox one + 6 juegos',553,14),(127,'Movil hn7',653,3),(128,'Movil Apple 78',753,4),(129,'Camara',53,34),(130,'Pantalla',153,3),(131,'Teclado Gamer',253,4),(132,'Portatil hp v7',353,30),(133,'Portatil Acer 45',453,31),(134,'Xbox one + 6 juegos',553,14),(135,'Movil hn7',653,3),(136,'Movil Apple 78',753,4),(137,'Camara',53,34),(138,'Pantalla',153,3),(139,'Teclado Gamer',253,4),(140,'Portatil hp v7',353,30),(141,'Portatil Acer 45',453,31),(142,'Xbox one + 6 juegos',553,14),(143,'Movil hn7',653,3),(144,'Movil Apple 78',753,4),(145,'Camara',53,34),(146,'Pantalla',153,3),(147,'Teclado Gamer',253,4),(148,'Portatil hp v7',353,30),(149,'Portatil Acer 45',453,31),(150,'Xbox one + 6 juegos',553,14),(151,'Movil hn7',653,3),(152,'Movil Apple 78',753,4),(153,'Camara',53,34),(154,'Pantalla',153,3),(155,'Teclado Gamer',253,4),(156,'Portatil hp v7',353,30),(157,'Portatil Acer 45',453,31),(158,'Xbox one + 6 juegos',553,14),(159,'Movil hn7',653,3),(160,'Movil Apple 78',753,4),(161,'Camara',53,34),(162,'Pantalla',153,3),(163,'Teclado Gamer',253,4),(164,'Portatil hp v7',353,30),(165,'Portatil Acer 45',453,31),(166,'Xbox one + 6 juegos',553,14),(167,'Movil hn7',653,3),(168,'Movil Apple 78',753,4);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idVenta` bigint NOT NULL AUTO_INCREMENT,
  `fechaVenta` date NOT NULL,
  `descuento` float NOT NULL,
  `idCliente` bigint DEFAULT NULL,
  PRIMARY KEY (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-21 20:28:06
