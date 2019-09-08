-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.12-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jt_specialevents
--

CREATE DATABASE IF NOT EXISTS jt_specialevents;
USE jt_specialevents;

--
-- Definition of table `specialevents`
--

DROP TABLE IF EXISTS `specialevents`;
CREATE TABLE `specialevents` (
  `idspecialevents` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `address` text,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `ranking` double DEFAULT '0',
  `location_id` int(11) unsigned DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  PRIMARY KEY (`idspecialevents`) USING BTREE,
  KEY `FK_destination_1` (`location_id`),
  KEY `destination_rank_index` (`ranking`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `specialevents`
--

/*!40000 ALTER TABLE `specialevents` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialevents` ENABLE KEYS */;


--
-- Definition of table `specialevents_images`
--

DROP TABLE IF EXISTS `specialevents_images`;
CREATE TABLE `specialevents_images` (
  `idspecialevents_images` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `specialevent_id` int(10) unsigned NOT NULL,
  `image_path_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idspecialevents_images`),
  KEY `FK_specialevents_images_1` (`specialevent_id`),
  CONSTRAINT `FK_specialevents_images_1` FOREIGN KEY (`specialevent_id`) REFERENCES `specialevents` (`idspecialevents`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `specialevents_images`
--

/*!40000 ALTER TABLE `specialevents_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialevents_images` ENABLE KEYS */;


--
-- Definition of table `specialevents_tags`
--

DROP TABLE IF EXISTS `specialevents_tags`;
CREATE TABLE `specialevents_tags` (
  `idspecialevents_tags` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag` text,
  `is_enable` tinyint(1) NOT NULL,
  `specialevents_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idspecialevents_tags`),
  KEY `FK_specialevents_tags_1` (`specialevents_id`),
  CONSTRAINT `FK_specialevents_tags_1` FOREIGN KEY (`specialevents_id`) REFERENCES `specialevents` (`idspecialevents`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `specialevents_tags`
--

/*!40000 ALTER TABLE `specialevents_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialevents_tags` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
