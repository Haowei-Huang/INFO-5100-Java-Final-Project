CREATE DATABASE  IF NOT EXISTS `psy` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `psy`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: psy
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `counsellor`
--

DROP TABLE IF EXISTS `counsellor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `counsellor` (
  `counsellorID` int unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `birthday` date NOT NULL,
  `pricePerSession` int unsigned NOT NULL,
  `yearStarted` year NOT NULL,
  `introduction` varchar(1000) NOT NULL,
  PRIMARY KEY (`counsellorID`),
  UNIQUE KEY `consultorID_UNIQUE` (`counsellorID`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=armscii8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counsellor`
--

LOCK TABLES `counsellor` WRITE;
/*!40000 ALTER TABLE `counsellor` DISABLE KEYS */;
INSERT INTO `counsellor` VALUES (1,'Sigmund','Freud','Freud1856@psy.com','1755369410','1856-05-06',1000,1930,'The founder of psychoanalysis, a clinical method for evaluating and treating pathologies in the psyche through dialogue between a patient and a psychoanalyst.'),(2,'Carl','Rogers','CarlR@psy.com','1231435221','1902-01-08',600,1933,'The founders of the humanistic approach (and client-centered approach) in psychology. Rogers is widely considered to be one of the founding fathers of psychotherapy research and was honored for his pioneering research with the Award for Distinguished Scientific Contributions by the American Psychological Association (APA) in 1956.'),(3,'Eric','Erikson','ErikErikson@psy.com','1241946312','1902-06-15',800,1936,'A Danish-German-American developmental psychologist and psychoanalyst known for his theory on psychological development of human beings');
/*!40000 ALTER TABLE `counsellor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counsellor_speciality`
--

DROP TABLE IF EXISTS `counsellor_speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `counsellor_speciality` (
  `FK_Counsellor` int unsigned NOT NULL,
  `FK_Speciality` int unsigned NOT NULL,
  PRIMARY KEY (`FK_Counsellor`,`FK_Speciality`),
  KEY `indxToSpecilization_idx` (`FK_Speciality`),
  CONSTRAINT `indxToCounsellor` FOREIGN KEY (`FK_Counsellor`) REFERENCES `counsellor` (`counsellorID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `indxToSpeciality` FOREIGN KEY (`FK_Speciality`) REFERENCES `speciality` (`specialityID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counsellor_speciality`
--

LOCK TABLES `counsellor_speciality` WRITE;
/*!40000 ALTER TABLE `counsellor_speciality` DISABLE KEYS */;
INSERT INTO `counsellor_speciality` VALUES (1,1),(2,1),(1,2),(3,2),(1,3),(2,3),(2,4),(3,4),(3,5);
/*!40000 ALTER TABLE `counsellor_speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustomerID` int unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `birthday` date NOT NULL,
  `gender` char(1) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `ID_UNIQUE` (`CustomerID`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'John','Mayer','JohnMayer@gmail.com','1234567890','1987-01-01','M'),(2,'Katy','Perry','KatyPerryr@gmail.com','1345698510','1988-08-09','F'),(3,'Sam','Smith','SamSmith@gmail.com','4372455240','1992-05-07','M'),(4,'Elton','John','EltonJohn@gmail.com','1246875301','1970-12-18','M'),(5,'Chris','Rock','ChrisRock@gmail.com','1784578699','1977-06-05','M');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `roomID` int unsigned NOT NULL AUTO_INCREMENT,
  `maxCapacity` smallint NOT NULL,
  PRIMARY KEY (`roomID`),
  UNIQUE KEY `roomID_UNIQUE` (`roomID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session` (
  `sessionID` int unsigned NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `FK_Customer` int unsigned NOT NULL,
  `FK_Counsellor` int unsigned NOT NULL,
  `FK_Room` int unsigned NOT NULL,
  PRIMARY KEY (`sessionID`),
  UNIQUE KEY `sessionID_UNIQUE` (`sessionID`),
  KEY `indxToCust_idx` (`FK_Customer`),
  KEY `indxToCounsel_idx` (`FK_Counsellor`),
  KEY `indxToRoom_idx` (`FK_Room`),
  CONSTRAINT `indxToCounsel` FOREIGN KEY (`FK_Counsellor`) REFERENCES `counsellor` (`counsellorID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `indxToCust` FOREIGN KEY (`FK_Customer`) REFERENCES `customer` (`CustomerID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `indxToRoom` FOREIGN KEY (`FK_Room`) REFERENCES `room` (`roomID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'2021-01-02 09:00:00',1,1,1),(2,'2021-06-08 10:00:00',2,1,2),(3,'2021-07-12 15:00:00',3,2,3),(4,'2021-09-18 14:00:00',4,2,4),(5,'2021-12-09 15:00:00',5,3,5);
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `time_overlap_preventor1` BEFORE INSERT ON `session` FOR EACH ROW begin
  set @newtime = NEW.time;
  set @newroom = New.FK_room;
  set @newcounsellor = NEW.FK_counsellor;
  set @newcustomer = NEW.FK_customer;
  if exists ((select * from session
             where FK_Room = @newroom or FK_counsellor = @newcounsellor or FK_customer = @newcustomer
            and (TIMESTAMPDIFF(HOUR, time, @newtime) <= 1 ))) then
    signal sqlstate '45000' SET MESSAGE_TEXT = 'Overlaps with existing time';
  end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `time_overlap_preventor2` BEFORE UPDATE ON `session` FOR EACH ROW begin
  set @newtime = NEW.time;
  set @newroom = New.FK_room;
  set @newcounsellor = NEW.FK_counsellor;
  set @newcustomer = NEW.FK_customer;
  if exists ((select * from session
             where FK_Room = @newroom or FK_counsellor = @newcounsellor or FK_customer = @newcustomer
            and (TIMESTAMPDIFF(HOUR, time, @newtime) <= 1 ))) then
    signal sqlstate '45000' SET MESSAGE_TEXT = 'Overlaps with existing time';
  end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality` (
  `specialityID` int unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`specialityID`),
  UNIQUE KEY `specializationID_UNIQUE` (`specialityID`),
  UNIQUE KEY `specilization_UNIQUE` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` VALUES (4,'ADHD'),(2,'Career'),(5,'Depression'),(3,'Marriage'),(1,'School'),(7,'Test');
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'psy'
--

--
-- Dumping routines for database 'psy'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-09  0:46:31
