package top.huhuiyu.springbootmybatisbase.base;

import top.huhuiyu.springbootmybatisbase.entity.TbUser;

/**
 * -需要登录的标志接口
 * 
 * @author DarkKnight
 *
 */
public interface NeedLogin {
  /**
   * -没有登录的错误代码
   */
  public static final int NOT_LOGIN = 1000;

  /**
   * -传入登录的用户信息
   * 
   * @param user
   */
  public void setUser(TbUser user);
}
