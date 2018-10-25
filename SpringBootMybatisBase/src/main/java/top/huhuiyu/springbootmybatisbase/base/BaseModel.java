package top.huhuiyu.springbootmybatisbase.base;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;

/**
 * -model层基类
 * 
 * @author DarkKnight
 *
 */
public abstract class BaseModel extends BaseEntity {
  private static final long serialVersionUID = -7852662611922789479L;
  private String token;

  public BaseModel() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * -获取token的委托方法
   * 
   * @return
   */
  public TbToken getTbToken() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(token);
    return tbToken;
  }

}
