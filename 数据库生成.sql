/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : ktv_database

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-07-04 16:57:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_singer`
-- ----------------------------
DROP TABLE IF EXISTS `t_singer`;
CREATE TABLE `t_singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `singer_name` varchar(255) DEFAULT NULL,
  `pingyin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `singer_name` (`singer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_singer
-- ----------------------------
INSERT INTO `t_singer` VALUES ('3', '那英', 'NY');
INSERT INTO `t_singer` VALUES ('4', '陈学冬', 'CXD');
INSERT INTO `t_singer` VALUES ('8', '周杰伦', 'ZJL');
INSERT INTO `t_singer` VALUES ('9', '林俊杰', 'LJJ');
INSERT INTO `t_singer` VALUES ('10', 'linkin park', 'Linkin Park');
INSERT INTO `t_singer` VALUES ('11', '刘德华', 'LDH');
INSERT INTO `t_singer` VALUES ('15', '戴佩妮', 'DPN');

-- ----------------------------
-- Table structure for `t_song`
-- ----------------------------
DROP TABLE IF EXISTS `t_song`;
CREATE TABLE `t_song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `song_name` varchar(255) DEFAULT NULL,
  `pingyin` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `singerid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `song_name` (`song_name`),
  KEY `FKCB62D600CD33F17D` (`singerid`),
  CONSTRAINT `FKCB62D600CD33F17D` FOREIGN KEY (`singerid`) REFERENCES `t_singer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_song
-- ----------------------------
INSERT INTO `t_song` VALUES ('5', '白天不懂夜的黑', 'BTBDYDH', '中文', '3');
INSERT INTO `t_song` VALUES ('6', '不再见', 'BZJ', '中文', '4');
INSERT INTO `t_song` VALUES ('9', '最长的电影', 'ZCDDY', '中文', '8');
INSERT INTO `t_song` VALUES ('10', '晴天', 'QT', '中文', '8');
INSERT INTO `t_song` VALUES ('11', '等你下课', 'DNXK', '中文', '8');
INSERT INTO `t_song` VALUES ('12', '醉赤壁', 'ZCB', '中文', '9');
INSERT INTO `t_song` VALUES ('13', '可惜没如果', 'RGMRG', '中文', '8');
INSERT INTO `t_song` VALUES ('14', 'numb', 'numb', '英文', '10');
INSERT INTO `t_song` VALUES ('16', '忘情水', 'WQS', '中文', '11');
INSERT INTO `t_song` VALUES ('19', '你要的爱', 'NYDA', '中文', '15');
