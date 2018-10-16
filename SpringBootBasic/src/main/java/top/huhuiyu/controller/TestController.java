package top.huhuiyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.dao.TbUserDAO;
import top.huhuiyu.entity.JsonMessage;
import top.huhuiyu.entity.TbUser;

/**
 * 测试用的控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/test")
@ResponseBody
public class TestController {

  private static final Logger log = LoggerFactory.getLogger(TestController.class);

  @Autowired
  private TbUserDAO tbUserDAO;

  @RequestMapping("/login")
  public JsonMessage login(TbUser user) throws Exception {
    // http://127.0.0.1:20000/test/login?username=test&password=test-pwd
    // 日志的配置在application.yml里面，error>info>debug
    // 尽可能都用debug，如果是异常信息用error，程序关键项可以用info
    // 发布到服务器的时候需要开启file日志，级别可以升到error
    log.error("error级别信息");
    log.info("info级别信息");
    log.debug(String.valueOf(user));
    TbUser result = tbUserDAO.login(user);
    // 判断是否正确登录
    if (result == null) {
      return JsonMessage.getFail("用户名或者密码错误，登录失败！");
    } else {
      JsonMessage message = JsonMessage.getSuccess("登录成功！");
      message.getDatas().put("loginUser", result);
      return message;
    }
  }

}
