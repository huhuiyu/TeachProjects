package top.huhuiyu.springbootmybatisbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfig自定义配置属性配置
 * 
 * @author DarkKnight
 *
 */
@Configuration
public class MyConfig {
  /**
   * MyConfig读取配置文件中的app.name到appName
   */
  @Value("${app.name}")
  public String appName;
}
