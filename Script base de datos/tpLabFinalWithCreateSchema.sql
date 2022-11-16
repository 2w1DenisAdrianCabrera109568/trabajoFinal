CREATE DATABASE  IF NOT EXISTS `tplab` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tplab`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tplab
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Temporary view structure for view `all_emp`
--

DROP TABLE IF EXISTS `all_emp`;
/*!50001 DROP VIEW IF EXISTS `all_emp`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `all_emp` AS SELECT 
 1 AS `Legajo`,
 1 AS `Nombre`,
 1 AS `Apellido`,
 1 AS `Fecha de Nacimiento`,
 1 AS `Area`,
 1 AS `Años de Antiguedad`,
 1 AS `Sueldo Bruto`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `idarea` int NOT NULL AUTO_INCREMENT,
  `nombre_area` varchar(45) NOT NULL,
  PRIMARY KEY (`idarea`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'administracion'),(2,'atencion_cliente'),(3,'limpieza');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `legajo_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` int NOT NULL,
  `idarea` int NOT NULL,
  `sueldo_bruto` double NOT NULL,
  PRIMARY KEY (`legajo_empleado`),
  KEY `areaEmpleado_idx` (`idarea`),
  CONSTRAINT `areaEmpleado` FOREIGN KEY (`idarea`) REFERENCES `areas` (`idarea`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Juan','Perez','1990-12-05',2020,3,60000),(2,'Maria','Alonso','1982-01-02',2015,1,95000),(3,'Elena','Gonzales','1987-02-03',2015,2,80000),(4,'Sergio','Navarro','1992-05-05',2019,2,79000),(5,'Sebastian','Perez','1990-06-05',2021,3,56900),(6,'Sebastian','Perez','1992-06-05',2022,2,69000),(7,'Claudio','romero','1991-07-05',2022,3,60000);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibos`
--

DROP TABLE IF EXISTS `recibos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibos` (
  `numero_recibo` int NOT NULL AUTO_INCREMENT,
  `anio` int NOT NULL,
  `mes` int NOT NULL,
  `sueldo_bruto` double NOT NULL,
  `monto_antiguedad` double NOT NULL,
  `jubilacion` double NOT NULL,
  `fondo_alta_complejidad` double NOT NULL,
  `obra_social` double NOT NULL,
  `legajo_empleado` int NOT NULL,
  PRIMARY KEY (`numero_recibo`),
  KEY `empleado_idx` (`legajo_empleado`),
  CONSTRAINT `empleado` FOREIGN KEY (`legajo_empleado`) REFERENCES `empleados` (`legajo_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibos`
--

LOCK TABLES `recibos` WRITE;
/*!40000 ALTER TABLE `recibos` DISABLE KEYS */;
INSERT INTO `recibos` VALUES (1,2015,2,80000,0,8000,1000,500,2),(2,2015,3,72000,0,7200,1000,500,3),(3,2020,5,60000,0,6000,1000,500,1),(4,2019,2,85000,4000,8900,1000,500,2),(7,2020,5,90000,5000,9000,1000,500,2),(8,2020,5,75000,5000,7500,1000,500,3),(9,2020,5,74000,1000,7400,1000,500,4),(10,2022,5,56900,0,5960,1000,500,5);
/*!40000 ALTER TABLE `recibos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tplab'
--

--
-- Dumping routines for database 'tplab'
--
/*!50003 DROP PROCEDURE IF EXISTS `emp_leg` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `emp_leg`(in leg int)
begin
SELECT e.legajo_empleado as "Legajo", e.nombre as "Nombre", e.apellido as "Apellido", r.anio as "Periodo", r.mes as "Mes", ((r.sueldo_bruto + r.monto_antiguedad)-(r.fondo_alta_complejidad +r.jubilacion+r.obra_social)) AS "Sueldo Neto"
FROM recibos as r
INNER JOIN empleados as e on r.legajo_empleado=e.legajo_empleado
WHERE r.legajo_empleado like leg
order by r.anio, r.mes;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sueldo_anio_mes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sueldo_anio_mes`(in anio int, in mes int )
begin
SELECT a.nombre_area as "Area", r.anio as "Periodo", r.mes as "Mes",SUM((r.sueldo_bruto + r.monto_antiguedad)-(r.fondo_alta_complejidad +r.jubilacion+r.obra_social)) AS "Sueldo Neto"
FROM recibos as r
INNER JOIN empleados as e on r.legajo_empleado=e.legajo_empleado
INNER JOIN areas as a on e.idarea=a.idarea
WHERE r.anio like anio and r.mes like mes
GROUP BY a.nombre_area
ORDER BY "Sueldo Neto";
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `all_emp`
--

/*!50001 DROP VIEW IF EXISTS `all_emp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `all_emp` AS select `e`.`legajo_empleado` AS `Legajo`,`e`.`nombre` AS `Nombre`,`e`.`apellido` AS `Apellido`,`e`.`fecha_nacimiento` AS `Fecha de Nacimiento`,`a`.`nombre_area` AS `Area`,(2022 - `e`.`fecha_ingreso`) AS `Años de Antiguedad`,`e`.`sueldo_bruto` AS `Sueldo Bruto` from (`empleados` `e` join `areas` `a` on((`e`.`idarea` = `a`.`idarea`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-15 20:43:18
