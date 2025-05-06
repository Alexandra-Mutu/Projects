/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.5.28-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: task_management
-- ------------------------------------------------------
-- Server version	10.5.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentariu`
--

DROP TABLE IF EXISTS `comentariu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentariu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `continut` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKamd7jhmqe9i1pevkbapht66a1` (`task_id`),
  CONSTRAINT `FKamd7jhmqe9i1pevkbapht66a1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentariu`
--

LOCK TABLES `comentariu` WRITE;
/*!40000 ALTER TABLE `comentariu` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentariu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtask`
--

DROP TABLE IF EXISTS `subtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descriere` varchar(255) DEFAULT NULL,
  `due_date` datetime(6) DEFAULT NULL,
  `titlu` varchar(255) DEFAULT NULL,
  `task_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqogp98iwmph591yu58frt48ud` (`task_id`),
  CONSTRAINT `FKqogp98iwmph591yu58frt48ud` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtask`
--

LOCK TABLES `subtask` WRITE;
/*!40000 ALTER TABLE `subtask` DISABLE KEYS */;
/*!40000 ALTER TABLE `subtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descriere` varchar(255) DEFAULT NULL,
  `due_date` datetime(6) DEFAULT NULL,
  `responsabil` varchar(255) DEFAULT NULL,
  `titlu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_subtasks`
--

DROP TABLE IF EXISTS `task_subtasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_subtasks` (
  `task_id` bigint(20) NOT NULL,
  `subtasks_id` bigint(20) NOT NULL,
  UNIQUE KEY `UKbwe2doxllk15e4lk2h49ikekb` (`subtasks_id`),
  KEY `FKdmcpu2hllt8ur18aymfivaecd` (`task_id`),
  CONSTRAINT `FK4lmu42slpg1pf1x25kshn03o3` FOREIGN KEY (`subtasks_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FKdmcpu2hllt8ur18aymfivaecd` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_subtasks`
--

LOCK TABLES `task_subtasks` WRITE;
/*!40000 ALTER TABLE `task_subtasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_subtasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-06  1:42:10
