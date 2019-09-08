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
-- Create schema jt_restaurants
--

CREATE DATABASE IF NOT EXISTS jt_restaurants;
USE jt_restaurants;

--
-- Definition of table `item_category`
--

DROP TABLE IF EXISTS `item_category`;
CREATE TABLE `item_category` (
  `iditem_category` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_category_name` varchar(255) NOT NULL,
  `is_enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`iditem_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item_category`
--

/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_category` ENABLE KEYS */;


--
-- Definition of table `restaurant_item_images`
--

DROP TABLE IF EXISTS `restaurant_item_images`;
CREATE TABLE `restaurant_item_images` (
  `idrestaurant_item_images` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `restaurant_items_id` int(10) unsigned NOT NULL,
  `image_path` varchar(100) NOT NULL,
  PRIMARY KEY (`idrestaurant_item_images`),
  KEY `FK_restaurant_item_images_1` (`restaurant_items_id`),
  CONSTRAINT `FK_restaurant_item_images_1` FOREIGN KEY (`restaurant_items_id`) REFERENCES `restaurant_items` (`idrestaurant_items`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_item_images`
--

/*!40000 ALTER TABLE `restaurant_item_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant_item_images` ENABLE KEYS */;


--
-- Definition of table `restaurant_items`
--

DROP TABLE IF EXISTS `restaurant_items`;
CREATE TABLE `restaurant_items` (
  `idrestaurant_items` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `introduction` text,
  `description` text,
  `price` double NOT NULL,
  `item_category_id` int(10) unsigned DEFAULT NULL,
  `ranking` double DEFAULT NULL,
  `restaurant_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idrestaurant_items`),
  KEY `FK_restaurant_items_1` (`item_category_id`),
  KEY `FK_restaurant_items_2` (`restaurant_id`),
  CONSTRAINT `FK_restaurant_items_1` FOREIGN KEY (`item_category_id`) REFERENCES `item_category` (`iditem_category`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_restaurant_items_2` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`idrestaurants`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_items`
--

/*!40000 ALTER TABLE `restaurant_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant_items` ENABLE KEYS */;


--
-- Definition of table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
CREATE TABLE `restaurants` (
  `idrestaurants` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `restaurants_name` varchar(255) NOT NULL,
  `ranking` double DEFAULT NULL,
  `description` text,
  `country_id` int(10) unsigned DEFAULT NULL,
  `district_id` int(10) unsigned DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`idrestaurants`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants`
--

/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
