package top.huhuiyu.springbootmybatisbase.model;

import top.huhuiyu.springbootmybatisbase.base.BasePageModel;
import top.huhuiyu.springbootmybatisbase.entity.TbPageInfo;

/**
 * -TbPageInfo模型层
 * 
 * @author DarkKnight
 *
 */
public class PageInfoModel extends BasePageModel {

  private static final long serialVersionUID = 1295945855241216107L;

  private TbPageInfo tbPageInfo = new TbPageInfo();

  public PageInfoModel() {
  }

  public TbPageInfo getTbPageInfo() {
    return tbPageInfo;
  }

  public void setTbPageInfo(TbPageInfo tbPageInfo) {
    this.tbPageInfo = tbPageInfo;
  }

}
