/* temp.sql-临时测试用的sql */
use SpringBootMybatisBase;

/* 查询过期的token信息 */
select token,uid,lastupdate from TbToken
where timestampdiff(minute,lastupdate,now())
>
(select configValue from TbConfig where configKey='token.timeout');

