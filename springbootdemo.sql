/*
 Navicat Premium Data Transfer

 Source Server         : zsk
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : springbootdemo

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 21/11/2018 17:01:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `resource_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `resource_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问URL地址',
  `resource_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源代码字符串',
  `parentid` int(11) NULL DEFAULT NULL COMMENT '父节点id',
  `parentids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点id串',
  `sortstring` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序号',
  `avaliable` int(11) NULL DEFAULT NULL COMMENT '是否可用：0：不可用，1：可用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int(11) NULL DEFAULT NULL COMMENT '是否删除：0：已删除，1：未删除',
  `last_edit_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_permission
-- ----------------------------
INSERT INTO `admin_permission` VALUES (1, '测试', '测试', 'url', '/user/findUserList', 'user:findUserList:*', NULL, NULL, NULL, 1, '2018-05-02 13:35:30', 1, '20180702182246');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色英文名',
  `avaliable` int(11) NULL DEFAULT NULL COMMENT '是否可用：0：不可用，1：可用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int(11) NULL DEFAULT NULL COMMENT '是否删除：0:已删除，1：未删除',
  `last_edit_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, '超级管理员', 'superAdmin', 1, '2017-10-30 16:15:55', 1, '2017-10-30 16:15:59');

-- ----------------------------
-- Table structure for admin_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_permission`;
CREATE TABLE `admin_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `avaliable` int(11) NULL DEFAULT NULL COMMENT '0:无效  1：有效',
  `last_edit_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_permission
-- ----------------------------
INSERT INTO `admin_role_permission` VALUES (1, 1, 1, 1, '20180702182355');

-- ----------------------------
-- Table structure for admin_security_resource
-- ----------------------------
DROP TABLE IF EXISTS `admin_security_resource`;
CREATE TABLE `admin_security_resource`  (
  `id` int(11) NOT NULL,
  `resource_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源链接',
  `permission_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_security_resource
-- ----------------------------
INSERT INTO `admin_security_resource` VALUES (1, '/user/findUserList', 'perms[user:findUserList]', 'test');

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `sex` enum('未知','女','男') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '用户性别',
  `age` double NULL DEFAULT NULL COMMENT '用户年龄',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户住址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int(11) NULL DEFAULT NULL COMMENT '0:已删除   1：未删除',
  `last_edit_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'zsk', 'zsk', 'edab3a626342217b4840b77fc4ce4a9d', '男', 10, '18838987007', '地球', '测试使用', 'zskzxspk', '2017-10-05 15:31:43', 1, '20180702101748');
INSERT INTO `admin_user` VALUES (9, '00001', '测试', '2ad4a6289207ec130007a8ba854b8a23', '男', 16, '17621836577', '地球', '无', '000011', '2018-05-23 17:50:51', 1, '20180702104301');

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `avaliable` int(11) NULL DEFAULT NULL COMMENT '0：无效  1有效',
  `last_edit_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES (1, 1, 1, 1, '20180702182133');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '001', '1', 'zsk');
INSERT INTO `user` VALUES (2, '002', '2', 'test');

-- ----------------------------
-- Triggers structure for table admin_permission
-- ----------------------------
DROP TRIGGER IF EXISTS `permission_lastEditDate_insert`;
delimiter ;;
CREATE TRIGGER `permission_lastEditDate_insert` BEFORE INSERT ON `admin_permission` FOR EACH ROW BEGIN
 	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
 	SET new.last_edit_date = @currentDate;
  END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_permission
-- ----------------------------
DROP TRIGGER IF EXISTS `permission_lastEditDate_update`;
delimiter ;;
CREATE TRIGGER `permission_lastEditDate_update` BEFORE UPDATE ON `admin_permission` FOR EACH ROW BEGIN
	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
	SET new.last_edit_date = @currentDate;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_role
-- ----------------------------
DROP TRIGGER IF EXISTS `role_lastEditDate_insert`;
delimiter ;;
CREATE TRIGGER `role_lastEditDate_insert` BEFORE INSERT ON `admin_role` FOR EACH ROW BEGIN
 	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
 	SET new.last_edit_date = @currentDate;
  END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_role
-- ----------------------------
DROP TRIGGER IF EXISTS `role_lastEditDate_update`;
delimiter ;;
CREATE TRIGGER `role_lastEditDate_update` BEFORE UPDATE ON `admin_role` FOR EACH ROW BEGIN
	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
	SET new.last_edit_date = @currentDate;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_role_permission
-- ----------------------------
DROP TRIGGER IF EXISTS `rolePermission_lastEditDate_insert`;
delimiter ;;
CREATE TRIGGER `rolePermission_lastEditDate_insert` BEFORE INSERT ON `admin_role_permission` FOR EACH ROW BEGIN
 	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
 	SET new.last_edit_date = @currentDate;
  END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_role_permission
-- ----------------------------
DROP TRIGGER IF EXISTS `rolePermission_lastEditDate_update`;
delimiter ;;
CREATE TRIGGER `rolePermission_lastEditDate_update` BEFORE UPDATE ON `admin_role_permission` FOR EACH ROW BEGIN
	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
	SET new.last_edit_date = @currentDate;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_user
-- ----------------------------
DROP TRIGGER IF EXISTS `user_lastEditDate_insert`;
delimiter ;;
CREATE TRIGGER `user_lastEditDate_insert` BEFORE INSERT ON `admin_user` FOR EACH ROW BEGIN
 	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
 	SET new.last_edit_date = @currentDate;
  END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_user
-- ----------------------------
DROP TRIGGER IF EXISTS `user_lastEditDate_update`;
delimiter ;;
CREATE TRIGGER `user_lastEditDate_update` BEFORE UPDATE ON `admin_user` FOR EACH ROW BEGIN
	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
	SET new.last_edit_date = @currentDate;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_user_role
-- ----------------------------
DROP TRIGGER IF EXISTS `userRole_lastEditDate_insert`;
delimiter ;;
CREATE TRIGGER `userRole_lastEditDate_insert` BEFORE INSERT ON `admin_user_role` FOR EACH ROW BEGIN
 	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
 	SET new.last_edit_date = @currentDate;
  END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin_user_role
-- ----------------------------
DROP TRIGGER IF EXISTS `userRole_lastEditDate_update`;
delimiter ;;
CREATE TRIGGER `userRole_lastEditDate_update` BEFORE UPDATE ON `admin_user_role` FOR EACH ROW BEGIN
	SELECT DATE_FORMAT(NOW(),'%Y%m%d%k%i%s') into @currentDate;
	SET new.last_edit_date = @currentDate;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
