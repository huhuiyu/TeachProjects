package top.huhuiyu.service;

import top.huhuiyu.entity.JsonMessage;

/**
 * TestService-测试用服务
 * 
 * @author DarkKnight
 *
 */
public interface TestService {

  /**
   * 1-分页查询
   * @return
   * @throws Exception
   */
  JsonMessage queryTokens() throws Exception;
  
}
