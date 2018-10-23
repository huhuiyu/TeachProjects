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
   * -更新或者返回新的token
   * 
   * @param token 客戶端的token
   * @return
   * @throws Exception
   */
  JsonMessage createToken(TbToken token) throws Exception;

  /**
   * -检查token信息，不存在就创建新的，否则就更新时间
   * 
   * @param token 客户端token信息
   * @return
   * @throws Exception
   */
  TbToken checkTbToken(TbToken token) throws Exception;
}
