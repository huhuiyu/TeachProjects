/* 
  tables.sql
    初始化数据库和表的脚本
*/
use information_schema;
drop database if exists SpringBootMybatisBase;
create database SpringBootMybatisBase default charset utf8 collate utf8_general_ci;
use SpringBootMybatisBase;

/* 系统配置表 */
create table TbConfig
(
  configKey varchar(50) primary key comment '配置键值，主键',
  configValue varchar(2000) comment '配置值',
  lastupdate timestamp comment '最后更新时间'
);

/* 用户表 */
create table TbUser
(
  uid int auto_increment primary key comment '用户id，主键',
  username varchar(50) unique not null comment '用户名',
  password varchar(20) not null comment '密码',
  nickname varchar(200) comment '昵称',
  isEnable enum('y','n') default 'y' not null
    comment '是否启用，y:启用（默认），n:停用',
  regDate timestamp default now() not null comment '注册时间'
);

/* 用户Token追踪表 */
create table TbToken
(
  token varchar(50) primary key comment '令牌值，自然主键',
  uid int comment '令牌对应的用户，可以是null，表示用户还没有登录',
  lastupdate timestamp comment '令牌环最后更新时间'
);

/* token附加信息表 */
create table TbTokenInfo
(
  token varchar(50) comment '令牌',
  infoKey varchar(50) comment '令牌信息key值',
  info varchar(2000) comment '令牌信息值',
  lastupdate timestamp comment '令牌信息最后更新时间',
  constraint pkTbTokenInfo primary key(token,infoKey)
);
