package top.huhuiyu.springbootmybatisbase.base;

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

}
