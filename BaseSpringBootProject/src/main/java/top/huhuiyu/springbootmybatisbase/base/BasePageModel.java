package top.huhuiyu.springbootmybatisbase.base;

import top.huhuiyu.springbootmybatisbase.utils.PageBean;

/**
 * -带分页信息的model基类
 * 
 * @author DarkKnight
 *
 */
public class BasePageModel extends BaseModel {
  private static final long serialVersionUID = -5737390310185331041L;
  private PageBean page = new PageBean();

  public BasePageModel() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

}
