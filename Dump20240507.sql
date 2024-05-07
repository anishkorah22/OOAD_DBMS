CREATE DATABASE  IF NOT EXISTS `employeemotivation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `employeemotivation`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: employeemotivation
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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` varchar(10) NOT NULL,
  `firstname` varchar(20) DEFAULT NULL,
  `secondname` varchar(20) DEFAULT NULL,
  `phno` bigint DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('EMP101','John','Doe',1234567890,'john.doe@example.com'),('EMP102','Alice','Smith',9876543210,'alice.smith@example.com'),('EMP103','Michael','Johnson',5551234567,'michael.johnson@example.com'),('EMP104','Emily','Brown',9998887776,'emily.brown@example.com'),('EMP105','Daniel','Wilson',1112223334,'daniel.wilson@example.com'),('EMP106','Sarah','Taylor',4445556667,'sarah.taylor@example.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbackform`
--

DROP TABLE IF EXISTS `feedbackform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedbackform` (
  `id` varchar(10) NOT NULL,
  `first_question` varchar(200) DEFAULT NULL,
  `second_question` varchar(200) DEFAULT NULL,
  `third_question` varchar(200) DEFAULT NULL,
  `forth_question` varchar(200) DEFAULT NULL,
  `fifth_question` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbackform`
--

LOCK TABLES `feedbackform` WRITE;
/*!40000 ALTER TABLE `feedbackform` DISABLE KEYS */;
INSERT INTO `feedbackform` VALUES ('FBF1','How effectively does the employee communicate with team members and stakeholders?','How consistently does the employee meet project deadlines and deliverables?','How well does the employee collaborate with colleagues to achieve team goals?','How effectively does the employee manage time and prioritize tasks?','How satisfied are you with the overall performance of the employee?');
/*!40000 ALTER TABLE `feedbackform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbackresponse`
--

DROP TABLE IF EXISTS `feedbackresponse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedbackresponse` (
  `id` varchar(10) NOT NULL,
  `feedbackform_id` varchar(10) DEFAULT NULL,
  `emp_id` varchar(10) DEFAULT NULL,
  `first_response` int DEFAULT NULL,
  `second_response` int DEFAULT NULL,
  `third_response` int DEFAULT NULL,
  `forth_response` int DEFAULT NULL,
  `fifth_response` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `feedbackform_id` (`feedbackform_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `feedbackresponse_ibfk_1` FOREIGN KEY (`feedbackform_id`) REFERENCES `feedbackform` (`id`),
  CONSTRAINT `feedbackresponse_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbackresponse`
--

LOCK TABLES `feedbackresponse` WRITE;
/*!40000 ALTER TABLE `feedbackresponse` DISABLE KEYS */;
INSERT INTO `feedbackresponse` VALUES ('FBR100','FBF1','EMP102',4,5,3,4,5),('FBR101','FBF1','EMP103',3,3,2,3,3),('FBR102','FBF1','EMP104',2,2,1,2,2),('FBR103','FBF1','EMP105',3,5,3,4,5),('FBR104','FBF1','EMP106',4,5,5,4,5);
/*!40000 ALTER TABLE `feedbackresponse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivationsession`
--

DROP TABLE IF EXISTS `motivationsession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motivationsession` (
  `id` int NOT NULL AUTO_INCREMENT,
  `performance_id` varchar(10) DEFAULT NULL,
  `assignedto` varchar(10) DEFAULT NULL,
  `sessionassigned` varchar(25) DEFAULT NULL,
  `feedbackform_id` varchar(10) DEFAULT NULL,
  `feedbackresponse_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `performance_id` (`performance_id`),
  KEY `assignedto` (`assignedto`),
  KEY `feedbackform_id` (`feedbackform_id`),
  KEY `feedbackresponse_id` (`feedbackresponse_id`),
  CONSTRAINT `motivationsession_ibfk_1` FOREIGN KEY (`performance_id`) REFERENCES `performance` (`id`),
  CONSTRAINT `motivationsession_ibfk_2` FOREIGN KEY (`assignedto`) REFERENCES `employee` (`id`),
  CONSTRAINT `motivationsession_ibfk_3` FOREIGN KEY (`feedbackform_id`) REFERENCES `feedbackform` (`id`),
  CONSTRAINT `motivationsession_ibfk_4` FOREIGN KEY (`feedbackresponse_id`) REFERENCES `feedbackresponse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivationsession`
--

LOCK TABLES `motivationsession` WRITE;
/*!40000 ALTER TABLE `motivationsession` DISABLE KEYS */;
INSERT INTO `motivationsession` VALUES (1,'EMP102_2','EMP103','Meditation','FBF1','FBR101'),(2,'EMP102_3','EMP104','Training with Meditation','FBF1','FBR102'),(6,'EMP102_3','EMP104','Training with Meditation','FBF1','FBR102');
/*!40000 ALTER TABLE `motivationsession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performance` (
  `id` varchar(10) NOT NULL,
  `pointassignedby` varchar(10) DEFAULT NULL,
  `pointassignedto` varchar(10) DEFAULT NULL,
  `reviewdate` date DEFAULT NULL,
  `rewardpoints` int DEFAULT NULL,
  `feedbackform_id` varchar(10) DEFAULT NULL,
  `feedbackresponse_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pointassignedby` (`pointassignedby`),
  KEY `pointassignedto` (`pointassignedto`),
  KEY `fk_created_by` (`feedbackform_id`),
  KEY `fk_updated_by` (`feedbackresponse_id`),
  CONSTRAINT `fk_created_by` FOREIGN KEY (`feedbackform_id`) REFERENCES `feedbackform` (`id`),
  CONSTRAINT `fk_updated_by` FOREIGN KEY (`feedbackresponse_id`) REFERENCES `feedbackresponse` (`id`),
  CONSTRAINT `performance_ibfk_1` FOREIGN KEY (`pointassignedby`) REFERENCES `employee` (`id`),
  CONSTRAINT `performance_ibfk_2` FOREIGN KEY (`pointassignedto`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance`
--

LOCK TABLES `performance` WRITE;
/*!40000 ALTER TABLE `performance` DISABLE KEYS */;
INSERT INTO `performance` VALUES ('EMP102_1','EMP101','EMP102','2024-05-01',21,'FBF1','FBR100'),('EMP102_2','EMP101','EMP103','2024-05-01',14,'FBF1','FBR101'),('EMP102_3','EMP101','EMP104','2024-05-01',9,'FBF1','FBR102'),('EMP102_4','EMP101','EMP105','2024-05-01',20,'FBF1','FBR103'),('EMP102_5','EMP101','EMP106','2024-05-01',23,'FBF1','FBR104');
/*!40000 ALTER TABLE `performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewardsession`
--

DROP TABLE IF EXISTS `rewardsession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewardsession` (
  `id` int NOT NULL AUTO_INCREMENT,
  `performance_id` varchar(10) DEFAULT NULL,
  `assignedto` varchar(10) DEFAULT NULL,
  `rewardtype` varchar(25) DEFAULT NULL,
  `feedbackform_id` varchar(10) DEFAULT NULL,
  `feedbackresponse_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `performance_id` (`performance_id`),
  KEY `assignedto` (`assignedto`),
  KEY `fk_feedback_id` (`feedbackform_id`),
  KEY `feedbackresponse_id` (`feedbackresponse_id`),
  CONSTRAINT `fk_feedback_id` FOREIGN KEY (`feedbackform_id`) REFERENCES `feedbackform` (`id`),
  CONSTRAINT `rewardsession_ibfk_1` FOREIGN KEY (`performance_id`) REFERENCES `performance` (`id`),
  CONSTRAINT `rewardsession_ibfk_2` FOREIGN KEY (`assignedto`) REFERENCES `employee` (`id`),
  CONSTRAINT `rewardsession_ibfk_3` FOREIGN KEY (`feedbackresponse_id`) REFERENCES `feedbackresponse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewardsession`
--

LOCK TABLES `rewardsession` WRITE;
/*!40000 ALTER TABLE `rewardsession` DISABLE KEYS */;
INSERT INTO `rewardsession` VALUES (4,'EMP102_4','EMP105','Wellness session','FBF1','FBR103'),(5,'EMP102_1','EMP102','Bonus','FBF1','FBR100'),(6,'EMP102_5','EMP106','Bonus','FBF1','FBR104');
/*!40000 ALTER TABLE `rewardsession` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 11:41:47
