package top.huhuiyu.controller.test;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import top.huhuiyu.entity.EntityBase;

/**
 * converter测试实体类
 *
 * @author DarkKnight
 *
 */
public class TestEntity extends EntityBase {

  private static final long serialVersionUID = -4894183489321781263L;

  private Integer tint;
  private Double tdouble;
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date tdate;
  private BigDecimal tdec;
  private String info;

  public TestEntity() {
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Integer getTint() {
    return tint;
  }

  public void setTint(Integer tint) {
    this.tint = tint;
  }

  public Double getTdouble() {
    return tdouble;
  }

  public void setTdouble(Double tdouble) {
    this.tdouble = tdouble;
  }

  public Date getTdate() {
    return tdate;
  }

  public void setTdate(Date tdate) {
    this.tdate = tdate;
  }

  public BigDecimal getTdec() {
    return tdec;
  }

  public void setTdec(BigDecimal tdec) {
    this.tdec = tdec;
  }

}
