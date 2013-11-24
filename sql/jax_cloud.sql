-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.50-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jax_cloud
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ jax_cloud;
USE jax_cloud;

--
-- Table structure for table `jax_cloud`.`command_output`
--

DROP TABLE IF EXISTS `command_output`;
CREATE TABLE `command_output` (
  `input_filename` varchar(45) NOT NULL DEFAULT '',
  `input_os` varchar(45) NOT NULL DEFAULT '',
  `submitted_by` varchar(45) NOT NULL DEFAULT '',
  `output` longtext NOT NULL,
  `submitted_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jax_cloud`.`command_output`
--

/*!40000 ALTER TABLE `command_output` DISABLE KEYS */;
/*!40000 ALTER TABLE `command_output` ENABLE KEYS */;


--
-- Table structure for table `jax_cloud`.`login_info`
--

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `uid` varchar(45) NOT NULL DEFAULT '',
  `pwd` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jax_cloud`.`login_info`
--

/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
INSERT INTO `login_info` (`uid`,`pwd`) VALUES 
 ('jaxuser','jaxnitk123');
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;


--
-- Table structure for table `jax_cloud`.`user_machine`
--

DROP TABLE IF EXISTS `user_machine`;
CREATE TABLE `user_machine` (
  `uid` varchar(50) NOT NULL,
  `machine_name` varchar(45) NOT NULL DEFAULT '',
  `os` varchar(45) DEFAULT NULL,
  `memory_space` int(11) DEFAULT NULL,
  `storage_space` int(11) DEFAULT NULL,
  `processor_count` int(11) DEFAULT NULL,
  `created_on` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`machine_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jax_cloud`.`user_machine`
--

/*!40000 ALTER TABLE `user_machine` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_machine` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
