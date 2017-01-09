/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60004
Source Host           : localhost:3306
Source Database       : aitest

Target Server Type    : MYSQL
Target Server Version : 60004
File Encoding         : 65001

Date: 2016-12-26 19:45:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `channel_info`
-- ----------------------------
DROP TABLE IF EXISTS `channel_info`;
CREATE TABLE `channel_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_code` varchar(255) DEFAULT NULL,
  `channel_name` varchar(255) DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_info
-- ----------------------------
INSERT INTO `channel_info` VALUES ('1', 'BF01', '宝付代扣', 'null');
INSERT INTO `channel_info` VALUES ('2', 'JYT', '金运通代扣', 'null');
INSERT INTO `channel_info` VALUES ('3', 'SX01', '数想代扣', null);

-- ----------------------------
-- Table structure for `conn_datasource`
-- ----------------------------
DROP TABLE IF EXISTS `conn_datasource`;
CREATE TABLE `conn_datasource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `ip_address` varchar(100) DEFAULT NULL,
  `port` int(8) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `db_name` varchar(100) DEFAULT NULL,
  `statu` int(2) DEFAULT NULL,
  `memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of conn_datasource
-- ----------------------------
INSERT INTO `conn_datasource` VALUES ('1', '测试数据库', 'rdsp5ae3ypidj48wkt2o.mysql.rds.aliyuncs.com', '3306', 'pay_channel_wr', 'BMzuv8DkwI', 'pay_channel', '1', '渠道系统数据库');
INSERT INTO `conn_datasource` VALUES ('2', '本地测试数据库', '127.0.0.1', '3306', 'root', 'root', '9fbank_channel_mgt', '1', '本地测试渠道数据库');

-- ----------------------------
-- Table structure for `conn_ftp`
-- ----------------------------
DROP TABLE IF EXISTS `conn_ftp`;
CREATE TABLE `conn_ftp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `ip_address` varchar(100) DEFAULT NULL,
  `port` int(8) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `root_path` varchar(100) DEFAULT NULL,
  `statu` int(2) DEFAULT NULL,
  `memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of conn_ftp
-- ----------------------------
INSERT INTO `conn_ftp` VALUES ('1', '测试环境FTP', '101.200.130.76', '22', 'root', 'JOCxzOe6He', '/data/ftp02/tandong/', '1', '测试辅助工具生成第三方对账文件');

-- ----------------------------
-- Table structure for `sys_dict_item`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(20) DEFAULT NULL,
  `type_code` varchar(20) DEFAULT NULL,
  `item_name` varchar(20) DEFAULT NULL,
  `sort_index` int(4) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('1', '00', 'RECON_ERROR_TYPE', '状态不一致', '1', null, null);
INSERT INTO `sys_dict_item` VALUES ('2', '01', 'RECON_ERROR_TYPE', '金额不一致', '2', null, null);
INSERT INTO `sys_dict_item` VALUES ('3', '02', 'RECON_ERROR_TYPE', '笔数不一致', '3', null, null);

-- ----------------------------
-- Table structure for `sys_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(20) DEFAULT NULL,
  `type_name` varchar(20) DEFAULT NULL,
  `type_kind` int(1) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', 'RECON_ERROR_TYPE', '差错类型', '1', '');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(200) DEFAULT NULL,
  `menu_state` varchar(1) DEFAULT NULL,
  `menu_index` varchar(2) DEFAULT NULL,
  `menu_leaf` varchar(1) DEFAULT NULL,
  `menu_icon` varchar(200) DEFAULT NULL,
  `parent` bigint(20) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', null, '1', '1', '0', null, '0', null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统用户', 'page/sysmgr/sysUser.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('3', '角色岗位', 'page/sysmgr/sysRole.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('4', '功能菜单', 'page/sysmgr/sysMenu.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('5', '数据字典', 'page/sysmgr/dict.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('11', '组织机构', '', '1', '2', '0', '', '0', null, null);
INSERT INTO `sys_menu` VALUES ('12', '机构管理', 'page/orgmgr/org.html', '1', '1', '1', '', '11', null, null);
INSERT INTO `sys_menu` VALUES ('13', '人员管理', 'page/orgmgr/employee.html', '1', '2', '1', '', '11', null, null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有权限', null, null);
INSERT INTO `sys_role` VALUES ('2', '业务管理员', '拥有除系统管理之外的所有权限', null, null);

-- ----------------------------
-- Table structure for `sys_role_menu_rel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_rel`;
CREATE TABLE `sys_role_menu_rel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu_rel
-- ----------------------------
INSERT INTO `sys_role_menu_rel` VALUES ('18', '2', '2');
INSERT INTO `sys_role_menu_rel` VALUES ('25', '1', '0');
INSERT INTO `sys_role_menu_rel` VALUES ('26', '1', '1');
INSERT INTO `sys_role_menu_rel` VALUES ('27', '1', '2');
INSERT INTO `sys_role_menu_rel` VALUES ('28', '1', '3');
INSERT INTO `sys_role_menu_rel` VALUES ('29', '1', '4');
INSERT INTO `sys_role_menu_rel` VALUES ('30', '1', '5');
INSERT INTO `sys_role_menu_rel` VALUES ('31', '1', '6');
INSERT INTO `sys_role_menu_rel` VALUES ('34', '1', '11');
INSERT INTO `sys_role_menu_rel` VALUES ('35', '1', '12');
INSERT INTO `sys_role_menu_rel` VALUES ('36', '1', '13');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) DEFAULT NULL,
  `login_pwd` varchar(100) DEFAULT NULL,
  `true_name` varchar(100) DEFAULT NULL,
  `idno` varchar(30) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `user_mail` varchar(255) DEFAULT NULL,
  `owner_org` bigint(20) DEFAULT NULL,
  `user_state` varchar(1) DEFAULT NULL,
  `last_login_time` varchar(20) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '111111', '张三', '430703198511209830', '18511290886', '北京市朝阳区', 'zhangsan@yuchengtech.com', null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('4', 'tandong', null, '谈冬aaa', '430703198511209830', '18511290886', '北京市朝阳区', 'tandong1@yuchengtech.com', null, '1', null, null, null);

-- ----------------------------
-- Table structure for `sys_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role_rel
-- ----------------------------
INSERT INTO `sys_user_role_rel` VALUES ('30', '1', '1');
INSERT INTO `sys_user_role_rel` VALUES ('31', '1', '2');
INSERT INTO `sys_user_role_rel` VALUES ('42', '4', '1');
INSERT INTO `sys_user_role_rel` VALUES ('43', '4', '2');

-- ----------------------------
-- Table structure for `trade_type_info`
-- ----------------------------
DROP TABLE IF EXISTS `trade_type_info`;
CREATE TABLE `trade_type_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TRADE_TYPE` varchar(20) DEFAULT NULL,
  `TRADE_TYPE_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_type_info
-- ----------------------------
INSERT INTO `trade_type_info` VALUES ('1', '10001', '代扣');
INSERT INTO `trade_type_info` VALUES ('2', '10002', '快捷');
