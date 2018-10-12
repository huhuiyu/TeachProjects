package top.huhuiyu.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * mvc配置
 * 
 * @author DarkKnight
 *
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // 跨域配置
    WebMvcConfigurer.super.addCorsMappings(registry);
    // addMapping表示添加跨域的url映射，
    // /**表示所有的页面都支持跨域，一般会配置业务处理的url，而非全部
    // allowedMethods表示允许的http事件（POST，GET，DELETE...）
    // allowedOrigins表示允许跨域的域名，生产环境中一定会配置成限定的域名
    // 比如前端域名是huhuiyu.top，而springboot后端域名为api.huhuiyu.top
    // 那么应该允许的域名应该配置成huhuiyu.top，或者相对危险的*.huhuiyu.top
    // allowCredentials表示是否需要开启认证
    registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowCredentials(false);
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //使用FastJson作为json数据的转换器
    WebMvcConfigurer.super.configureMessageConverters(converters);
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    //TODO 这里需要配置json转换的细节
    converters.add(0, converter);
  }
}
