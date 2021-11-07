/*
 Navicat Premium Data Transfer

 Source Server         : sqb
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : expressdelivery

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 07/11/2021 22:08:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for deliver
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `deliverName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf16le COLLATE = utf16le_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliver
-- ----------------------------
INSERT INTO `deliver` VALUES (1, '派送员', '110', '白云');
INSERT INTO `deliver` VALUES (2, '派送员2', '111', '广州');
INSERT INTO `deliver` VALUES (3, '派送员3', '112', '北京');
INSERT INTO `deliver` VALUES (9, '快递员8', '10213', '天津');

-- ----------------------------
-- Table structure for expressarea
-- ----------------------------
DROP TABLE IF EXISTS `expressarea`;
CREATE TABLE `expressarea`  (
  `areaName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manageName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `areaPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expressarea
-- ----------------------------
INSERT INTO `expressarea` VALUES ('广州站', '管理员3', '123456', '广州', '白云');
INSERT INTO `expressarea` VALUES ('北京站', '管理员2', '123456', '北京', '朝阳');
INSERT INTO `expressarea` VALUES ('广州站', '管理员4', '123456', '广州', '增城');
INSERT INTO `expressarea` VALUES ('广州站', '管理员5', '123456', '广州', '海珠');
INSERT INTO `expressarea` VALUES ('广州站', '管理员6', '123456', '广州', '越秀');
INSERT INTO `expressarea` VALUES ('广州站', '管理员7', '123456', '广州', '天河');
INSERT INTO `expressarea` VALUES ('广州站', '管理员1', '123456', '广州', '白云');
INSERT INTO `expressarea` VALUES ('北京站', '管理员8', '123456', '北京', '天安门');
INSERT INTO `expressarea` VALUES ('北京站', '管理员10', '123456', '北京', '故宫');
INSERT INTO `expressarea` VALUES ('上海', '上海管理', '123456', '上海', '浦东');
INSERT INTO `expressarea` VALUES ('tianjin', '张三管理员', '147258', '广州', '白云');
INSERT INTO `expressarea` VALUES ('上海', 'ga', '12313456', '123546', '天津');

-- ----------------------------
-- Table structure for kuaidi
-- ----------------------------
DROP TABLE IF EXISTS `kuaidi`;
CREATE TABLE `kuaidi`  (
  `kuaidiNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人电话',
  `sendAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货地址',
  `receiveName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `receivePhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人电话',
  `receiveAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `kuaidiType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递类型',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kuaidi
-- ----------------------------
INSERT INTO `kuaidi` VALUES ('10002', '张三改gia', '11001', '广州', 'giag', '11003', '汕头', 'dailyUse', '2021-06-30 17:47:42');
INSERT INTO `kuaidi` VALUES ('25055', '王五', '11003', '汕头', '张三', '11001', '广州', 'food', '2021-06-30 14:08:39');
INSERT INTO `kuaidi` VALUES ('59920', '王五', '11003', '汕头', '李四', '11002', '深圳', 'dailyUse', '2021-06-30 15:12:47');
INSERT INTO `kuaidi` VALUES ('80265', '王五', '123456', '北京', '赵六', '8464894', '天津', 'food', '2021-07-01 22:30:36');
INSERT INTO `kuaidi` VALUES ('96799', '李四', '123456', '河南', '王五', '123456', '海南', 'food', '2021-07-02 13:32:49');
INSERT INTO `kuaidi` VALUES ('10001', '张三', '11001', '广州', '李四', '11002', '汕头', 'food', '2021-07-02 13:35:53');
INSERT INTO `kuaidi` VALUES ('67395', 'test123', '1234561321', '广州', 'test12', '1234561', '北京', 'food', '2021-07-02 17:14:29');

-- ----------------------------
-- Table structure for kuaidichange
-- ----------------------------
DROP TABLE IF EXISTS `kuaidichange`;
CREATE TABLE `kuaidichange`  (
  `kuaidiNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `currentArea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nextArea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kuaidichange
-- ----------------------------
INSERT INTO `kuaidichange` VALUES ('10001', '广州', '增城');
INSERT INTO `kuaidichange` VALUES ('10001', '增城', '番禺');
INSERT INTO `kuaidichange` VALUES ('10001', '番禺', '白云');
INSERT INTO `kuaidichange` VALUES ('10001', '白云', '越秀');
INSERT INTO `kuaidichange` VALUES ('10001', '越秀', '东莞');
INSERT INTO `kuaidichange` VALUES ('10002', '广州', '白云');
INSERT INTO `kuaidichange` VALUES ('10002', '白云', '增城');
INSERT INTO `kuaidichange` VALUES ('10003', '增城', '东莞');
INSERT INTO `kuaidichange` VALUES ('10003', '东莞', '潮州');
INSERT INTO `kuaidichange` VALUES ('10001', '东莞', '潮州');
INSERT INTO `kuaidichange` VALUES ('10002', '上海', '北京');
INSERT INTO `kuaidichange` VALUES ('10002', '北京', '天津');
INSERT INTO `kuaidichange` VALUES ('10002', '天津', '河南');
INSERT INTO `kuaidichange` VALUES ('10001', '潮州', '汕头');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('张三', '1001', '123456', '11001', 'true');
INSERT INTO `user` VALUES ('李四', '1002', '123456', '11002', 'false');
INSERT INTO `user` VALUES ('王五', '1003', '123456', '11003', 'true');
INSERT INTO `user` VALUES ('赵六', '1004', '123456', '11004', 'true');
INSERT INTO `user` VALUES ('张三1', '1005', '123456', '11005', 'true');
INSERT INTO `user` VALUES ('张三2', '1006', '123456', '11006', 'true');
INSERT INTO `user` VALUES ('张三3', '1007', '123456', '11007', 'ture');
INSERT INTO `user` VALUES ('张三4', '1008', '123456', '11008', 'true');
INSERT INTO `user` VALUES ('张三5', '1009', '123456', '11009', 'false');
INSERT INTO `user` VALUES ('李四', '2001', '123456', '12345', 'false');

SET FOREIGN_KEY_CHECKS = 1;
