package top.huhuiyu.springbootmybatisbase.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 控制器日志切面
 * 
 * @author DarkKnight
 *
 */
@Aspect
@Component
public class ControllerLogger extends BaseControllerAop {

  private static final Logger log = LoggerFactory.getLogger(ControllerLogger.class);

  @Before("controller()")
  public void before(JoinPoint jp) {
    log.debug(String.format("进入===>%s", jp.getSignature()));
    Object[] args = jp.getArgs();
    if (args == null || args.length == 0) {
      log.debug("方法没有参数");
    } else {
      log.debug("参数列表：");
      for (Object arg : args) {
        log.debug(arg + "");
      }
    }
  }

  @After("controller()")
  public void after(JoinPoint jp) {
    log.debug(String.format("%s执行完毕", jp.getSignature()));
  }

  @AfterReturning(pointcut = "controller()", returning = "result")
  public void returning(JoinPoint jp, Object result) {
    log.debug(String.format("%s返回值：%s", jp.getSignature(), result));
  }

}
