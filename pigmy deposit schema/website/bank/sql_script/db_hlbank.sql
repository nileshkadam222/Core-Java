-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2015 at 06:50 AM
-- Server version: 5.5.36
-- PHP Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_hlbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_accounts`
--

CREATE TABLE IF NOT EXISTS `tbl_accounts` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `acc_no` varchar(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `balance` double NOT NULL,
  `pin` int(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `bdate` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tbl_accounts`
--

INSERT INTO `tbl_accounts` (`id`, `user_id`, `acc_no`, `type`, `balance`, `pin`, `status`, `bdate`) VALUES
(1, 4, '1234556666', 'CA', 112.45, 12345, 'ACTIVE', '2015-01-03 00:53:05'),
(3, 6, '2133441212', 'SA', 400, 1234, 'INACTIVE', '2015-01-03 16:35:37'),
(4, 7, '1255050095', 'FDA', 87.55, 123456, 'ACTIVE', '2015-01-19 22:32:55');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_address`
--

CREATE TABLE IF NOT EXISTS `tbl_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(40) NOT NULL,
  `state` varchar(40) NOT NULL,
  `zipcode` int(10) NOT NULL,
  `country` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tbl_address`
--

INSERT INTO `tbl_address` (`id`, `user_id`, `address`, `city`, `state`, `zipcode`, `country`) VALUES
(1, 4, '290 shani peth', 'jalgaon', 'maha', 112233, 'USA'),
(2, 5, '23/1, Baker street', 'pune', 'MA', 2341, 'USA'),
(3, 6, 'scott homes, x-bay', 'huston', 'MA', 22341, 'USA'),
(4, 7, '290, shani peth', 'jalgaon', 'maharashtra', 212112, 'USA');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaction`
--

CREATE TABLE IF NOT EXISTS `tbl_transaction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tx_no` varchar(20) NOT NULL,
  `tx_type` varchar(10) NOT NULL,
  `amount` double NOT NULL,
  `date` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `to_accno` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `tdate` varchar(40) NOT NULL,
  `comments` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `tbl_transaction`
--

