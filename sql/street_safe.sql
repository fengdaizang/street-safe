/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : street_safe

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-02-14 16:46:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dshop
-- ----------------------------
DROP TABLE IF EXISTS `dshop`;
CREATE TABLE `dshop` (
  `dno` char(8) NOT NULL,
  `dname` varchar(15) NOT NULL,
  `dtype` varchar(15) DEFAULT NULL,
  `dtel` char(15) NOT NULL,
  `dsafe` enum('E','D','C','B','A') NOT NULL DEFAULT 'B',
  PRIMARY KEY (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dshop
-- ----------------------------
INSERT INTO `dshop` VALUES ('BH-1', '北环中学', '教育类', '0451-4659872', 'B');
INSERT INTO `dshop` VALUES ('GB-1', '乐乐食杂店', '服务类', '0451-3265987', 'B');
INSERT INTO `dshop` VALUES ('GB-2', '丽人SPA会馆', '休闲类', '0451-9875465', 'B');
INSERT INTO `dshop` VALUES ('GGL-1', '果戈里红肠店', '餐饮类', '0451-8604488', 'A');
INSERT INTO `dshop` VALUES ('GGL-2', '4399网咖', '娱乐类', '0451-9236987', 'C');
INSERT INTO `dshop` VALUES ('HJ-1', '电脑城', '制造类', '0451-8985468', 'D');
INSERT INTO `dshop` VALUES ('HQ-1', '红旗小学', '教育类', '0451-9875413', 'A');
INSERT INTO `dshop` VALUES ('HX-1', '和兴咖啡厅', '餐饮类', '0451-8282618', 'A');
INSERT INTO `dshop` VALUES ('HX-2', '顽皮烟花爆竹', '制造类', '0451-6111322', 'E');
INSERT INTO `dshop` VALUES ('HX-3', '98K KTV', '娱乐类', '0451-6332156', 'C');
INSERT INTO `dshop` VALUES ('HX-4', '浪淘沙洗浴中心', '休闲类', '0451-6998754', 'C');
INSERT INTO `dshop` VALUES ('JW-1', 'DontStop街舞', '休闲类', '0451-9875422', 'B');
INSERT INTO `dshop` VALUES ('JW-2', '中国农业银行', null, '0451-8332664', 'A');
INSERT INTO `dshop` VALUES ('JY-1', '靖宇裁缝店', '服务类', '0451-5456598', 'B');
INSERT INTO `dshop` VALUES ('JY-2', '情缘足疗洗浴', '休闲类', '0451-6598764', 'D');
INSERT INTO `dshop` VALUES ('JY-3', '精英律师事务所', '服务类', '0451-9865331', 'B');
INSERT INTO `dshop` VALUES ('JYang-1', '百货家饰城', '服务类', '0451-8289070', 'C');
INSERT INTO `dshop` VALUES ('JYang-2', '贝贝卫生用品', '服务类', '0451-5495654', 'C');
INSERT INTO `dshop` VALUES ('JYang-3', '桔子水晶酒店', '服务类', '0451-5994564', 'B');
INSERT INTO `dshop` VALUES ('JYang-4', '大力石牛冷饮', '餐饮类', '0451-9876549', 'A');
INSERT INTO `dshop` VALUES ('QN-1', '奥斯卡club', '娱乐类', '0451-6265978', 'C');
INSERT INTO `dshop` VALUES ('QN-2', 'Casmo Club', '娱乐类', '0451-3465987', 'C');
INSERT INTO `dshop` VALUES ('TD-1', '田地麻将馆', '娱乐类', '0451-2366997', 'C');
INSERT INTO `dshop` VALUES ('TP-1', '美味小厨', '餐饮类', '0451-4954565', 'B');
INSERT INTO `dshop` VALUES ('XF-1', '凯德广场', '综合商场', '0451-8888666', 'A');
INSERT INTO `dshop` VALUES ('XF-2', '辣庄火锅', '餐饮类', '0451-8686000', 'B');
INSERT INTO `dshop` VALUES ('XF-3', '学府五金店', '五金类', '0451-6234659', 'C');
INSERT INTO `dshop` VALUES ('XF-4', '三和打印社', '服务业', '0451-8289070', 'B');
INSERT INTO `dshop` VALUES ('XF-5', '第一医院', null, '0451-8883883', 'A');
INSERT INTO `dshop` VALUES ('ZS-1', '中国农业银行', null, '0451-8332662', 'A');
INSERT INTO `dshop` VALUES ('ZY-1', '金安国际', '综合商场', '0451-9696888', 'A');
INSERT INTO `dshop` VALUES ('ZY-2', '远大购物中心', '综合商场 ', '0451-8686868', 'A');
INSERT INTO `dshop` VALUES ('ZY-3', '金三顺韩式烤肉', '餐饮类', '0451-9875211', 'B');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `sno` char(8) NOT NULL,
  `dno` char(8) NOT NULL,
  `pname` varchar(15) NOT NULL,
  `psex` enum('女','男') NOT NULL,
  `ptel` varchar(11) NOT NULL,
  `ptime` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`sno`,`dno`),
  UNIQUE KEY `ptel` (`ptel`),
  KEY `dno` (`dno`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `street` (`sno`),
  CONSTRAINT `person_ibfk_2` FOREIGN KEY (`dno`) REFERENCES `dshop` (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('A-GGL', 'GGL-1', '孙李', '男', '15845126532', '2');
INSERT INTO `person` VALUES ('A-GGL', 'GGL-2', '韩仙', '女', '15545551234', '3');
INSERT INTO `person` VALUES ('A-HJ', 'HJ-1', '张杰', '男', '15545501564', '3');
INSERT INTO `person` VALUES ('A-HX', 'HX-1', '李娜', '女', '13345651121', '3');
INSERT INTO `person` VALUES ('A-HX', 'HX-2', '云天', '男', '15522331546', '2');
INSERT INTO `person` VALUES ('A-HX', 'HX-3', '韩元丁', '女', '13214665612', '3');
INSERT INTO `person` VALUES ('A-HX', 'HX-4', '赵云', '女', '13214662378', '4');
INSERT INTO `person` VALUES ('A-XF', 'XF-1', '田心雨', '女', '13224663132', '3');
INSERT INTO `person` VALUES ('A-XF', 'XF-2', '李林', '女', '13224663354', '3');
INSERT INTO `person` VALUES ('A-XF', 'XF-3', '刘雨欣', '女', '13224663111', '2');
INSERT INTO `person` VALUES ('A-XF', 'XF-4', '王琴', '女', '13224663669', '3');
INSERT INTO `person` VALUES ('A-XF', 'XF-5', '张戈', '男', '13224663554', '2');
INSERT INTO `person` VALUES ('A-ZS', 'ZS-1', '张飞', '女', '13555366645', '3');
INSERT INTO `person` VALUES ('B-JW', 'JW-1', '孙木', '男', '15045504561', '3');
INSERT INTO `person` VALUES ('B-JW', 'JW-2', '方芳', '女', '15845514552', '2');
INSERT INTO `person` VALUES ('B-TD', 'TD-1', '陈璐', '女', '13555366884', '2');
INSERT INTO `person` VALUES ('B-ZY', 'ZY-1', '丁当', '女', '13763779877', '4');
INSERT INTO `person` VALUES ('B-ZY', 'ZY-2', '韩秀丽', '男', '13763774589', '3');
INSERT INTO `person` VALUES ('B-ZY', 'ZY-3', '莫小贝', '男', '13763776655', '3');
INSERT INTO `person` VALUES ('C-BH', 'BH-1', '赵山川', '男', '13349964885', '2');
INSERT INTO `person` VALUES ('C-JY', 'JY-1', '张汤', '男', '13214669877', '5');
INSERT INTO `person` VALUES ('C-JY', 'JY-2', '罗月红', '女', '13555366456', '2');
INSERT INTO `person` VALUES ('C-JY', 'JY-3', '王飞', '女', '13555399877', '2');
INSERT INTO `person` VALUES ('C-JYANG', 'JYANG-1', '宋茜', '女', '15545651155', '3');
INSERT INTO `person` VALUES ('C-JYANG', 'JYANG-2', '王紫薇', '女', '13614544400', '4');
INSERT INTO `person` VALUES ('C-JYANG', 'JYANG-3', '罗彬', '男', '15845101111', '2');
INSERT INTO `person` VALUES ('C-JYANG', 'JYANG-4', '边白', '男', '15914654499', '3');
INSERT INTO `person` VALUES ('C-TP', 'TP-1', '李玉', '女', '13346549819', '2');
INSERT INTO `person` VALUES ('D-GB', 'GB-1', '赵竹林', '男', '13345671556', '3');
INSERT INTO `person` VALUES ('D-GB', 'GB-2', '赵玉', '男', '13215561884', '3');
INSERT INTO `person` VALUES ('D-HQ', 'HQ-1', '孙芳', '女', '13345501566', '2');
INSERT INTO `person` VALUES ('D-QN', 'QN-1', '孙佳', '女', '13634544455', '2');
INSERT INTO `person` VALUES ('D-QN', 'QN-2', '宋尚忠', '男', '13644345656', '1');

-- ----------------------------
-- Table structure for shopsafe
-- ----------------------------
DROP TABLE IF EXISTS `shopsafe`;
CREATE TABLE `shopsafe` (
  `sno` char(8) NOT NULL,
  `dno` char(8) NOT NULL,
  `xflevel` char(8) NOT NULL,
  `fwlevel` char(8) NOT NULL,
  `qtlevel` char(8) NOT NULL,
  PRIMARY KEY (`sno`,`dno`),
  KEY `dno` (`dno`),
  CONSTRAINT `shopsafe_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `street` (`sno`),
  CONSTRAINT `shopsafe_ibfk_2` FOREIGN KEY (`dno`) REFERENCES `dshop` (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopsafe
-- ----------------------------
INSERT INTO `shopsafe` VALUES ('A-GGL', 'GGL-1', 'A', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('A-GGL', 'GGL-2', 'C', 'C', 'B');
INSERT INTO `shopsafe` VALUES ('A-HJ', 'HJ-1', 'C', 'C', 'D');
INSERT INTO `shopsafe` VALUES ('A-HX', 'HX-1', 'A', 'A', 'A');
INSERT INTO `shopsafe` VALUES ('A-HX', 'HX-2', 'C', 'D', 'E');
INSERT INTO `shopsafe` VALUES ('A-HX', 'HX-3', 'C', 'C', 'D');
INSERT INTO `shopsafe` VALUES ('A-HX', 'HX-4', 'C', 'B', 'C');
INSERT INTO `shopsafe` VALUES ('A-XF', 'XF-1', 'A', 'A', 'A');
INSERT INTO `shopsafe` VALUES ('A-XF', 'XF-2', 'B', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('A-XF', 'XF-3', 'C', 'C', 'C');
INSERT INTO `shopsafe` VALUES ('A-XF', 'XF-4', 'C', 'B', 'B');
INSERT INTO `shopsafe` VALUES ('A-XF', 'XF-5', 'A', 'B', 'A');
INSERT INTO `shopsafe` VALUES ('A-ZS', 'ZS-1', 'A', 'A', 'A');
INSERT INTO `shopsafe` VALUES ('B-JW', 'JW-1', 'B', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('B-JW', 'JW-2', 'A', 'A', 'A');
INSERT INTO `shopsafe` VALUES ('B-TD', 'TD-1', 'C', 'B', 'C');
INSERT INTO `shopsafe` VALUES ('B-ZY', 'ZY-1', 'A', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('B-ZY', 'ZY-2', 'A', 'B', 'A');
INSERT INTO `shopsafe` VALUES ('B-ZY', 'ZY-3', 'B', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('C-BH', 'BH-1', 'A', 'B', 'B');
INSERT INTO `shopsafe` VALUES ('C-JY', 'JY-1', 'B', 'B', 'B');
INSERT INTO `shopsafe` VALUES ('C-JY', 'JY-2', 'C', 'D', 'D');
INSERT INTO `shopsafe` VALUES ('C-JY', 'JY-3', 'B', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('C-JYANG', 'JYANG-1', 'B', 'C', 'C');
INSERT INTO `shopsafe` VALUES ('C-JYANG', 'JYANG-2', 'B', 'C', 'C');
INSERT INTO `shopsafe` VALUES ('C-JYANG', 'JYANG-3', 'B', 'B', 'B');
INSERT INTO `shopsafe` VALUES ('C-JYANG', 'JYANG-4', 'A', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('C-TP', 'TP-1', 'B', 'B', 'B');
INSERT INTO `shopsafe` VALUES ('D-GB', 'GB-1', 'C', 'B', 'B');
INSERT INTO `shopsafe` VALUES ('D-GB', 'GB-2', 'B', 'A', 'B');
INSERT INTO `shopsafe` VALUES ('D-HQ', 'HQ-1', 'A', 'B', 'A');
INSERT INTO `shopsafe` VALUES ('D-QN', 'QN-1', 'A', 'B', 'C');
INSERT INTO `shopsafe` VALUES ('D-QN', 'QN-2', 'B', 'A', 'C');

-- ----------------------------
-- Table structure for street
-- ----------------------------
DROP TABLE IF EXISTS `street`;
CREATE TABLE `street` (
  `sno` char(8) NOT NULL,
  `sname` varchar(15) NOT NULL,
  `mname` char(15) NOT NULL,
  `mtel` varchar(11) NOT NULL,
  PRIMARY KEY (`sno`),
  UNIQUE KEY `sname` (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of street
-- ----------------------------
INSERT INTO `street` VALUES ('123', '123', '2333', '232');
INSERT INTO `street` VALUES ('A-DD', '东大直街', '张三', '8333222');
INSERT INTO `street` VALUES ('A-GGL', '果戈里大街', '南风', '8222222');
INSERT INTO `street` VALUES ('A-HJ', '红军街', '南风', '8222222');
INSERT INTO `street` VALUES ('A-HX', '和兴路', '张思', '8888333');
INSERT INTO `street` VALUES ('A-XD', '西大直街', '张三', '8333222');
INSERT INTO `street` VALUES ('A-XF', '学府路', '张思', '8888333');
INSERT INTO `street` VALUES ('A-ZS', '中山路', '张思', '8888333');
INSERT INTO `street` VALUES ('B-FS', '抚顺街', '林凡', '8445566');
INSERT INTO `street` VALUES ('B-JW', '经纬街', '李四', '8443322');
INSERT INTO `street` VALUES ('B-TD', '田地街', '王一', '8555555');
INSERT INTO `street` VALUES ('B-YY', '友谊路', '林凡', '8445566');
INSERT INTO `street` VALUES ('B-ZY', '中央大街', '李四', '8443322');
INSERT INTO `street` VALUES ('C-BH', '北环路', '刘曦', '8556677');
INSERT INTO `street` VALUES ('C-JY', '靖宇街', '张艾霞', '8554433');
INSERT INTO `street` VALUES ('C-JYANG', '景阳街', '张艾霞', '8554433');
INSERT INTO `street` VALUES ('C-TP', '太平桥', '刘曦', '8556677');
INSERT INTO `street` VALUES ('D-GB', '公滨路', '叶大兵', '8665544');
INSERT INTO `street` VALUES ('D-HP', '和平路', '叶大兵', '8665544');
INSERT INTO `street` VALUES ('D-HQ', '红旗大街', '钟娅丹', '8667788');
INSERT INTO `street` VALUES ('D-QN', '桥南街', '乔木', '8888888');
INSERT INTO `street` VALUES ('D-ZJ', '珠江路', '钟娅丹', '8667788');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` varchar(32) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('97cc46c0498d4b6da76c8aeb3edbca7a', 'admin', '123');
INSERT INTO `userinfo` VALUES ('bc848cc6080b4ac9a6c1966f1e0e743b', 'www123', 'www123456');
