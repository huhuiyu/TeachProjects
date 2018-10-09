package top.huhuiyu.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MyApi单元测试
 * 
 * @author DarkKnight
 *
 */
public class MyApiTest {
  private MyApi api = new MyApi();

  @Test
  public void getNow() {
    String now = api.getNow();
    //相等测试断言，getNow返回值的长度是19
    assertEquals(now.length(), 19);
  }
}
