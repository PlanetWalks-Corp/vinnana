-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: dynamicsinglepage
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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `album_id` bigint NOT NULL,
  `album_name` varchar(255) DEFAULT NULL,
  `city_city_id` bigint DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  KEY `FK3q2c83nutj0iyrepd178x10pu` (`city_city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (2,'Jalandhar',1);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` bigint NOT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `geo_location` varchar(255) DEFAULT NULL,
  `history` varchar(4000) DEFAULT NULL,
  `population` bigint DEFAULT NULL,
  `slug` varchar(32) NOT NULL,
  `weather_conditions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  UNIQUE KEY `UK_3kywok3ge37e90c6nc8iuyo6l` (`slug`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Jalandhar','31° 19\' 33.6540\'\' N and 75° 34\' 34.2480\'\' E','In ancient time, the district or Kingdom of Jalandhar comprised the whole of the Upper Doabas from the Ravi to the Satluj. According to the Padama Purana, as quoted by General Conningham the country takes its name from the great Daitya King Danava Jalandhara the son of the Ganga by Ocean.',873725,'Jalandhar','Best time to visit is winters');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fair`
--

DROP TABLE IF EXISTS `fair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fair` (
  `fair_id` bigint NOT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `fair_name` varchar(255) DEFAULT NULL,
  `fair_type` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `city_city_id` bigint DEFAULT NULL,
  PRIMARY KEY (`fair_id`),
  KEY `FKlxv31ah19mvb07lns8vt3qobq` (`city_city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fair`
--

LOCK TABLES `fair` WRITE;
/*!40000 ALTER TABLE `fair` DISABLE KEYS */;
INSERT INTO `fair` VALUES (3,'Sodal Mela is an extremely prevalent Fair celebrated in the city of Jalandhar, on the fourteenth day of Shukla Paksh in the long stretch of Bhadon as per the Hindu Calender. As per the English schedule it falls in the long stretch of September.','Sodal Mela','religious','http://res.cloudinary.com/ksush/image/upload/v1610881854/rb2fl9nr6twkz5rgcpnb.jpg',1),(4,'The dargah of Baba Murad Shah ji after the death of Sai Laddi Shah Ji was offered to the famous Punjabi singer, Mr. Gurdas Maan Ji who has remained as a sewadaar. Various singers perform at this powerful place and also there is a mela (fair) celebrated regularly in Memory of Baba Murad Shah Ji and Sai Ghulam (Laddi) Shah Ji','Nakodar Mela','religious','http://res.cloudinary.com/ksush/image/upload/v1610881903/etodqzirhb0u1hsdgkag.jpg',1),(5,'Shaheedi Jor mela, which is held annually in the memory of Shaheed Baba Nihal Singh. The mela is a big attraction in Jalandhar. An annual Mela is held to mark the death anniversary (\"Barsi\") of the Shaheed Baba Nihal Singh.','Shaheedi Jor mela','religious','http://res.cloudinary.com/ksush/image/upload/v1610881938/dak229beyg7c5i08pw2v.jpg',1);
/*!40000 ALTER TABLE `fair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `image_id` bigint NOT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `album_album_id` bigint DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK9h9yy315uue4egfwt54kg2urk` (`album_album_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (9,'http://res.cloudinary.com/ksush/image/upload/v1610882364/seonsqrv2hfs9h4uafzg.jpg',2),(10,'http://res.cloudinary.com/ksush/image/upload/v1610882417/jendhkd6a26q4nymurqi.jpg',2),(11,'http://res.cloudinary.com/ksush/image/upload/v1610882449/foh4w8pnbqb6logk6asg.jpg',2);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `person_id` bigint NOT NULL,
  `age` int DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `person_first_name` varchar(255) DEFAULT NULL,
  `person_last_name` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `city_city_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FKgackdwx3h7c1s9rotomg56uao` (`city_city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (6,40,'Harbhajan Singh Plaha, commonly known as Harbhajan or simply Bhajji or Bhajju Pa, is an Indian cricketer, who has played all formats of cricket for India.  specialist spin bowler, he has the second-highest number of Test wickets by an off spinner','1980-07-03','http://res.cloudinary.com/ksush/image/upload/v1610882091/ql6xkrecobgu2xeoufba.jpg','Harbhajan ','Singh','Cricket Player',1),(7,37,'Rannvijay Singh Singha is an Indian actor, television personality and VJ. Rannvijay is known for his appearance in MTV Roadies, where he won the show.He has been part of the show from 2004 to 2019 and continues to do so','1983-03-16','http://res.cloudinary.com/ksush/image/upload/v1610882196/trvpkhgikp6lbprb9tqe.jpg','Rannvijay ','Singha ','Actor',1),(8,48,'Dalip Singh Rana, better known by the ring name The Great Khali, is an Indian-born American professional wrestler, promoter, model, and actor who is best known for his work in WWE.','1972-08-27','http://res.cloudinary.com/ksush/image/upload/v1610882298/jnk8oph2l4f9uf2ti0n0.jpg','The Great ','Khali ','Ex-Wrestler',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `place_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `place_type` varchar(255) DEFAULT NULL,
  `city_city_id` bigint DEFAULT NULL,
  PRIMARY KEY (`place_id`),
  KEY `FKs797gcc59sykrbw937q0022rw` (`city_city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (12,'Jalandhar Kapurthala Road, Punjab, India 144601','Science City Kapurthala, otherwise known as Pushpa Gujral Science City is a haven for science enthusiasts established by the Government of Punjab.','http://res.cloudinary.com/ksush/image/upload/v1610882590/bescvwzxgrn1p9u2vfsu.jpg','Science City','Fun',1),(13,'Jalandhar - Nakodar Rd, Wadala Chowk, After, Jalandhar, Punjab 144001','Park with family-friendly rides, including a small roller coaster, plus water slides & a wave pool.','http://res.cloudinary.com/ksush/image/upload/v1610882672/puisvscvvg2ii3xyvy14.jpg','Wonderland','Fun',1),(14,'Tanda Rd, Shiv Nagar, Industrial Area, Jalandhar, Punjab 144004','Devi Talab Mandir or Devi Talab Temple s devoted to Goddess Durga and is believed to be at least 200 years old. Thousands of pilgrims visit the temple every year and is one of the 51 Shakthi pithas in India.','http://res.cloudinary.com/ksush/image/upload/v1610882726/o5pzaj4opnlvo8c92cqt.jpg','Devi Talab Mandir','Religious',1);
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-17 16:57:55
