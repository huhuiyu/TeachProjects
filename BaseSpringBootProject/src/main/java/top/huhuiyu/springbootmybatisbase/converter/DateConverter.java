package top.huhuiyu.springbootmybatisbase.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * DateConverter-日期数据转换器
 * 
 * @author DarkKnight
 *
 */
@Component
public class DateConverter implements Converter<String, Date> {
  /**
   * 1-短格式日期
   */
  private static final SimpleDateFormat SDF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
  /**
   * 2-长格式日期
   */
  private static final SimpleDateFormat SDF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  /**
   * 1-短日期正则
   */
  private static final Pattern PSHORT = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2}$");
  /**
   * 2-长日期正则
   */
  private static final Pattern PLONG = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2} \\d{2}:\\d{2}:\\d{2}$");

  @Override
  public Date convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      if (PLONG.matcher(source).matches()) {
        // 长日期格式
        return SDF_LONG.parse(source);
      } else if (PSHORT.matcher(source).matches()) {
        // 短日期格式
        return SDF_SHORT.parse(source);
      }
    } catch (Exception ex) {
    }
    return null;
  }
}
