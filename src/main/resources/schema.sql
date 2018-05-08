CREATE DATABASE paper;

use paper;

CREATE TABLE student (
  sid BIGINT PRIMARY KEY Not NULL COMMENT '学生学号',
  sname VARCHAR(20) NOT NULL COMMENT '学生姓名',
  sex VARCHAR(20) NOT NULL COMMENT '学生性别',
  age INT NOT NULL COMMENT '学生年龄',
  major VARCHAR(100) NOT NULL COMMENT '专业',
  mail VARCHAR(100) NOT NULL COMMENT '学生邮箱',
  password VARCHAR(100) NOT NULL COMMENT '学生密码',
  tid BIGINT COMMENT '导师工号',
  pid BIGINT COMMENT '论文编号',
  constraint t_fk foreign key(tid) references teacher(tid),
  constraint p_fk foreign key(pid) references paper(pid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE teacher (
  tid BIGINT NOT NULL COMMENT '导师编号',
  tname VARCHAR(20) NOT NULL COMMENT '导师姓名',
  prof VARCHAR(20) NOT NULL COMMENT '职称',
  mail VARCHAR(100) NOT NULL COMMENT '导师邮箱',
  password VARCHAR(100) NOT NULL COMMENT '导师密码',
  student VARCHAR(20) COMMENT '导师的学生',
PRIMARY KEY (tid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE paper (
  pid  BIGINT NOT NULL AUTO_INCREMENT COMMENT '论文id',
  pname VARCHAR(100)  COMMENT '论文题目',
  pcontent VARCHAR(1000)  COMMENT '论文题目',
  state VARCHAR(20) NOT NULL COMMENT '论文状态',
PRIMARY KEY (pid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;