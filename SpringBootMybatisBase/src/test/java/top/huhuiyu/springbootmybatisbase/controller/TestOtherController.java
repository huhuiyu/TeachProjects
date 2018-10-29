package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.model.TestModel;
import top.huhuiyu.springbootmybatisbase.service.TestService;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -其它测试控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/test")
public class TestOtherController {
  @Autowired
  private TestService testService;

  /**
   * -测试事务
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/tran")
  public JsonMessage tran(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/tran?token=&ctoken.token=abcdefg&tokenInfo.infoKey=abc123&tokenInfo.info=dddd
    model.getTokenInfo().setToken(model.getCtoken().getToken());
    return testService.tranAdd(model);
  }
}
