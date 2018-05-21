SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT '',
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部门',  database());
INSERT INTO `dept` VALUES ('2', '人事部门',  database());
INSERT INTO `dept` VALUES ('3', '财务部门',  database());
INSERT INTO `dept` VALUES ('4', '运营部门',  database());
INSERT INTO `dept` VALUES ('5', 'test',  database());