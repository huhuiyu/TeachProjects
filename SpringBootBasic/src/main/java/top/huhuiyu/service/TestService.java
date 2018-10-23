package top.huhuiyu.service;

import top.huhuiyu.entity.JsonMessage;
import top.huhuiyu.entity.PageBean;

/**
 * TestService-测试用服务
 * 
 * @author DarkKnight
 *
 */
public interface TestService {

  /**
   * 1-分页查询
   * 
   * @param page
   * @return
   * @throws Exception
   */
  JsonMessage queryTokens(PageBean page) throws Exception;

}
