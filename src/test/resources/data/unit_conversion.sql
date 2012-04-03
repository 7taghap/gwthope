
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
