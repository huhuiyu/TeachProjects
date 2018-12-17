package top.huhuiyu.springbootmybatisbase.utils;

/**
 * 工具类
 * 
 * @author DarkKnight
 *
 */
public class MyUtils {

  /**
   * 判断是否是null或者是全部都是空白字符
   * 
   * @param value 字符串
   * @return 是否是null或者是全部都是空白字符
   */
  public static boolean isEmpty(String value) {
    return value == null || "".equals(value.trim());
  }

  /**
   * 去掉头尾空白字符，null值也會返回成空字符串
   * 
   * @param value 字符串
   * @return 去掉头尾空白字符的结果
   */
  public static String trim(String value) {
    if (isEmpty(value)) {
      return "";
    }
    return value.trim();
  }
}
