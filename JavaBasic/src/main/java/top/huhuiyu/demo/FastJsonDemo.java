package top.huhuiyu.demo;

import com.alibaba.fastjson.JSONObject;

/**
 * FastJson的演示
 * 
 * @author DarkKnight
 *
 */
public class FastJsonDemo {
  public static void main(String[] args) {
    FastJsonEntity entity = new FastJsonEntity();
    entity.setEid(1000);
    entity.setInfo("信息");
    // 使用fastjson转换对象到json字符串
    JSONObject json = new JSONObject();
    json.put("entity", entity);
    String result = json.toJSONString();
    System.out.println(entity);
    System.out.println(result);
  }

}
