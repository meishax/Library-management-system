/*
 Navicat Premium Data Transfer

 Source Server         : admin
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : experiment_3

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 13/04/2020 01:32:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `ISBN` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键，ISBN',
  `bookname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
  `press` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '出版社',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `borrowablenumber` int(0) NOT NULL COMMENT '可借阅数',
  PRIMARY KEY (`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('111', '111', '111', '111', 20);
INSERT INTO `book` VALUES ('22', '22', '22', '22', 22);
INSERT INTO `book` VALUES ('223', '测试', '22', '22', 22);
INSERT INTO `book` VALUES ('2234', '郭子杨的故事', '22', '22', 22);
INSERT INTO `book` VALUES ('978115364210', '响应式Web设计全流程解析', '人民邮电出版社', 'Hay', 0);
INSERT INTO `book` VALUES ('9787111135104', '计算机程序的构造和解释', '机械工业出版社', 'Harold Abelson', 0);

-- ----------------------------
-- Table structure for documentborrowed
-- ----------------------------
DROP TABLE IF EXISTS `documentborrowed`;
CREATE TABLE `documentborrowed`  (
  `borrowedbookid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键，借出书籍的编号，每一本书有一个唯一编号',
  `borrowedbookname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '借出书籍的名字',
  `borrowstudentsno` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '借阅学生的学号',
  `borrowstudentname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '借阅学生的姓名',
  PRIMARY KEY (`borrowedbookid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of documentborrowed
-- ----------------------------
INSERT INTO `documentborrowed` VALUES ('111_user01', '111', 'user01', '');
INSERT INTO `documentborrowed` VALUES ('9787111135104_08173042', '计算机程序的构造和解释', '08173042', '郭子杨');
INSERT INTO `documentborrowed` VALUES ('9787111135104_08173042X', '计算机程序的构造和解释', '08173042X', '');
INSERT INTO `documentborrowed` VALUES ('9787111135104_1', '计算机程序的构造和解释', '0817xxxx', '阿强');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `username` varchar(30) CHARACTER SET utf32 COLLATE utf32_general_ci NOT NULL COMMENT '主键，唯一标识，用户名',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `identityx` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身份，普通用户还是管理员',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('08173042', '123456', 'admin');
INSERT INTO `login` VALUES ('08173042X', '123456', 'user');
INSERT INTO `login` VALUES ('1785114', '123456', 'admin');
INSERT INTO `login` VALUES ('admin01', '123456', 'admin');
INSERT INTO `login` VALUES ('gzy', '123456', 'admin');
INSERT INTO `login` VALUES ('user01', '123456', 'user');
INSERT INTO `login` VALUES ('xxxxxx', '123456', 'user');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键，唯一标识,学生编号',
  `sname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `sclass` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生班级',
  `smajor` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生专业',
  `borrownumber` int(0) NOT NULL COMMENT '借阅数',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('08173042', '郭子杨', '计科六班', '计算机科学与技术', 1);
INSERT INTO `student` VALUES ('0817bbbb', '李四', '信安一班', '信息安全', 0);
INSERT INTO `student` VALUES ('0817cccc', '王五', '信科一班', '电子信息科学与技术', 0);
INSERT INTO `student` VALUES ('0817eeee', '钱', '计科五班', '计算机科学与技术', 0);
INSERT INTO `student` VALUES ('0817xxxx', '阿强', '计科17-06', '计算机科学与技术', 10);
INSERT INTO `student` VALUES ('xxxx', 'xxxx', '计科二班', '信息安全', 0);

SET FOREIGN_KEY_CHECKS = 1;
