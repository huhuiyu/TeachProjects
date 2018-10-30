package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.model.IndexModel;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -首页服务
 * 
 * @author DarkKnight
 *
 */
public interface IndexService {

  /**
   * -首页echo
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage index(IndexModel model) throws Exception;
}
