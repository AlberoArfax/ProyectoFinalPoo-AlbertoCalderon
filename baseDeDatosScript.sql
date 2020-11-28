CREATE DATABASE  IF NOT EXISTS `iglesia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `iglesia`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: iglesia
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `acceso_usuarios`
--

DROP TABLE IF EXISTS `acceso_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acceso_usuarios` (
  `id-accesoUsuarios` int NOT NULL AUTO_INCREMENT,
  `nombre-usuario` varchar(45) NOT NULL,
  `contraseña-usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`id-accesoUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso_usuarios`
--

LOCK TABLES `acceso_usuarios` WRITE;
/*!40000 ALTER TABLE `acceso_usuarios` DISABLE KEYS */;
INSERT INTO `acceso_usuarios` VALUES (1,' Alberto','12345');
/*!40000 ALTER TABLE `acceso_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aseos`
--

DROP TABLE IF EXISTS `aseos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aseos` (
  `id-aseos` int NOT NULL AUTO_INCREMENT,
  `aportador` varchar(45) NOT NULL,
  `monto` double NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id-aseos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aseos`
--

LOCK TABLES `aseos` WRITE;
/*!40000 ALTER TABLE `aseos` DISABLE KEYS */;
/*!40000 ALTER TABLE `aseos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofrendas_amor`
--

DROP TABLE IF EXISTS `ofrendas_amor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ofrendas_amor` (
  `id-ofrendasAmor` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `monto-total` double NOT NULL,
  `destino` varchar(45) NOT NULL,
  PRIMARY KEY (`id-ofrendasAmor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofrendas_amor`
--

LOCK TABLES `ofrendas_amor` WRITE;
/*!40000 ALTER TABLE `ofrendas_amor` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofrendas_amor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofrendas_construccion`
--

DROP TABLE IF EXISTS `ofrendas_construccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ofrendas_construccion` (
  `id-ofrendasConstruccion` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `monto-total` double NOT NULL,
  `destino` varchar(45) NOT NULL,
  PRIMARY KEY (`id-ofrendasConstruccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofrendas_construccion`
--

LOCK TABLES `ofrendas_construccion` WRITE;
/*!40000 ALTER TABLE `ofrendas_construccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofrendas_construccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofrendas_regulares`
--

DROP TABLE IF EXISTS `ofrendas_regulares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ofrendas_regulares` (
  `id-ofrendasRegulares` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `monto-total` double NOT NULL,
  `servicio` varchar(45) NOT NULL,
  PRIMARY KEY (`id-ofrendasRegulares`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofrendas_regulares`
--

LOCK TABLES `ofrendas_regulares` WRITE;
/*!40000 ALTER TABLE `ofrendas_regulares` DISABLE KEYS */;
INSERT INTO `ofrendas_regulares` VALUES (1,'2020-12-09',300.5,'tarde');
/*!40000 ALTER TABLE `ofrendas_regulares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talentos`
--

DROP TABLE IF EXISTS `talentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talentos` (
  `id-talentos` int NOT NULL AUTO_INCREMENT,
  `familia` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `platillo` varchar(45) NOT NULL,
  `monto` double NOT NULL,
  PRIMARY KEY (`id-talentos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talentos`
--

LOCK TABLES `talentos` WRITE;
/*!40000 ALTER TABLE `talentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `talentos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-27 23:22:31
