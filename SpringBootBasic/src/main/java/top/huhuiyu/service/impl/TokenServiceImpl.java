package top.huhuiyu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.dao.TbTokenDAO;
import top.huhuiyu.entity.JsonMessage;
import top.huhuiyu.entity.TbToken;
import top.huhuiyu.service.TokenService;
import top.huhuiyu.utils.MyUtils;

/**
 * TbToken的服务 Transactional表示开启事务处理，表示类中的方法调用dao处理数据会在事务中，
 * 要么全部成功，要么全部失败，所以一定要service层处理业务
 * rollbackFor表示要回滚事务的类型，Exception.class表示方法抛出Exception或者它的子类就会事务回滚
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {
  @Autowired
  private TbTokenDAO tbTokenDAO;

  /**
   * makeNewToken-创建一个新的token
   * SpringBootMybatisBase
   * @return
   * @throws Exception
   */
  private JsonMessage makeNewToken() throws Exception {
    // 通过uuid生成随机的token
    String t = UUID.randomUUID().toString();
    TbToken stoken = new TbToken();
    stoken.setToken(t);
    // 保存到数据库
    tbTokenDAO.addToken(stoken);
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("token", stoken.getToken());
    return message;
  }

  @Override
  public JsonMessage createToken(TbToken token) throws Exception {
    // 1：查询token是否存在
    // 传入token基本校验
    // 2:不存在要创建
    if (token == null || token.getToken() == null) {
      return makeNewToken();
    }
    // 数据库校验
    // 2：不存在要创建
    TbToken stoken = tbTokenDAO.queryToken(token);
    if (stoken == null) {
      return makeNewToken();
    }
    // 3：存在就更新
    tbTokenDAO.updateToken(stoken);
    // 4：返回token
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("token", stoken.getToken());
    return message;
  }

  /**
   * -创建新Token
   * 
   * @return
   * @throws Exception
   */
  private TbToken newToken() throws Exception {
    TbToken token = new TbToken();
    token.setToken(UUID.randomUUID().toString());
    tbTokenDAO.addToken(token);
    return token;
  }

  @Override
  public TbToken checkTbToken(TbToken token) throws Exception {
    // 客戶端沒有传入token就需要创建新的token
    if (token == null || MyUtils.isEmpty(token.getToken())) {
      return newToken();
    }
    // 查看token是否存在
    TbToken stoken = tbTokenDAO.queryToken(token);
    if (stoken == null) {
      // 不存在就重新创建
      return newToken();
    }
    // 存在就更新
    tbTokenDAO.updateToken(stoken);
    return stoken;
  }

}
