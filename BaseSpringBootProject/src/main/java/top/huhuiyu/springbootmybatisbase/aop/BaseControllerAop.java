package top.huhuiyu.springbootmybatisbase.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 控制器切点定义
 * 
 * @author DarkKnight
 *
 */
public abstract class BaseControllerAop {

  @Pointcut("execution(public * top.huhuiyu.springbootmybatisbase.controller..*.*(..))")
  public void controller() {
  }

}
