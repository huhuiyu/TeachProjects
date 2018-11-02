/*
  init.sql
    数据初始化脚本
*/
use SpringBootMybatisBase;
truncate table TbConfig;
truncate table TbUser;
truncate table TbToken;
truncate table TbTokenInfo;
/* 系统配置数据 */
/* token过期时间配置，值是分钟数 */
insert into TbConfig(configKey,configValue,lastupdate) values('token.timeout','10',now());

/* 默认测试用户 */
insert into TbUser(username,password,nickname) values('test','test-pwd','测试用户');
insert into TbUser(username,password,nickname) values('guest','guest-pwd','测试用户');

/* 查询 */
select configKey,configValue,lastupdate from TbConfig;
select uid,username,password,nickname,isEnable,regDate from TbUser;
select token,lastupdate from TbToken;
select token,infoKey,info,lastupdate from TbTokenInfo;