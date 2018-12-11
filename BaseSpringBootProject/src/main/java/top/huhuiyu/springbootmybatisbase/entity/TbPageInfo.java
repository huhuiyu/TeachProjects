package top.huhuiyu.springbootmybatisbase.entity;

import java.util.Date;

import top.huhuiyu.springbootmybatisbase.base.BaseEntity;

/**
 * TbPageInfo表
 * 
 * @author DarkKnight
 *
 */
public class TbPageInfo extends BaseEntity {

  private static final long serialVersionUID = -7355467159598739023L;

  private Integer pid;
  private String title;
  private String info;
  private String tel;
  private String copyright;
  private String comname;
  private Date lastupdate;

  public TbPageInfo() {
  }

  public TbPageInfo(Integer pid, String title, String info, String tel, String copyright, String comname, Date lastupdate) {
    this.pid = pid;
    this.title = title;
    this.info = info;
    this.tel = tel;
    this.copyright = copyright;
    this.comname = comname;
    this.lastupdate = lastupdate;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public String getComname() {
    return comname;
  }

  public void setComname(String comname) {
    this.comname = comname;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
