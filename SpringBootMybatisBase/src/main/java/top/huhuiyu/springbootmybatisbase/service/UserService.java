package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.model.UserModel;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -User控制器的服务
 * 
 * @author DarkKnight
 *
 */
public interface UserService {

  /**
   * -用户登陆
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage login(UserModel model) throws Exception;

  /**
   * -用户注销
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage logout(UserModel model) throws Exception;

  /**
   * 查询登录用户信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getUserInfo(UserModel model) throws Exception;

}
