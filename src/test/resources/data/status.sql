/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50161
Source Host           : localhost:3306
Source Database       : redhorse

Target Server Type    : MYSQL
Target Server Version : 50161
File Encoding         : 65001

Date: 2012-04-02 09:46:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `status`
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', 'Default', 'Default', '2012-04-02 09:45:35', 'Default', '2012-04-02 09:45:41', 'Active');
INSERT INTO `status` VALUES ('2', 'Default', 'Default', '2012-04-02 09:45:35', 'Default', '2012-04-02 09:45:35', 'InActive');
INSERT INTO `status` VALUES ('3', 'Default', 'Default', '2012-04-02 09:45:35', 'Default', '2012-04-02 09:45:35', 'Deleted');
