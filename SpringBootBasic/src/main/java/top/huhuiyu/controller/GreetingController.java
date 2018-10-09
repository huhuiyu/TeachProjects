package top.huhuiyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.entity.Greeting;

/**
 * Greeting控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
public class GreetingController {

  @RequestMapping(name = "")
  public String index() {
    // http://127.0.0.1:8080
    return "欢迎使用springboot！";
  }

  @RequestMapping("/greeting")
  @ResponseBody
  public Greeting greeting(Greeting greeting) {
    // http://127.0.0.1:8080/greeting
    // http://127.0.0.1:8080/greeting?id=100
    // http://127.0.0.1:8080/greeting?id=101&content=abc123
    return greeting;
  }

}
