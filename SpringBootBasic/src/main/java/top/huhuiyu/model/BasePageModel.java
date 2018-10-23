package top.huhuiyu.model;

import top.huhuiyu.entity.PageBean;

/**
 * -带分页的基础model
 * 
 * @author DarkKnight
 *
 */
public abstract class BasePageModel extends BaseModel {

  private static final long serialVersionUID = 1357654816700875703L;
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
