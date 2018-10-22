package top.huhuiyu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 控制器日志切面处理(aop-面向切面编程) Aspect表示申明为切面类,Component是spring组件
 * 
 * @author DarkKnight
 *
 */
@Aspect
@Component
public class ControllerLogger {
  /**
   * pointcut是切面的表达式，表示切面类拦截的class<br>
   * execution是执行的意思，参数是切面表达式<br>
   * public * 表示必须是public类型的才会被拦截<br>
   * top.huhuiyu.controller是包名称<br>
   * ..表示无限层级,第一个*号是类名称，表示任意类名称都会被拦截<br>
   * 第二个*号是方法名称，表示任意方法都会拦截，如果写成get*则表示只有get开头的方法才会被拦截<br>
   * (..)表示任意参数
   */
  @Pointcut("execution(public * top.huhuiyu.controller..*.*(..))")
  public void pointcut() {
  }

  private static final Logger log = LoggerFactory.getLogger(ControllerLogger.class);

  /**
   * Before是前置拦截，在执行切面拦截的方法之前会执行
   * 
   * @param jp 被切面拦截的方法信息
   */
  @Before("pointcut()")
  public void before(JoinPoint jp) {
    // getSignature方法会返回切点拦截的方法签名
    log.debug("将要执行：" + jp.getSignature());
    // getArgs方法是获取被拦截的方法的参数列表
    StringBuilder argsInfo = new StringBuilder();
    Object[] args = jp.getArgs();
    if (args == null || args.length == 0) {
      log.debug("没有参数");
    } else {
      argsInfo.append("参数列表信息：").append("\r\n");
      for (Object arg : args) {
        argsInfo.append(arg).append("\r\n");
      }
      log.debug(argsInfo.toString());
    }
  }

  /**
   * After表示切点方法执行完之后
   * 
   * @param jp
   */
  @After("pointcut()")
  public void after(JoinPoint jp) {
    log.debug("执行的" + jp.getSignature() + "完毕！");
  }

  /**
   * AfterReturning表示切点返回后，所以要多一个参数returning来获取方法的返回值
   * 
   * @param jp
   * @param result
   */
  @AfterReturning(pointcut = "pointcut()", returning = "result")
  public void returning(JoinPoint jp, Object result) {
    log.debug(String.format("%s的返回值%s", jp.getSignature(), result));
  }

//  @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
//  public void returning(JoinPoint jp, Throwable ex) {
//    log.debug(String.format("%s发生错误%s", jp.getSignature(), ex));
//  }

}
