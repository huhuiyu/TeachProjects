package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.model.TestModel;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试服务
 * 
 * @author DarkKnight
 *
 */
public interface TestService {

  /**
   * -测试事务添加
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage tranAdd(TestModel model) throws Exception;
}
