package top.huhuiyu.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.entity.JsonMessage;
import top.huhuiyu.entity.TbToken;
import top.huhuiyu.exception.AppException;
import top.huhuiyu.service.TokenService;

/**
 * 测试用的控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@ResponseBody
@RequestMapping("/test")
public class TestIndexController {

  @Autowired
  private TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }

  @RequestMapping("/exception")
  public JsonMessage exception(String type) throws Exception {
    if ("one".equals(type)) {
      throw AppException.getAppException(1000, "第一种异常");
    } else if ("two".equals(type)) {
      throw AppException.getAppException(1001, "第二种异常");
    } else if ("ok".equals(type)) {
      return JsonMessage.getSuccess("没有错误！");
    } else {
      throw new Exception("标准异常");
    }
  }

  @RequestMapping("/converter")
  public JsonMessage converter(TestEntity test) throws Exception {
    // http://127.0.0.1:20000/test/converter
    //  ?info=abc&tint=123&tdouble=290.89&tdec=345.8&tdate=1998-09-11 12:13:14
    JsonMessage json = JsonMessage.getSuccess("");
    json.getDatas().put("entity", test);
    return json;
  }

}
