package top.huhuiyu.springbootmybatisbase.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.springbootmybatisbase.dao.TbTokenDAO;
import top.huhuiyu.springbootmybatisbase.dao.TbTokenInfoDAO;
import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.service.TokenService;
import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {
  @Autowired
  private TbTokenDAO tbTokenDAO;
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  /**
   * -创建新的token
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
  public TbToken checkToken(TbToken token) throws Exception {
    // 没有传入就返回新的
    if (token == null || MyUtils.isEmpty(token.getToken())) {
      return newToken();
    }
    // 数据库校验
    TbToken stoken = tbTokenDAO.queryToken(token);
    // 校验不通过就返回新的
    if (stoken == null) {
      return newToken();
    }
    // 通过就更新时间
    tbTokenDAO.updateToken(stoken);
    return stoken;
  }

  @Override
  public int deleteTokens() throws Exception {
    // 先删除tokeninfo
    tbTokenInfoDAO.deleteTokenInfos();
    // 再删除token
    return tbTokenDAO.deleteTokens();
  }

}
