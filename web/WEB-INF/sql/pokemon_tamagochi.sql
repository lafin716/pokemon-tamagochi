-- MySQL dump 10.15  Distrib 10.0.17-MariaDB, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: user
-- ------------------------------------------------------
-- Server version	10.6.3-MariaDB-1:10.6.3+maria~focal

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_exp`
--

DROP TABLE IF EXISTS `tb_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_exp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_exp_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_exp`
--

LOCK TABLES `tb_exp` WRITE;
/*!40000 ALTER TABLE `tb_exp` DISABLE KEYS */;
INSERT INTO `tb_exp` (`id`, `level`, `exp`) VALUES (1,1,10),(2,2,20),(3,3,30),(4,4,40),(5,5,50),(6,6,60),(7,7,70),(8,8,80),(9,9,90),(10,10,100),(11,11,110),(12,12,120),(13,13,130),(14,14,140),(15,15,150),(16,16,160),(17,17,170),(18,18,180),(19,19,190),(20,20,200),(21,21,210),(22,22,220),(23,23,230),(24,24,240),(25,25,250),(26,26,260),(27,27,270),(28,28,280),(29,29,290),(30,30,300),(31,31,310),(32,32,320),(33,33,330),(34,34,340),(35,35,350),(36,36,360),(37,37,370),(38,38,380),(39,39,390),(40,40,400),(41,41,410),(42,42,420),(43,43,430),(44,44,440),(45,45,450),(46,46,460),(47,47,470),(48,48,480),(49,49,490),(50,50,500);
/*!40000 ALTER TABLE `tb_exp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pokemon`
--

DROP TABLE IF EXISTS `tb_pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pokemon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serialNumber` varchar(4) NOT NULL,
  `pokemonName` varchar(20) DEFAULT NULL,
  `pokemonType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_pokemon_serialNumber_uindex` (`serialNumber`),
  UNIQUE KEY `tb_pokemon_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COMMENT='포켓몬 도감';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pokemon`
--

LOCK TABLES `tb_pokemon` WRITE;
/*!40000 ALTER TABLE `tb_pokemon` DISABLE KEYS */;
INSERT INTO `tb_pokemon` (`id`, `serialNumber`, `pokemonName`, `pokemonType`) VALUES (1,'001','이상해씨','풀|독'),(2,'002','이상해풀','풀|독'),(3,'003','이상해꽃','풀|독'),(4,'004','파이리','불꽃'),(5,'005','리자드','불꽃'),(6,'006','리자몽','불꽃|비행'),(7,'007','꼬부기','물'),(8,'008','어니부기','물'),(9,'009','거북왕','물'),(10,'010','캐터피','벌레'),(11,'011','단데기','벌레'),(12,'012','버터플','벌레|비행'),(13,'013','뿔충이','벌레|독'),(14,'014','딱충이','벌레|독'),(15,'015','독침붕','벌레|독'),(16,'016','구구','노말|비행'),(17,'017','피죤','노말|비행'),(18,'018','피죤투','노말|비행'),(19,'019','꼬렛','노말'),(20,'020','레트라','노말'),(21,'021','깨비참','노말|비행'),(22,'022','깨비드릴조','노말|비행'),(23,'023','아보','독'),(24,'024','아보크','독'),(25,'025','피카츄','전기'),(26,'026','라이츄','전기'),(27,'027','모래두지','땅'),(28,'028','고지','땅'),(29,'029','니드런♀','독'),(30,'030','니드리나','독'),(31,'031','니드퀸','독|땅'),(32,'032','니드런♂','독'),(33,'033','니드리노','독'),(34,'034','니드킹','독|땅'),(35,'035','삐삐','페어리'),(36,'036','픽시','페어리'),(37,'037','식스테일','불꽃'),(38,'038','나인테일','불꽃'),(39,'039','푸린','노말|페어리'),(40,'040','푸크린','노말|페어리'),(41,'041','주뱃','독|비행'),(42,'042','골뱃','독|비행'),(43,'043','뚜벅쵸','풀|독'),(44,'044','냄새꼬','풀|독'),(45,'045','라플레시아','풀|독'),(46,'046','파라스','벌레|풀'),(47,'047','파라섹트','벌레|풀'),(48,'048','콘팡','벌레|독'),(49,'049','도나리','벌레|독'),(50,'050','디그다','땅'),(51,'051','닥트리오','땅'),(52,'052','나옹','노말'),(53,'053','페르시온','노말'),(54,'054','고라파덕','물'),(55,'055','골덕','물'),(56,'056','망키','격투'),(57,'057','성원숭','격투'),(58,'058','가디','불꽃'),(59,'059','윈디','불꽃'),(60,'060','발챙이','물'),(61,'061','슈륙챙이','물'),(62,'062','강챙이','물|격투'),(63,'063','캐이시','에스퍼'),(64,'064','윤겔라','에스퍼'),(65,'065','후딘','에스퍼'),(66,'066','알통몬','격투'),(67,'067','근육몬','격투'),(68,'068','괴력몬','격투'),(69,'069','모다피','풀|독'),(70,'070','우츠동','풀|독'),(71,'071','우츠보트','풀|독'),(72,'072','왕눈해','물|독'),(73,'073','독파리','물|독'),(74,'074','꼬마돌','바위|땅'),(75,'075','데구리','바위|땅'),(76,'076','딱구리','바위|땅'),(77,'077','포니타','불꽃'),(78,'078','날쌩마','불꽃'),(79,'079','야돈','물|에스퍼'),(80,'080','야도란','물|에스퍼'),(81,'081','코일','전기|강철'),(82,'082','레어코일','전기|강철'),(83,'083','파오리','노말|비행'),(84,'084','두두','노말|비행'),(85,'085','두트리오','노말|비행'),(86,'086','쥬쥬','물'),(87,'087','쥬레곤','물|얼음'),(88,'088','질퍽이','독'),(89,'089','질뻐기','독'),(90,'090','셀러','물'),(91,'091','파르셀','물|얼음'),(92,'092','고오스','고스트|독'),(93,'093','고우스트','고스트|독'),(94,'094','팬텀','고스트|독'),(95,'095','롱스톤','바위|땅'),(96,'096','슬리프','에스퍼'),(97,'097','슬리퍼','에스퍼'),(98,'098','크랩','물'),(99,'099','킹크랩','물'),(100,'100','찌리리공','전기'),(101,'101','붐볼','전기'),(102,'102','아라리','풀|에스퍼'),(103,'103','나시','풀|에스퍼'),(104,'104','탕구리','땅'),(105,'105','텅구리','땅'),(106,'106','시라소몬','격투'),(107,'107','홍수몬','격투'),(108,'108','내루미','노말'),(109,'109','또가스','독'),(110,'110','또도가스','독'),(111,'111','뿔카노','땅|바위'),(112,'112','코뿌리','땅|바위'),(113,'113','럭키','노말'),(114,'114','덩쿠리','풀'),(115,'115','캥카','노말'),(116,'116','쏘드라','물'),(117,'117','시드라','물'),(118,'118','콘치','물'),(119,'119','왕콘치','물'),(120,'120','별가사리','물'),(121,'121','아쿠스타','물|에스퍼'),(122,'122','마임맨','에스퍼|페어리'),(123,'123','스라크','벌레|비행'),(124,'124','루주라','얼음|에스퍼'),(125,'125','에레브','전기'),(126,'126','마그마','불꽃'),(127,'127','쁘사이저','벌레'),(128,'128','켄타로스','노말'),(129,'129','잉어킹','물'),(130,'130','갸라도스','물|비행'),(131,'131','라프라스','물|얼음'),(132,'132','메타몽','노말'),(133,'133','이브이','노말'),(134,'134','샤미드','물'),(135,'135','쥬피썬더','전기'),(136,'136','부스터','불꽃'),(137,'137','폴리곤','노말'),(138,'138','암나이트','바위|물'),(139,'139','암스타','바위|물'),(140,'140','투구','바위|물'),(141,'141','투구푸스','바위|물'),(142,'142','프테라','바위|비행'),(143,'143','잠만보','노말'),(144,'144','프리져','얼음|비행'),(145,'145','썬더','전기|비행'),(146,'146','파이어','불꽃|비행'),(147,'147','미뇽','드래곤'),(148,'148','신뇽','드래곤'),(149,'149','망나뇽','드래곤|비행'),(150,'150','뮤츠','에스퍼'),(151,'151','뮤','에스퍼');
/*!40000 ALTER TABLE `tb_pokemon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pokemon_detail`
--

DROP TABLE IF EXISTS `tb_pokemon_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pokemon_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerId` int(11) DEFAULT NULL,
  `pokemonId` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  `isMain` smallint(6) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `hapiness` int(11) DEFAULT NULL,
  `hungry` int(11) DEFAULT NULL,
  `catchedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_pokemon_detail_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='잡은 포켓몬 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pokemon_detail`