INSERT INTO `tbl_transaction` (`id`, `tx_no`, `tx_type`, `amount`, `date`, `description`, `to_accno`, `status`, `tdate`, `comments`) VALUES
(1, 'TX100000001', 'credit', 200, '2015-01-06 09:23:57', 'credited $200 by admin at date', '12345566', 'SUCCESS', '', ''),
(2, 'TX100000002', 'credit', 20, '2015-01-06 09:36:06', 'credit $20 by Admin on Jan-06-2015', '1234556666', 'SUCCESS', '', ''),
(3, 'TX100000003', 'debit', 15, '2015-01-06 09:36:37', 'debit $15 by Admin on Jan-06-2015', '12345566', 'SUCCESS', '', ''),
(4, 'TX100000004', 'credit', 120, '2015-01-06 09:38:01', 'credit $120 by Admin on Jan-06-2015', '22334412', 'SUCCESS', '', ''),
(5, 'TX100000005', 'credit', 50, '2015-01-06 09:42:45', 'credit $50 by Admin on Jan-06-2015', '12345566', 'SUCCESS', '', ''),
(6, 'TX100000006', 'credit', 15, '2015-01-07 22:22:44', 'credit $15 from Account 0 on Jan-07-2015', '0', 'SUCCESS', '', ''),
(7, 'TX100000007', 'credit', 15, '2015-01-07 22:22:44', 'credit $15 to Account 2133441212 on Jan-07-2015', '0', 'SUCCESS', '', ''),
(8, 'TX100000008', 'credit', 21, '2015-01-07 22:26:26', 'credit $21 from Account 12345566 on Jan-07-2015', '2133441212', 'SUCCESS', '', ''),
(9, 'TX100000009', 'debit', 21, '2015-01-07 22:26:26', 'debit $21 to Account 2133441212 on Jan-07-2015', '12345566', 'SUCCESS', '', ''),
(10, 'TX100000010', 'credit', 14, '2015-01-07 22:32:35', 'credit $14 from Account 12345566 on Jan-07-2015', '2133441212', 'SUCCESS', '', ''),
(11, 'TX100000011', 'debit', 14, '2015-01-07 22:32:35', 'credit $14 to Account 2133441212 on Jan-07-2015', '1234556666', 'SUCCESS', '', ''),
(12, 'TX100000012', 'credit', 10, '2015-01-08 22:35:38', 'Fund transfer of $10 from Account 1234556666 Reference# 0', '2133441212', 'SUCCESS', '', ''),
(13, 'TX100000012', 'debit', 10, '2015-01-08 22:35:40', 'Fund transfer of $10 to Account 2133441212 Reference# 0', '1234556666', 'SUCCESS', '', ''),
(14, 'TX100000013', 'credit', 200, '2015-01-09 22:20:26', 'Fund transfer of $200 to Account 2133441212 Reference# TX100000013', '2133441212', 'SUCCESS', '', ''),
(15, 'TX100000014', 'credit', 22, '2015-01-10 15:18:30', 'Fund transfer of $22 to Account 1234556666 Reference# TX100000014', '1234556666', 'SUCCESS', '', ''),
(16, 'TX100000015', 'debit', 2233, '2015-01-10 16:02:05', 'Fund transfer of $2233 to Account 1234556666 Reference# TX100000015', '1234556666', 'SUCCESS', '11-10-1981', 'hello'),
(17, 'TX100000016', 'debit', 2000, '2015-01-10 16:08:41', 'Fund transfer of $2000 to Account 1234556666 Reference# TX100000016', '1234556666', 'SUCCESS', '11-10-1981', 'hello test..'),
(18, 'TX100000017', 'credit', 25, '2015-01-19 22:43:54', 'Fund transfer of $25 from Account 1234556666 Reference# TX100000017', '1255050095', 'SUCCESS', '11-11-1981', 'college fees'),
(19, 'TX100000017', 'debit', 25, '2015-01-19 22:43:54', 'Fund transfer of $25 to Account 1255050095 Reference# TX100000017', '1234556666', 'SUCCESS', '11-11-1981', 'college fees'),
(20, 'TX100000018', 'credit', 20, '2015-01-22 21:45:57', 'Fund transfer of $20 from Account 1234556666 Reference# TX100000018', '1255050095', 'SUCCESS', '11-11-1981', 'float rx'),
(21, 'TX100000018', 'debit', 20, '2015-01-22 21:45:57', 'Fund transfer of $20 to Account 1255050095 Reference# TX100000018', '1234556666', 'SUCCESS', '11-11-1981', 'float rx'),
(22, 'TX100000019', 'credit', 20, '2015-01-22 21:47:19', 'Fund transfer of $20 from Account 1234556666 Reference# TX100000019', '1255050095', 'SUCCESS', '11-11-1981', 'hello'),
(23, 'TX100000019', 'debit', 20, '2015-01-22 21:47:19', 'Fund transfer of $20 to Account 1255050095 Reference# TX100000019', '1234556666', 'SUCCESS', '11-11-1981', 'hello'),
(24, 'TX100000020', 'credit', 22.1, '2015-01-22 22:01:49', 'Fund transfer of $22 from Account 1234556666 Reference# TX100000020', '1255050095', 'SUCCESS', '11-11-1981', 'sdsd'),
(25, 'TX100000020', 'debit', 22.1, '2015-01-22 22:01:49', 'Fund transfer of $22 to Account 1255050095 Reference# TX100000020', '1234556666', 'SUCCESS', '11-11-1981', 'sdsd');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE IF NOT EXISTS `tbl_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(40) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `is_active` varchar(10) NOT NULL,
  `utype` varchar(10) NOT NULL,
  `pics` varchar(200) NOT NULL,
  `bdate` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `fname`, `lname`, `pwd`, `email`, `phone`, `gender`, `is_active`, `utype`, `pics`, `bdate`) VALUES
(4, 'tousif', 'khan', '*1D72DAFB953E3606E84902DB8C521C98EC46266E', 'tousifkhan510@gmail.com', '(111) 111-1111', 'Male', 'TRUE', 'USER', 'ef4b35d6b8d1f77af51ac19bee353fe3.jpg', '2015-01-03 00:53:05'),
(6, 'Scott', 'Pettyjohn', '*1C1E6B5A51B9D84E47430BEB37AD123D1A22C000', 'scott@gmail.com', '(222) 222-1342', 'Male', 'FALSE', 'USER', '8725c768c4af943069ea10609890eaf4.jpg', '2015-01-03 16:35:37'),
(7, 'mayram', 'afifa', '*1D72DAFB953E3606E84902DB8C521C98EC46266E', 'maryam.afifa@gmail.com', '(222) 212-1212', 'Male', 'TRUE', 'USER', 'c8893dabeaf3d6a9d52aa28063e1c5c5.jpg', '2015-01-19 22:32:55');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
