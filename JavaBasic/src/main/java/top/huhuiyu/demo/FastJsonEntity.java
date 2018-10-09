package top.huhuiyu.demo;

import java.io.Serializable;

/**
 * 演示fastjson的实体类
 * 
 * @author DarkKnight
 *
 */
public class FastJsonEntity implements Serializable {
  private static final long serialVersionUID = 4445946548722926826L;
  private Integer eid;
  private String info;

  public FastJsonEntity() {
  }

  @Override
  public String toString() {
    return "FastJsonEntity [eid=" + eid + ", info=" + info + "]";
  }

  public Integer getEid() {
    return eid;
  }

  public void setEid(Integer eid) {
    this.eid = eid;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

}
