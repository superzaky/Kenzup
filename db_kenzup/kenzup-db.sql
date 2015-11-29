-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server versie:                5.6.26 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Versie:              8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Databasestructuur van android_api wordt geschreven
CREATE DATABASE IF NOT EXISTS `android_api` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `android_api`;


-- Structuur van  tabel android_api.users wordt geschreven
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `unique_id` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `encrypted_password` varchar(50) NOT NULL DEFAULT '0',
  `salt` varchar(50) NOT NULL DEFAULT '0',
  `created_at` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumpen data van tabel android_api.users: ~7 rows (ongeveer)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`) VALUES
	(5, '5654dbe24e5628.15978242', 'a', 'a', 'AjKI7ksS2MPU+9c0ntcHWMalHb9mYjEwMmNhNWJi', 'fb102ca5bb', '2015-11-24'),
	(6, '5654df29c9b360.66025487', 'b', 'b@gmail.com', '/prx/vkSuNpniUdc8/4xP8ZhmI80YTY3YTAzMDE1', '4a67a03015', '2015-11-24');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
