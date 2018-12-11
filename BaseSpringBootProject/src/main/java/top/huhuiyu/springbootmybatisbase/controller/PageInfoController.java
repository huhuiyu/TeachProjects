package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.model.PageInfoModel;
import top.huhuiyu.springbootmybatisbase.service.PageInfoService;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -TbPageInfo控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/pageinfo")
public class PageInfoController {
  @Autowired
  private PageInfoService pageInfoService;

  /**
   * -查询全部
   * 
   * @param model 数据模型
   * @return json数据
   * @throws Exception 处理异常
   */
  @RequestMapping("/queryAll")
  public JsonMessage queryAll(PageInfoModel model) throws Exception {
    return pageInfoService.queryAll(model);
  }

  /**
   * -添加
   * 
   * @param model 数据模型
   * @return json数据
   * @throws Exception 处理异常
   */
  @RequestMapping("/add")
  public JsonMessage add(PageInfoModel model) throws Exception {
    return pageInfoService.add(model);
  }

  /**
   * -主键查询
   * 
   * @param model 数据模型
   * @return json数据
   * @throws Exception 处理异常
   */
  @RequestMapping("/queryByKey")
  public JsonMessage queryByKey(PageInfoModel model) throws Exception {
    return pageInfoService.queryByKey(model);
  }

  /**
   * -修改
   * 
   * @param model 数据模型
   * @return json数据
   * @throws Exception 处理异常
   */
  @RequestMapping("/modify")
  public JsonMessage modify(PageInfoModel model) throws Exception {
    return pageInfoService.modify(model);
  }

  /**
   * -删除
   * 
   * @param model 数据模型
   * @return json数据
   * @throws Exception 处理异常
   */
  @RequestMapping("/delete")
  public JsonMessage delete(PageInfoModel model) throws Exception {
    return pageInfoService.delete(model);
  }

}
