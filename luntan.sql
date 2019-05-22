/*
MySQL Data Transfer
Source Host: localhost
Source Database: luntan
Target Host: localhost
Target Database: luntan
Date: 2016/2/16 23:38:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(55) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_catelog
-- ----------------------------
CREATE TABLE `t_catelog` (
  `id` int(11) NOT NULL,
  `name` varchar(55) DEFAULT NULL,
  `del` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_huifu
-- ----------------------------
CREATE TABLE `t_huifu` (
  `id` int(11) NOT NULL,
  `title` varchar(4000) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `zhuti_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `loginname` varchar(50) DEFAULT NULL,
  `loginpw` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `fujian` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_zhuti
-- ----------------------------
CREATE TABLE `t_zhuti` (
  `id` int(11) NOT NULL,
  `title` varchar(4000) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `fujian` varchar(55) DEFAULT NULL,
  `fujianYuanshiming` varchar(50) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `catelog_id` int(11) NOT NULL,
  `shifouding` varchar(255) DEFAULT NULL,
  `shifoujing` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_catelog` VALUES ('1', '计算机', 'no');
INSERT INTO `t_catelog` VALUES ('2', '英语角', 'no');
INSERT INTO `t_catelog` VALUES ('3', '音乐之声', 'no');
INSERT INTO `t_catelog` VALUES ('4', '奥妙之门', 'no');
INSERT INTO `t_catelog` VALUES ('5', '新的板块', 'yes');
INSERT INTO `t_huifu` VALUES ('1', 'ww', 'ww', '2016-11-25', '1', '17');
INSERT INTO `t_huifu` VALUES ('2', '23', '2323', '2016-02-16', '5', '12');
INSERT INTO `t_user` VALUES ('1', 'aaaaaa', 'aaaaaa', '动脑子', '男', '21', '北京', '13122222222', 'liu3718@yahoo.cn', '1111111', '1', '/upload/1334384968671.jpg', 'no');
INSERT INTO `t_user` VALUES ('2', 'zhangfi', '000000', '张飞飞', '女', '25', '北京', '13133333333', 'zhangfi@yahoo.cn', '2222222', '1', '/upload/1334384968672.jpg', 'yes');
INSERT INTO `t_user` VALUES ('4', 'liqviang', '000000', '李强强', '男', '25', '北京', '13555555555', 'liqviang@yahoo.cn', '3333333', '1', '/upload/1334384968673.jpg', 'yes');
INSERT INTO `t_user` VALUES ('5', 'cccccc', 'cccccc', '李东', '男', '22', '22', '22', '22', '22', '1', '/upload/1455636565033.jpg', 'no');
INSERT INTO `t_zhuti` VALUES ('4', 'J2ME程序运行中如何获知来电或其他与程序本身无关的异常情况', 'J2ME程序运行中如何获知来电或其他与程序本身无关的其他手机异常情况呢？<br />\r\n比如获取来电信息或短信等等', '', '', '2016-11-20', '1', '1', '是', '是');
INSERT INTO `t_zhuti` VALUES ('5', '浅谈J2me游戏如何快速移植到Android', '很多J2ME开发者可能都会遇到这样的临时性需求。其实J2ME程序往Android移植，并不是特别麻烦。<br />\r\n经过一番认真学习，小白开始整理起了笔记&hellip;&hellip;<br />', '/upload/1332747101578.doc', '附件.doc', '2016-11-20', '1', '1', '否', '是');
INSERT INTO `t_zhuti` VALUES ('6', 'Android 4.0 为什么模拟器老是提示我谷歌拼音输入法已停止', 'Android 4.0 为什么模拟器老是提示我谷歌拼音输入法已停止', '', '', '2016-11-20', '1', '1', '否', '否');
INSERT INTO `t_zhuti` VALUES ('8', 'jquery+struts2无刷新分页，哪位有例子 ', 'jquery+struts2无刷新分页，哪位有例子', '/upload/1332747101578.doc', '附件.doc', '2016-11-20', '1', '1', '否', '否');
INSERT INTO `t_zhuti` VALUES ('9', '为什么总看到有人说因为用了StringBuilder所以string.Format一定效率高', '为什么总看到有人说因为用了StringBuilder所以string.Format一定效率高', '', '', '2016-11-20', '1', '2', '否', '否');
INSERT INTO `t_zhuti` VALUES ('11', 'VB.NET编写的函数中包含可选数组时，如何初始化数组？', 'VB.NET编写的函数中包含可选数组时，如何初始化数组？', '', '', '2016-11-20', '1', '2', '否', '否');
INSERT INTO `t_zhuti` VALUES ('12', 'win7下用批处理获取IP地址，并赋值给某变量？？？ ', 'win7下用批处理获取IP地址，并赋值给某变量？？？', '', '', '2016-11-20', '1', '3', '否', '否');
INSERT INTO `t_zhuti` VALUES ('13', 'WIN7 使用中突然黑屏，右下角有一小段亮线 ', 'WIN7 使用中突然黑屏，右下角有一小段亮线', '', '', '2016-11-20', '1', '3', '否', '否');
INSERT INTO `t_zhuti` VALUES ('15', '在win7（32位）系统上安装oracle后sqlplus不能使用时怎么回事？ ', '在win7（32位）系统上安装oracle后sqlplus不能使用时怎么回事？', '', '', '2016-11-20', '1', '3', '否', '否');
INSERT INTO `t_zhuti` VALUES ('17', 'wwwwwwww', 'wwwwwwwwwwwwwwwwwwwwww', '', null, '2016-11-25', '1', '1', '是', '否');
INSERT INTO `t_zhuti` VALUES ('18', '222', '222', '', null, '2016-02-16', '5', '2', '否', '否');
