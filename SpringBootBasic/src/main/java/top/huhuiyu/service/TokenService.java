package top.huhuiyu.service;

import top.huhuiyu.entity.JsonMessage;
import top.huhuiyu.entity.TbToken;

/**
 * Token的服务
 * 
 * @author DarkKnight
 *
 */
public interface TokenService {

  /**
   * 更新或者返回新的token
   * 
   * @param token 客戶端的token
   * @return
   * @throws Exception
   */
  JsonMessage createToken(TbToken token) throws Exception;
}
