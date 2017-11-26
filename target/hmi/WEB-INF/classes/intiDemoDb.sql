# ************************************************************
# Sequel Pro SQL dump
# Version 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 172.27.1.5 (MySQL 5.5.35-33.0-log)
# Database: mtdemo
# Generation Time: 2015-11-16 07:27:34 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table classroom
# ------------------------------------------------------------

DROP TABLE IF EXISTS `classroom`;

CREATE TABLE `classroom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级名字',
  `address` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;

INSERT INTO `classroom` (`id`, `name`, `address`)
VALUES
	(1,'小一班','一楼'),
	(2,'小二班','二楼'),
	(3,'小三班','三楼');

/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `name` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '学生名字',
  `age` int(11) DEFAULT NULL COMMENT '学生年龄',
  `classroom_id` int(11) DEFAULT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;

INSERT INTO `student` (`id`, `name`, `age`, `classroom_id`)
VALUES
	(1,'岳小均',10,1),
	(2,'林江圣',20,2),
	(3,'王延宾',30,3);

/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
