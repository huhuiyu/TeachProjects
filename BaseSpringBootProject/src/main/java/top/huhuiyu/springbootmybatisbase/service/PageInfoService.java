package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.model.PageInfoModel;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * TbPageInfo服务层
 * 
 * @author DarkKnight
 *
 */
public interface PageInfoService {
  /**
   * -分页查询
   * 
   * @param model 模型数据
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage queryAll(PageInfoModel model) throws Exception;

  /**
   * -主键查询
   * 
   * @param model 模型数据
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage queryByKey(PageInfoModel model) throws Exception;

  /**
   * -添加
   * 
   * @param model 模型数据
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage add(PageInfoModel model) throws Exception;

  /**
   * -修改
   * 
   * @param model 模型数据
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage modify(PageInfoModel model) throws Exception;

  /**
   * -删除
   * 
   * @param model 模型数据
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage delete(PageInfoModel model) throws Exception;

}
