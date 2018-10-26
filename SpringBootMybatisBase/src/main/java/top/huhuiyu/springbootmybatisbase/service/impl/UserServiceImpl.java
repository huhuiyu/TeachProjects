package top.huhuiyu.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.springbootmybatisbase.dao.TbTokenDAO;
import top.huhuiyu.springbootmybatisbase.dao.TbUserDAO;
import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.entity.TbUser;
import top.huhuiyu.springbootmybatisbase.exception.AppException;
import top.huhuiyu.springbootmybatisbase.model.UserModel;
import top.huhuiyu.springbootmybatisbase.service.UserService;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;
import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
  @Autowired
  private TbUserDAO tbUserDAO;
  @Autowired
  private TbTokenDAO tbTokenDAO;

  @Override
  public JsonMessage login(UserModel model) throws Exception {
    // 非数据库问题直接返回JsonMessage
    TbUser user = model.getUser();
    // 校验用户输入
    if (MyUtils.isEmpty(user.getUsername())) {
      return JsonMessage.getFail("用户名必须填写");
    }
    if (MyUtils.isEmpty(user.getPassword())) {
      return JsonMessage.getFail("密码必须填写");
    }
    // 数据库校验，只要不出现更新数据的语句不需要抛出异常
    TbUser suser = tbUserDAO.queryByName(user);
    if (suser == null) {
      return JsonMessage.getFail("用户名不存在");
    }
    // 存在就比对密码是否正确
    if (!suser.getPassword().equalsIgnoreCase(user.getPassword())) {
      return JsonMessage.getFail("密码错误");
    }
    // 需要将登录信息保存到token表
    TbToken token = model.getTbToken();
    token.setUid(suser.getUid());
    int result = tbTokenDAO.userLogin(token);
    // 如果数据库更新的结果不是预期效果需要通过抛出异常打断流程，回滚事务！！！！
    if (result != 1) {
      throw AppException.getAppException(500, "登录状态异常!");
    }
    return JsonMessage.getSuccess("登录成功");
  }

  @Override
  public JsonMessage logout(UserModel model) throws Exception {
    tbTokenDAO.userLogout(model.getTbToken());
    return JsonMessage.getSuccess("退出成功");
  }

  @Override
  public JsonMessage getUserInfo(UserModel model) throws Exception {
    TbUser user = tbUserDAO.queryByToken(model.getTbToken());
    // 不要返回uid给客户端
    if (user != null) {
      user.setUid(null);
    }
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("user", user);
    return message;
  }

}
