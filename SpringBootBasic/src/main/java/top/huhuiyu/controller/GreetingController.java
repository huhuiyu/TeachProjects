package top.huhuiyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.config.MyConfig;
import top.huhuiyu.entity.Greeting;
import top.huhuiyu.entity.JsonMessage;

/**
 * Greeting控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@ResponseBody
public class GreetingController {
  @Autowired
  private MyConfig myConfig;

  @RequestMapping(name = "")
  public JsonMessage index() {
    // http://127.0.0.1:20000
    String m = String.format("欢迎使用springboot,%s,%s", myConfig.appName, myConfig.reload);
    JsonMessage message = JsonMessage.getSuccess(m);
    return message;
  }

  @RequestMapping("/greeting")
  public JsonMessage greeting(Greeting greeting) {
    // http://127.0.0.1:20000/greeting
    // http://127.0.0.1:20000/greeting?id=100
    // http://127.0.0.1:20000/greeting?id=101&content=abc123
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("greeting", greeting);
    return message;
  }

}
