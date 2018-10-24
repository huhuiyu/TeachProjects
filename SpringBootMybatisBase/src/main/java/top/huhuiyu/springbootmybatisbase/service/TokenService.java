package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;

/**
 * Token服务
 * 
 * @author DarkKnight
 *
 */
public interface TokenService {

  /**
   * -检查token是否存在，不存在就返回新的
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken checkToken(TbToken token) throws Exception;

  /**
   * -删除所有过期token
   * 
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;

}
