package top.huhuiyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * springboot启动类
 * EnableScheduling注解是开启定时任务
 * @author DarkKnight
 *
 */
@SpringBootApplication
@EnableScheduling
public class Application {
  public static void main(String[] args) {
    // 启动springboot应用
    SpringApplication.run(Application.class, args);
    // http://127.0.0.1:8080

  }
}
