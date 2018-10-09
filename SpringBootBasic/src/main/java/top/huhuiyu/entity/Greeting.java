package top.huhuiyu.entity;

/**
 * 测试实体类
 * 
 * @author DarkKnight
 *
 */
public class Greeting {
  private Integer id;
  private String content;

  public Greeting() {
  }

  public Greeting(Integer id, String content) {
    this.id = id;
    this.content = content;
  }

  @Override
  public String toString() {
    return "Greeting [id=" + id + ", content=" + content + "]";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
