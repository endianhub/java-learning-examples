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

-- 导出  表 test.strategy 结构
CREATE TABLE IF NOT EXISTS `strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strategy_name` varchar(50) DEFAULT NULL,
  `strategy_id` varchar(50) DEFAULT NULL,
  `strategy_type` varchar(50) DEFAULT NULL,
  `strategy_bean_id` varchar(50) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test.strategy 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `strategy` DISABLE KEYS */;
INSERT INTO `strategy` (`id`, `strategy_name`, `strategy_id`, `strategy_type`, `strategy_bean_id`, `deleted`) VALUES
	(1, '阿里云', 'aliyu_sms', 'send_msg', 'aliYunStrategy', 0),
	(2, '华为云', 'huawei_sms', 'send_msg', 'huaWeiStrategy', 0);
/*!40000 ALTER TABLE `strategy` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
