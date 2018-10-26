package top.huhuiyu.springbootmybatisbase.test;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import top.huhuiyu.springbootmybatisbase.Application;

/**
 * Spring测试
 * 
 * @author DarkKnight
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class MyTest {
  /**
   * @RunWith是junit的注解,用于配置自定义的测试启动类
   * @SpringBootTest是定义springboot类型的测试用例 classes是配置要测试的springboot启动类
   *                                     webEnvironment用于定义测试springboot的启动端口
   *                                     RANDOM_PORT表示使用随机端口
   * @LocalServerPort表示将springboot服务端口传入
   */
  @LocalServerPort
  private int port;

  private URL url;
  /**
   * TestRestTemplate是依赖注入测试模板类j
   */
  @Autowired
  private TestRestTemplate template;

  /**
   * @Before表示执行测试前要执行的代码，同一个测试用例中多个Test只会执行一次Before
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    this.url = new URL(String.format("http://127.0.0.1:%s", port));
  }

  /**
   * @Test是测试用例
   * @throws Exception
   */
  @Test
  public void test() throws Exception {
    // 通过测试模板获取url的应答结果
    ResponseEntity<String> responseEntity = this.template.getForEntity(this.url.toString(), String.class);
    String result = responseEntity.getBody();
    System.out.println(result);
  }

}