--

LOCK TABLES `tb_pokemon_detail` WRITE;
/*!40000 ALTER TABLE `tb_pokemon_detail` DISABLE KEYS */;
INSERT INTO `tb_pokemon_detail` (`id`, `ownerId`, `pokemonId`, `level`, `exp`, `isMain`, `status`, `nickname`, `hapiness`, `hungry`, `catchedAt`) VALUES (3,2,4,1,0,1,'NORMAL','파이리',50,100,'2022-02-05 23:35:33'),(4,3,3,10,60,1,'RUN','이상해씨',100,27,'2022-02-06 18:07:28');
/*!40000 ALTER TABLE `tb_pokemon_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_revolution`
--

DROP TABLE IF EXISTS `tb_revolution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_revolution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pokemonId` int(11) DEFAULT NULL,
  `nextPokemonId` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_revolution_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_revolution`
--

LOCK TABLES `tb_revolution` WRITE;
/*!40000 ALTER TABLE `tb_revolution` DISABLE KEYS */;
INSERT INTO `tb_revolution` (`id`, `pokemonId`, `nextPokemonId`, `level`) VALUES (1,1,2,5),(2,2,3,10),(3,4,5,5),(4,5,6,10),(5,7,8,5),(6,8,9,10),(7,10,11,5),(8,11,12,10),(9,13,14,5),(10,14,15,10),(11,16,17,5),(12,17,18,10),(13,19,20,7),(14,21,22,7),(15,23,24,7),(16,25,26,7),(17,27,28,7),(18,29,31,5),(19,31,33,10),(20,30,32,5),(21,32,34,10),(22,35,36,7),(23,37,38,7),(24,39,40,7),(25,41,42,7),(26,43,44,5),(27,44,45,10),(28,46,47,7),(29,48,49,7),(30,50,51,7),(31,52,53,7),(32,54,55,7),(33,56,57,7),(34,58,59,7),(35,60,61,5),(36,61,62,10),(37,63,64,5),(38,64,65,10),(39,66,67,5),(40,67,68,10),(41,69,70,5),(42,70,71,10),(43,72,73,5),(44,73,74,10),(45,75,76,7),(46,77,78,7),(47,79,80,7),(48,81,82,7),(49,84,85,7),(50,86,87,7),(51,88,89,7),(52,90,91,7),(53,92,93,5),(54,93,94,10),(55,96,97,7),(56,98,99,7),(57,100,101,7),(58,102,103,7),(59,104,105,7),(60,109,110,7),(61,111,112,7),(62,116,117,7),(63,118,119,7),(64,120,121,7),(65,129,130,7),(66,133,134,10),(67,133,135,10),(68,133,136,10),(69,138,139,12),(70,140,141,12),(71,147,148,15);
/*!40000 ALTER TABLE `tb_revolution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`, `name`, `email`, `password`, `createdAt`) VALUES (1,'재욱','lafin716@gmail.com','lafin1234','2022-02-04 19:35:03'),(2,'박재욱','lafin716@naver.com','test','2022-02-04 19:36:10'),(3,'재욱','wndlf0128@naver.com','test','2022-02-06 09:03:27');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'user'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-06 22:42:50
