package top.huhuiyu.springbootmybatisbase.model;

import top.huhuiyu.springbootmybatisbase.base.BaseModel;
import top.huhuiyu.springbootmybatisbase.entity.TbUser;

/**
 * -User控制器的模型
 * 
 * @author DarkKnight
 *
 */
public class UserModel extends BaseModel {
  private static final long serialVersionUID = -7071293662612144839L;
  private TbUser user = new TbUser();

  public UserModel() {
  }

  public TbUser getUser() {
    return user;
  }

  public void setUser(TbUser user) {
    this.user = user;
  }

}
