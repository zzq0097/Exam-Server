/*
 Navicat Premium Data Transfer

 Source Server         : TX_Server
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 122.51.73.146:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/04/2020 13:59:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answerid` int(11) NOT NULL AUTO_INCREMENT,
  `recordid` int(11) NOT NULL COMMENT '考试记录id',
  `questionid` int(11) DEFAULT NULL COMMENT '试题id',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答案',
  `credit` int(255) DEFAULT NULL COMMENT '得分',
  PRIMARY KEY (`answerid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1370 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for black_list
-- ----------------------------
DROP TABLE IF EXISTS `black_list`;
CREATE TABLE `black_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '程序名',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `process` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '进程',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `chapterid` int(11) NOT NULL AUTO_INCREMENT COMMENT '章节id',
  `chaptername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '章节名称',
  `courseid` int(11) DEFAULT NULL COMMENT '课程id',
  `index` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '第几章',
  PRIMARY KEY (`chapterid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`classid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for condition
-- ----------------------------
DROP TABLE IF EXISTS `condition`;
CREATE TABLE `condition`  (
  `difficulty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '难度',
  `chapterid` int(11) DEFAULT NULL COMMENT '章节id',
  `strategyid` int(11) DEFAULT NULL COMMENT '策略id',
  `count` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `coursename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `teacherid` int(255) DEFAULT NULL COMMENT '课程负责人',
  PRIMARY KEY (`courseid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for getclass
-- ----------------------------
DROP TABLE IF EXISTS `getclass`;
CREATE TABLE `getclass`  (
  `getclassid` int(11) NOT NULL AUTO_INCREMENT,
  `teachid` int(11) NOT NULL COMMENT '任课老师id',
  `classid` int(11) DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`getclassid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `paperid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `starttime` datetime(0) DEFAULT NULL COMMENT '开始时间',
  `finishtime` datetime(0) DEFAULT NULL COMMENT '结束时间',
  `pattern` int(11) DEFAULT NULL COMMENT '1:限通信模式,2:霸屏模式',
  `ismonitor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否开启监控',
  `courseid` int(11) DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`paperid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paper_question
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question`  (
  `questionid` int(11) NOT NULL COMMENT '试题id',
  `paperid` int(11) DEFAULT NULL COMMENT '试卷id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `subjectid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题类型',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题目内容',
  `option1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项1',
  `option2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项2',
  `option3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项3',
  `option4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项4',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答案',
  `difficulty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '难度',
  `chapterid` int(11) DEFAULT NULL COMMENT '章节id',
  PRIMARY KEY (`subjectid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 384 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `recordid` int(11) NOT NULL AUTO_INCREMENT COMMENT '考试记录id',
  `studentid` int(11) DEFAULT NULL COMMENT '学生id',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '成绩',
  `monitor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监控',
  `paperid` int(11) DEFAULT NULL COMMENT '试卷id',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`recordid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 458 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
  `strategyid` int(11) NOT NULL AUTO_INCREMENT COMMENT '策略id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题类型',
  `value` int(11) DEFAULT NULL COMMENT '分值',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `paperid` int(11) DEFAULT NULL COMMENT '试卷id',
  `mode` int(255) DEFAULT NULL COMMENT '策略类型',
  PRIMARY KEY (`strategyid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach`  (
  `teachid` int(11) NOT NULL AUTO_INCREMENT COMMENT '任课老师id',
  `teacherid` int(11) NOT NULL COMMENT '教师id',
  `courseid` int(11) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`teachid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师名称',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色',
  `classid` int(11) DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
