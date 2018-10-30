package top.huhuiyu.springbootmybatisbase.utils;

/**
 * MyUtils-工具包
 * 
 * @author DarkKnight
 *
 */
public class MyUtils {

  /**
   * isEmpty-判断是否是null或者是全部都是空白字符
   * 
   * @param value
   * @return
   */
  public static boolean isEmpty(String value) {
    return value == null || "".equals(value.trim());
  }

  /**
   * trim-去掉头尾空白字符，null值也會返回成空字符串
   * 
   * @param value
   * @return
   */
  public static String trim(String value) {
    if (isEmpty(value)) {
      return "";
    }
    return value.trim();
  }
}
