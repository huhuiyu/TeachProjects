package top.huhuiyu.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.entity.TbUser;

/**
 * TbUser的dao
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbUserDAO {
  /**
   * -按照用户名查询用户信息
   * 
   * @param user
   * @return
   * @throws Exception
   */
  TbUser queryByName(TbUser user) throws Exception;

  /**
   * -查询token中的用户信息
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbUser queryByToken(TbToken token) throws Exception;

}
