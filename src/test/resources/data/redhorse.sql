/*
Navicat MySQL Data Transfer

Source Server         : redhorse
Source Server Version : 50516
Source Host           : BFX3SM1:3306
Source Database       : redhorse

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2012-03-30 11:09:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dbmaintain_scripts`
-- ----------------------------
DROP TABLE IF EXISTS `dbmaintain_scripts`;
CREATE TABLE `dbmaintain_scripts` (
  `file_name` varchar(150) DEFAULT NULL,
  `version` varchar(25) DEFAULT NULL,
  `file_last_modified_at` bigint(20) DEFAULT NULL,
  `checksum` varchar(50) DEFAULT NULL,
  `executed_at` varchar(20) DEFAULT NULL,
  `succeeded` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dbmaintain_scripts
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` varchar(255) NOT NULL,
  `category` smallint(6) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `imgfile` varchar(255) DEFAULT NULL,
  `product_desc` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` smallint(6) DEFAULT NULL,
  `shelf` varchar(255) DEFAULT NULL,
  `total_qty_on_hand` float DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `unit_type` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKED8DCCEF3D841368` (`unit_type`),
  CONSTRAINT `FKED8DCCEF3D841368` FOREIGN KEY (`unit_type`) REFERENCES `unit_conversion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `product_dtl`
-- ----------------------------
DROP TABLE IF EXISTS `product_dtl`;
CREATE TABLE `product_dtl` (
  `product_dtl_id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `price_type` smallint(6) DEFAULT NULL,
  `qty_on_hand` float DEFAULT NULL,
  `selling_qty` float DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  `sug_price` decimal(19,2) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `package_type` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`product_dtl_id`),
  KEY `FKA71C728CE9CA21E6` (`package_type`),
  KEY `FKA71C728C13E734E1` (`product_id`),
  CONSTRAINT `FKA71C728C13E734E1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKA71C728CE9CA21E6` FOREIGN KEY (`package_type`) REFERENCES `unit_conversion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product_dtl
-- ----------------------------

-- ----------------------------
-- Table structure for `unit_conversion`
-- ----------------------------
DROP TABLE IF EXISTS `unit_conversion`;
CREATE TABLE `unit_conversion` (
  `id` smallint(6) NOT NULL,
  `abbr` varchar(255) DEFAULT NULL,
  `factor` float NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  `unit_type` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of unit_conversion
-- ----------------------------
INSERT INTO `unit_conversion` VALUES ('1', 'g', '0.0001', 'gram', '1', '1');
INSERT INTO `unit_conversion` VALUES ('2', 'kg', '1', 'Kilogram', '1', '1');
INSERT INTO `unit_conversion` VALUES ('3', 'ml', '0.0001', 'milliliter', '1', '2');
INSERT INTO `unit_conversion` VALUES ('4', 'l', '1', 'Liter', '1', '2');
INSERT INTO `unit_conversion` VALUES ('5', 'pc', '1', 'piece', '1', '3');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `effective_end_date` datetime DEFAULT NULL,
  `effective_start_date` datetime DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1', '2012-03-06 23:35:05', null, '2012-03-06 23:35:21', 'Rey Bryan Caburnay', 'fc5e038d38a57032085441e7fe7010b0', '1', null, 'admin');
