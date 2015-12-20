/*
SQLyog v10.2 
MySQL - 5.1.73-community : Database - wechat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wechat` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wechat`;

/*Table structure for table `t_captcha` */

DROP TABLE IF EXISTS `t_captcha`;

CREATE TABLE `t_captcha` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_code` varchar(10) NOT NULL,
  `t_enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_captcha` */

/*Table structure for table `t_manager` */

DROP TABLE IF EXISTS `t_manager`;

CREATE TABLE `t_manager` (
  `t_password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_manager` */

insert  into `t_manager`(`t_password`) values ('123');

/*Table structure for table `t_prize` */

DROP TABLE IF EXISTS `t_prize`;

CREATE TABLE `t_prize` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_prizename` varchar(20) DEFAULT NULL,
  `t_enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_prize` */

insert  into `t_prize`(`t_id`,`t_prizename`,`t_enable`) values (1,'天使计划D',''),(2,'私募基金',''),(3,'天使计划C',''),(4,'天使计划B',''),(5,'票据理财',''),(6,'债券投资',''),(7,'天使计划A',''),(8,'不要灰心',''),(9,'典当行',''),(10,'融资租赁',''),(11,'天使计划E',''),(12,'商业保理','');

/*Table structure for table `t_prizecontent` */

DROP TABLE IF EXISTS `t_prizecontent`;

CREATE TABLE `t_prizecontent` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(30) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_prizecontent` */

insert  into `t_prizecontent`(`t_id`,`t_name`) values (1,'六斤猪肉'),(2,'西瓜、、、'),(3,'芒果'),(4,'哈密瓜'),(5,'公主楼门票2张'),(6,'巴厘岛7日游'),(7,'七斤大米'),(8,'蛋糕券'),(9,'500人民币'),(10,'大礼包一个'),(11,'爱莎美容会所VIP卡两张'),(12,'继续努力');

/*Table structure for table `t_userinfo` */

DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_tel` varchar(11) NOT NULL,
  `t_prize` int(11) DEFAULT NULL,
  `t_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `t_enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `t_userinfo` */

insert  into `t_userinfo`(`t_id`,`t_tel`,`t_prize`,`t_time`,`t_enable`) values (51,'18561324671',7,'2015-12-16 14:25:02',''),(52,'18864463213',10,'2015-12-16 14:51:56','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
