package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;
import top.huhuiyu.springbootmybatisbase.model.UtilModel;

/**
 * -工具类服务
 * 
 * @author DarkKnight
 *
 */
public interface UtilService {

  /**
   * -生成图片校验码
   * 
   * @param model
   * @return
   * @throws Exception
   */
  String makeImageCode(UtilModel model) throws Exception;

  /**
   * -校验图片校验码是否正确，服务器端的图片校验码只能使用一次
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;
}
