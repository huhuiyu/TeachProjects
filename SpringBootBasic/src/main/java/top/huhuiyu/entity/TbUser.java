package top.huhuiyu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * TbUser表
 * 
 * @author DarkKnight
 *
 */
public class TbUser implements Serializable {

  private static final long serialVersionUID = -5725225942248651055L;
  private Integer uid;
  private String username;
  private String password;
  private String nickname;
  private String isEnable;
  private Date regDate;

  public TbUser() {
  }

  public TbUser(Integer uid, String username, String password, String nickname, String isEnable, Date regDate) {
    this.uid = uid;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
    this.isEnable = isEnable;
    this.regDate = regDate;
  }

  @Override
  public String toString() {
    return "TbUser [uid=" + uid + ", username=" + username + ", password=" + password + ", nickname=" + nickname
        + ", isEnable=" + isEnable + ", regDate=" + regDate + "]";
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(String isEnable) {
    this.isEnable = isEnable;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

}
