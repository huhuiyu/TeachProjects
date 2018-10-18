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

  private static final String OK = "ok";
  private static final String TWO = "two";
  private static final String ONE = "one";
  
  @Autowired
  private TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }

  @RequestMapping("/exception")
  public JsonMessage exception(String type) throws Exception {
    if (ONE.equals(type)) {
      throw AppException.getAppException(1000, "第一种异常");
    } else if (TWO.equals(type)) {
      throw AppException.getAppException(1001, "第二种异常");
    } else if (OK.equals(type)) {
      return JsonMessage.getSuccess("没有错误！");
    } else {
      throw new Exception("标准异常");
    }
  }

  @RequestMapping("/converter")
  public JsonMessage converter(TestEntity test) throws Exception {
    // http://127.0.0.1:20000/test/converter
    // ?info=abc&tint=123&tdouble=290.89&tdec=345.8&tdate=1998-09-11 12:13:14
    JsonMessage json = JsonMessage.getSuccess("");
    json.getDatas().put("entity", test);
    return json;
  }

  @RequestMapping("/model")
  public JsonMessage model(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/model
    // 在控制器中定义的参数用于获取客户端的数据，该对象的字段直接对应客户端参数名
    // TestModel中的token字段，可以直接用?token=adfadfaf传递
    // 如果字段是复杂对象，需要通过二级名称传递
    // TestModel中的entity字段是TestEntity对象，里面包含tint,tdec等等字段
    // 需要用?entity.tint=100&entity.tdec=12.34传递
    // 传递不同的数据组合：?token=aaaaaa&entity.tint=100&entity.tdec=12.34排名不分先后
    // post提交也是一样的规则 {token:'adfadsf','entity.tint':12}

    // http://127.0.0.1:20000/test/model ==> token和entity都没有数据
    // http://127.0.0.1:20000/test/model?token=abcdefg
    // ==> token为abcdefg，entity没有数据
    // http://127.0.0.1:20000/test/model?taken=abcdefg
    // ==> token和entity都没有数据
    // http://127.0.0.1:20000/test/model?token=abcdefg&entity.tint=123
    // ==> token为abcdefg，entity的tint字段为123

    // 注意！！！！传递的参数名都是以对象的字段名称，而不是对象的类名称
    // model的字段名称是entity，类型是TestEntity

    JsonMessage json = JsonMessage.getSuccess("");
    json.getDatas().put("model", model);
    return json;
  }

}
