package top.huhuiyu.springbootmybatisbase.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * BigDecimal数值转换器
 * 
 * @author DarkKnight
 *
 */
@Component
public class DecimalConverter implements Converter<String, BigDecimal> {

  @Override
  public BigDecimal convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      return new BigDecimal(source);
    } catch (Exception ex) {
    }
    return null;
  }

}
