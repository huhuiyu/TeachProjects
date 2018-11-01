package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;
import top.huhuiyu.springbootmybatisbase.model.TestModel;
import top.huhuiyu.springbootmybatisbase.service.TestService;
import top.huhuiyu.springbootmybatisbase.service.UtilService;
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
  @Autowired
  private UtilService utilService;

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

  @RequestMapping("/imageCode")
  public JsonMessage imageCode(TestModel model) throws Exception {
    // 获取图片校验码
    TbTokenInfo info = model.makeTbTokenInfo();
    info.setInfo(model.getImageCode());
    // 校验
    boolean check = utilService.checkImageCode(info);
    if (check) {
      return JsonMessage.getSuccess("图片校验正确");
    } else {
      return JsonMessage.getFail("图片校验失败");
    }
  }

}
