package top.huhuiyu.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;

/**
 * TbToken表的dao
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenDAO {

  /**
   * -查询token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * -添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;

  /**
   * -更新token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * -删除所有过期token
   * 
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;
}
