package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.base.NeedLogin;
import top.huhuiyu.springbootmybatisbase.entity.TbUser;
import top.huhuiyu.springbootmybatisbase.model.TestModel;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试控制器，实现了NeedLogin接口，会被注入登录的user信息，否则该控制器无法进入
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/test")
public class TestController implements NeedLogin {
  private TbUser user;

  @Override
  public void setUser(TbUser user) {
    this.user = user;
  }

  /**
   * -测试NeedLogin接口
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/index")
  public JsonMessage index(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/index?token=5a58212c-a71a-4c51-8e39-e307c8a816e7
    JsonMessage message = JsonMessage.getSuccess("测试NeedLogin接口");
    // 可以直接拿到登录的user信息
    message.getDatas().put("user", user);
    return message;
  }

}
