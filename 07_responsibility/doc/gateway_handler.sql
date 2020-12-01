-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.4.10-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `test`;

-- 导出  表 test.gateway_handler 结构
CREATE TABLE IF NOT EXISTS `gateway_handler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `handler_name` varchar(50) DEFAULT NULL,
  `handler_id` varchar(50) DEFAULT NULL,
  `prev_handler_id` varchar(50) DEFAULT NULL,
  `next_handler_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test.gateway_handler 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `gateway_handler` DISABLE KEYS */;
INSERT INTO `gateway_handler` (`id`, `handler_name`, `handler_id`, `prev_handler_id`, `next_handler_id`) VALUES
	(1, 'API接口限流', 'currentLimitHandler', NULL, 'blacklistHandler'),
	(2, '黑名单拦截', 'blacklistHandler', 'currentLimitHandler', 'tokenHandler'),
	(3, 'token验证', 'tokenHandler', 'blacklistHandler', NULL);
/*!40000 ALTER TABLE `gateway_handler` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
