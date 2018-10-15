package top.huhuiyu.entity;

import java.util.Date;

/**
 * TbToken表
 * 
 * @author DarkKnight
 *
 */
public class TbToken extends EntityBase {

  private static final long serialVersionUID = -2313018616200398517L;
  private String token;
  private Integer uid;
  private Date lastupdate;

  public TbToken() {
  }

  public TbToken(String token, Integer uid, Date lastupdate) {
    this.token = token;
    this.uid = uid;
    this.lastupdate = lastupdate;
  }

  @Override
  public String toString() {
    return "TbToken [token=" + token + ", uid=" + uid + ", lastupdate=" + lastupdate + "]";
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
