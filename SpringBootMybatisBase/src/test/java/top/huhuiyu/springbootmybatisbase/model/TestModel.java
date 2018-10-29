package top.huhuiyu.springbootmybatisbase.model;

import top.huhuiyu.springbootmybatisbase.base.BaseModel;
import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -测试用model
 * 
 * @author DarkKnight
 *
 */
public class TestModel extends BaseModel {
  private static final long serialVersionUID = -2661095345363340253L;

  private TbToken ctoken = new TbToken();
  private TbTokenInfo tokenInfo = new TbTokenInfo();

  public TestModel() {
  }

  public TbToken getCtoken() {
    return ctoken;
  }

  public void setCtoken(TbToken ctoken) {
    this.ctoken = ctoken;
  }

  public TbTokenInfo getTokenInfo() {
    return tokenInfo;
  }

  public void setTokenInfo(TbTokenInfo tokenInfo) {
    this.tokenInfo = tokenInfo;
  }

}
