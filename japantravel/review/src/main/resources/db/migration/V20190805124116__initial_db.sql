-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.12-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jt_review
--

CREATE DATABASE IF NOT EXISTS jt_review;
USE jt_review;

--
-- Definition of table `destination_type_ratings`
--

DROP TABLE IF EXISTS `destination_type_ratings`;
CREATE TABLE `destination_type_ratings`
(
    `iddestination_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`             int(10) unsigned NOT NULL,
    `star_count`                 int(10) unsigned NOT NULL,
    `destination_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`iddestination_type_ratings`),
    KEY `FK_destination_type_ratings_1` (`review_type_id`),
    KEY `FK_destination_type_ratings_2` (`destination_review_id`),
    CONSTRAINT `FK_destination_type_ratings_1` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_destination_type_ratings_2` FOREIGN KEY (`destination_review_id`) REFERENCES `destinations_review` (`iddestinations_review`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `destination_type_ratings`
--

/*!40000 ALTER TABLE `destination_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `destination_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `destinations_review`
--

DROP TABLE IF EXISTS `destinations_review`;
CREATE TABLE `destinations_review`
(
    `iddestinations_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`               int(10) unsigned NOT NULL,
    `username`              varchar(255)     NOT NULL,
    `stars_review`          int(10) unsigned DEFAULT NULL,
    `comment`               text,
    `destinations_id`       int(10) unsigned DEFAULT NULL,
    `datetime`              datetime         DEFAULT NULL,
    `is_updated`            varchar(3)       NOT NULL,
    `is_approved`           varchar(3)       NOT NULL,
    `title`                 text,
    PRIMARY KEY (`iddestinations_review`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `destinations_review`
--

/*!40000 ALTER TABLE `destinations_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `destinations_review`
    ENABLE KEYS */;


--
-- Definition of table `experience_review`
--

DROP TABLE IF EXISTS `experience_review`;
CREATE TABLE `experience_review`
(
    `idexperience_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`             int(10) unsigned NOT NULL,
    `username`            varchar(255)     NOT NULL,
    `stars_review`        int(10) unsigned DEFAULT NULL,
    `comment`             text,
    `experience_id`       int(10) unsigned DEFAULT NULL,
    `datetime`            datetime         DEFAULT NULL,
    `is_updated`          varchar(3)       NOT NULL,
    `is_approved`         varchar(3)       NOT NULL,
    `title`               text,
    PRIMARY KEY (`idexperience_review`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `experience_review`
--

/*!40000 ALTER TABLE `experience_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `experience_review`
    ENABLE KEYS */;


--
-- Definition of table `experience_type_ratings`
--

DROP TABLE IF EXISTS `experience_type_ratings`;
CREATE TABLE `experience_type_ratings`
(
    `idexperience_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`            int(10) unsigned NOT NULL,
    `star_count`                int(10) unsigned NOT NULL,
    `experience_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idexperience_type_ratings`),
    KEY `FK_experience_type_ratings_1` (`review_type_id`),
    KEY `FK_experience_type_ratings_2` (`experience_review_id`),
    CONSTRAINT `FK_experience_type_ratings_1` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_experience_type_ratings_2` FOREIGN KEY (`experience_review_id`) REFERENCES `experience_review` (`idexperience_review`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `experience_type_ratings`
--

/*!40000 ALTER TABLE `experience_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `experience_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `hotels_review`
--

DROP TABLE IF EXISTS `hotels_review`;
CREATE TABLE `hotels_review`
(
    `idhotels_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`         int(10) unsigned NOT NULL,
    `username`        varchar(255)     NOT NULL,
    `stars_review`    int(10) unsigned DEFAULT NULL,
    `comment`         text,
    `hotels_id`       int(10) unsigned DEFAULT NULL,
    `datetime`        datetime         DEFAULT NULL,
    `is_updated`      varchar(3)       NOT NULL,
    `is_approved`     varchar(3)       NOT NULL,
    `title`           text,
    PRIMARY KEY (`idhotels_review`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `hotels_review`
--

/*!40000 ALTER TABLE `hotels_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `hotels_review`
    ENABLE KEYS */;


--
-- Definition of table `hotels_type_ratings`
--

DROP TABLE IF EXISTS `hotels_type_ratings`;
CREATE TABLE `hotels_type_ratings`
(
    `idhotels_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`        int(10) unsigned NOT NULL,
    `star_count`            int(10) unsigned NOT NULL,
    `hotels_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idhotels_type_ratings`),
    KEY `FK_hotels_type_ratings_1` (`review_type_id`),
    KEY `FK_hotels_type_ratings_2` (`hotels_review_id`),
    CONSTRAINT `FK_hotels_type_ratings_1` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_hotels_type_ratings_2` FOREIGN KEY (`hotels_review_id`) REFERENCES `hotels_review` (`idhotels_review`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `hotels_type_ratings`
--

/*!40000 ALTER TABLE `hotels_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `hotels_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `restaurants_review`
--

DROP TABLE IF EXISTS `restaurants_review`;
CREATE TABLE `restaurants_review`
(
    `idrestaurants_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`              int(10) unsigned NOT NULL,
    `username`             varchar(255)     NOT NULL,
    `stars_review`         int(10) unsigned DEFAULT NULL,
    `comment`              text,
    `restaurant_id`        int(10) unsigned DEFAULT NULL,
    `datetime`             datetime         DEFAULT NULL,
    `is_updated`           varchar(3)       NOT NULL,
    `is_approved`          varchar(3)       NOT NULL,
    `title`                text,
    PRIMARY KEY (`idrestaurants_review`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `restaurants_review`
--

/*!40000 ALTER TABLE `restaurants_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurants_review`
    ENABLE KEYS */;


--
-- Definition of table `restaurants_type_ratings`
--

DROP TABLE IF EXISTS `restaurants_type_ratings`;
CREATE TABLE `restaurants_type_ratings`
(
    `idrestaurants_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`             int(10) unsigned NOT NULL,
    `star_count`                 int(10) unsigned NOT NULL,
    `restaurants_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idrestaurants_type_ratings`),
    KEY `FK_restaurants_type_ratings_1` (`review_type_id`),
    KEY `FK_restaurants_type_ratings_2` (`restaurants_review_id`),
    CONSTRAINT `FK_restaurants_type_ratings_1` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_restaurants_type_ratings_2` FOREIGN KEY (`restaurants_review_id`) REFERENCES `restaurants_review` (`idrestaurants_review`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `restaurants_type_ratings`
--

/*!40000 ALTER TABLE `restaurants_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurants_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `review_types`
--

DROP TABLE IF EXISTS `review_types`;
CREATE TABLE `review_types`
(
    `idreview_types` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `type`           varchar(255)     NOT NULL,
    `category`       varchar(255)     NOT NULL,
    PRIMARY KEY (`idreview_types`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `review_types`
--

/*!40000 ALTER TABLE `review_types`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `review_types`
    ENABLE KEYS */;


--
-- Definition of table `specialevents_review`
--

DROP TABLE IF EXISTS `specialevents_review`;
CREATE TABLE `specialevents_review`
(
    `idspecialevents_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`                int(10) unsigned NOT NULL,
    `username`               varchar(255)     NOT NULL,
    `stars_review`           int(10) unsigned DEFAULT NULL,
    `comment`                text,
    `specialevents_id`       int(10) unsigned DEFAULT NULL,
    `datetime`               datetime         DEFAULT NULL,
    `is_updated`             varchar(3)       NOT NULL,
    `is_approved`            varchar(3)       NOT NULL,
    `title`                  text,
    PRIMARY KEY (`idspecialevents_review`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `specialevents_review`
--

/*!40000 ALTER TABLE `specialevents_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `specialevents_review`
    ENABLE KEYS */;


--
-- Definition of table `specialevents_type_ratings`
--

DROP TABLE IF EXISTS `specialevents_type_ratings`;
CREATE TABLE `specialevents_type_ratings`
(
    `idspecialevents_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`               int(10) unsigned NOT NULL,
    `star_count`                   int(10) unsigned NOT NULL,
    `specialevents_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idspecialevents_type_ratings`),
    KEY `FK_specialevents_type_ratings_1` (`review_type_id`),
    KEY `FK_specialevents_type_ratings_2` (`specialevents_review_id`),
    CONSTRAINT `FK_specialevents_type_ratings_1` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_specialevents_type_ratings_2` FOREIGN KEY (`specialevents_review_id`) REFERENCES `specialevents_review` (`idspecialevents_review`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `specialevents_type_ratings`
--

/*!40000 ALTER TABLE `specialevents_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `specialevents_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `tourpackages_review`
--

DROP TABLE IF EXISTS `tourpackages_review`;
CREATE TABLE `tourpackages_review`
(
    `idtourpackages_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`               int(10) unsigned NOT NULL,
    `username`              varchar(255)     NOT NULL,
    `stars_review`          int(10) unsigned DEFAULT NULL,
    `comment`               text,
    `tourpackages_id`       int(10) unsigned DEFAULT NULL,
    `datetime`              datetime         DEFAULT NULL,
    `is_updated`            varchar(3)       NOT NULL,
    `is_approved`           varchar(3)       NOT NULL,
    `title`                 text,
    PRIMARY KEY (`idtourpackages_review`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `tourpackages_review`
--

/*!40000 ALTER TABLE `tourpackages_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `tourpackages_review`
    ENABLE KEYS */;


--
-- Definition of table `tourpackages_type_ratings`
--

DROP TABLE IF EXISTS `tourpackages_type_ratings`;
CREATE TABLE `tourpackages_type_ratings`
(
    `idtourpackages_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`              int(10) unsigned NOT NULL,
    `star_count`                  int(10) unsigned NOT NULL,
    `tourpackages_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idtourpackages_type_ratings`),
    KEY `FK_tourpackages_type_ratings_1` (`tourpackages_review_id`),
    KEY `FK_tourpackages_type_ratings_2` (`review_type_id`),
    CONSTRAINT `FK_tourpackages_type_ratings_1` FOREIGN KEY (`tourpackages_review_id`) REFERENCES `tourpackages_review` (`idtourpackages_review`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_tourpackages_type_ratings_2` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `tourpackages_type_ratings`
--

/*!40000 ALTER TABLE `tourpackages_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `tourpackages_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `trainpasses_review`
--

DROP TABLE IF EXISTS `trainpasses_review`;
CREATE TABLE `trainpasses_review`
(
    `idtrainpasses_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`              int(10) unsigned NOT NULL,
    `username`             varchar(255)     NOT NULL,
    `stars_review`         int(10) unsigned DEFAULT NULL,
    `comment`              text,
    `trainpasses_id`       int(10) unsigned DEFAULT NULL,
    `datetime`             datetime         DEFAULT NULL,
    `is_updated`           varchar(3)       NOT NULL,
    `is_approved`          varchar(3)       NOT NULL,
    `title`                text,
    PRIMARY KEY (`idtrainpasses_review`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `trainpasses_review`
--

/*!40000 ALTER TABLE `trainpasses_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `trainpasses_review`
    ENABLE KEYS */;


--
-- Definition of table `trainpasses_type_ratings`
--

DROP TABLE IF EXISTS `trainpasses_type_ratings`;
CREATE TABLE `trainpasses_type_ratings`
(
    `idtrainpasses_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`             int(10) unsigned NOT NULL,
    `star_count`                 int(10) unsigned NOT NULL,
    `trainpasses_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idtrainpasses_type_ratings`),
    KEY `FK_trainpasses_type_ratings_1` (`review_type_id`),
    KEY `FK_trainpasses_type_ratings_2` (`trainpasses_review_id`),
    CONSTRAINT `FK_trainpasses_type_ratings_1` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_trainpasses_type_ratings_2` FOREIGN KEY (`trainpasses_review_id`) REFERENCES `trainpasses_review` (`idtrainpasses_review`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `trainpasses_type_ratings`
--

/*!40000 ALTER TABLE `trainpasses_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `trainpasses_type_ratings`
    ENABLE KEYS */;


--
-- Definition of table `transportation_review`
--

DROP TABLE IF EXISTS `transportation_review`;
CREATE TABLE `transportation_review`
(
    `idtransportation_review` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`                 int(10) unsigned NOT NULL,
    `username`                varchar(255)     NOT NULL,
    `stars_review`            int(10) unsigned DEFAULT NULL,
    `comment`                 text,
    `transportation_id`       int(10) unsigned DEFAULT NULL,
    `datetime`                datetime         DEFAULT NULL,
    `is_updated`              varchar(3)       NOT NULL,
    `is_approved`             varchar(3)       NOT NULL,
    `title`                   text,
    PRIMARY KEY (`idtransportation_review`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `transportation_review`
--

/*!40000 ALTER TABLE `transportation_review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `transportation_review`
    ENABLE KEYS */;


--
-- Definition of table `transportation_type_ratings`
--

DROP TABLE IF EXISTS `transportation_type_ratings`;
CREATE TABLE `transportation_type_ratings`
(
    `idtransportation_type_ratings` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `review_type_id`                int(10) unsigned NOT NULL,
    `star_count`                    int(10) unsigned NOT NULL,
    `transportation_review_id`      int(10) unsigned NOT NULL,
    PRIMARY KEY (`idtransportation_type_ratings`),
    KEY `FK_transportation_type_ratings_1` (`transportation_review_id`),
    KEY `FK_transportation_type_ratings_2` (`review_type_id`),
    CONSTRAINT `FK_transportation_type_ratings_1` FOREIGN KEY (`transportation_review_id`) REFERENCES `transportation_review` (`idtransportation_review`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_transportation_type_ratings_2` FOREIGN KEY (`review_type_id`) REFERENCES `review_types` (`idreview_types`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `transportation_type_ratings`
--

/*!40000 ALTER TABLE `transportation_type_ratings`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `transportation_type_ratings`
    ENABLE KEYS */;



/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;