CREATE DATABASE  IF NOT EXISTS `hoteldb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hoteldb`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hoteldb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `bookingtbl`
--

DROP TABLE IF EXISTS `bookingtbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingtbl` (
  `RNum` int NOT NULL,
  `Room` int DEFAULT NULL,
  `Customer` int DEFAULT NULL,
  `Duration` int DEFAULT NULL,
  `Cost` int DEFAULT NULL,
  `BookDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RNum`),
  KEY `Room` (`Room`),
  KEY `bookingtbl_ibfk_2` (`Customer`),
  CONSTRAINT `bookingtbl_ibfk_1` FOREIGN KEY (`Room`) REFERENCES `room1b1` (`RNum`),
  CONSTRAINT `bookingtbl_ibfk_2` FOREIGN KEY (`Customer`) REFERENCES `customer` (`CustNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingtbl`
--

LOCK TABLES `bookingtbl` WRITE;
/*!40000 ALTER TABLE `bookingtbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookingtbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustNum` int NOT NULL,
  `CustName` varchar(50) DEFAULT NULL,
  `CustPhone` varchar(50) DEFAULT NULL,
  `CustGen` varchar(10) DEFAULT NULL,
  `CustAdd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CustNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'hawi','0930854092','Female','addisababa');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room1b1`
--

DROP TABLE IF EXISTS `room1b1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room1b1` (
  `RNum` int NOT NULL,
  `RName` varchar(50) DEFAULT NULL,
  `RType` varchar(30) DEFAULT NULL,
  `RStatus` varchar(20) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  PRIMARY KEY (`RNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room1b1`
--

LOCK TABLES `room1b1` WRITE;
/*!40000 ALTER TABLE `room1b1` DISABLE KEYS */;
INSERT INTO `room1b1` VALUES (1,'Suite A','Suite','Free',7000),(2,'Suite B','Suite','Free',7000),(3,'Suite C','Suite','Free',7000),(4,'Single Bed 01','Single Bed','Free',3000),(5,'Single Bed 02','Single Bed','Free',3000),(6,'Single Bed 03','Single Bed','Free',3000),(7,'Single Bed 04','Single Bed','Free',3000),(8,'Double Bed 05','Double Bed','Free',5000),(9,'Double Bed 06','Double Bed','Free',5000),(10,'Double Bed 07','Double Bed','Free',5000),(11,'Double Bed 08','Double Bed','Free',5000),(12,'Family Room A','Family Room','Free',6500),(13,'Family Room B','Family Room','Free',6500),(14,'Family Room C','Family Room','Free',6500);
/*!40000 ALTER TABLE `room1b1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-11 18:48:00
