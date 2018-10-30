package top.huhuiyu.springbootmybatisbase.entity;

import java.util.Date;

import top.huhuiyu.springbootmybatisbase.base.BaseEntity;

/**
 * TbTokenInfo表
 * 
 * @author DarkKnight
 *
 */
public class TbTokenInfo extends BaseEntity {
  private static final long serialVersionUID = 1569040701336614670L;
  private String token;
  private String infoKey;
  private String info;
  private Date lastupdate;

  public TbTokenInfo() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getInfoKey() {
    return infoKey;
  }

  public void setInfoKey(String infoKey) {
    this.infoKey = infoKey;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
