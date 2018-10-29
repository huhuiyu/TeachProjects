package top.huhuiyu.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;

import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * -字符串转换器（去空）
 * 
 * @author DarkKnight
 *
 */
public class StringConverter implements Converter<String, String> {

  @Override
  public String convert(String source) {
    return MyUtils.trim(source);
  }

}
