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
-- Create schema jt_destinations
--

CREATE DATABASE IF NOT EXISTS jt_destinations;
USE jt_destinations;

--
-- Definition of table `destination`
--

DROP TABLE IF EXISTS `destination`;
CREATE TABLE `destination` (
  `iddestination` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `address` text,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `ranking` double DEFAULT '0',
  `country_id` int(11) unsigned DEFAULT NULL,
  `destrict_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`iddestination`),
  KEY `destination_rank_index` (`ranking`) USING BTREE,
  KEY `FK_destination_1` (`country_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `destination`
--

/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` (`iddestination`,`title`,`description`,`address`,`latitude`,`longitude`,`ranking`,`country_id`,`destrict_id`) VALUES
 (1,'test title','desc uditha','address ud',10,12,3,1,NULL),
 (2,'test a title','desca auditha','addreass ud',20,20,5,1,NULL),
 (3,'test title ud','uditha','address ud',10,12,4,1,NULL),
 (5,'test title','desc uditha','address ud',10,12,6,1,NULL),
 (6,'test title 1.0','desc krishan','address 123',5,80,2,1,NULL);
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;


--
-- Definition of table `destination_images`
--

DROP TABLE IF EXISTS `destination_images`;
CREATE TABLE `destination_images` (
  `iddestination_images` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `destination_id` int(10) unsigned NOT NULL,
  `image_path_id` varchar(100) NOT NULL,
  PRIMARY KEY (`iddestination_images`),
  KEY `FK_destination_images_1` (`destination_id`),
  CONSTRAINT `FK_destination_images_1` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`iddestination`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `destination_images`
--

/*!40000 ALTER TABLE `destination_images` DISABLE KEYS */;
INSERT INTO `destination_images` (`iddestination_images`,`destination_id`,`image_path_id`) VALUES
 (1,1,'path1'),
 (2,1,'path2'),
 (3,1,'path3'),
 (4,3,'path1'),
 (5,3,'path2'),
 (6,3,'path3'),
 (7,5,'path1'),
 (8,5,'path2'),
 (9,5,'path3'),
 (10,5,'path1'),
 (11,5,'path2'),
 (12,5,'path3'),
 (13,6,'path1'),
 (14,6,'path2'),
 (15,6,'path3'),
 (16,6,'path1'),
 (17,6,'path2'),
 (18,6,'path3');
/*!40000 ALTER TABLE `destination_images` ENABLE KEYS */;


--
-- Definition of table `destination_tags`
--

DROP TABLE IF EXISTS `destination_tags`;
CREATE TABLE `destination_tags` (
  `iddestination_tags` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag` text NOT NULL,
  `is_enable` varchar(5) NOT NULL,
  `destination_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`iddestination_tags`),
  KEY `FK_destination_tags_1` (`destination_id`),
  CONSTRAINT `FK_destination_tags_1` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`iddestination`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `destination_tags`
--

/*!40000 ALTER TABLE `destination_tags` DISABLE KEYS */;
INSERT INTO `destination_tags` (`iddestination_tags`,`tag`,`is_enable`,`destination_id`) VALUES
 (1,'tag1','YES',1),
 (2,'tag2','YES',1),
 (3,'tag3','YES',1),
 (4,'tag1','YES',3),
 (5,'tag2','YES',3),
 (6,'tag3','YES',3),
 (7,'tag1','YES',5),
 (8,'tag2','YES',5),
 (9,'tag3','YES',5),
 (10,'tag1','YES',5),
 (11,'tag2','YES',5),
 (12,'tag3','YES',5),
 (13,'tag1','YES',6),
 (14,'tag2','YES',6),
 (15,'tag3','YES',6),
 (16,'tag1','YES',6),
 (17,'tag2','YES',6),
 (18,'tag3','YES',6);
/*!40000 ALTER TABLE `destination_tags` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
