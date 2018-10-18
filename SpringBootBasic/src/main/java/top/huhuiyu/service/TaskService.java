package top.huhuiyu.service;

/**
 * 系统定时任务服务类
 * @author DarkKnight
 *
 */
public interface TaskService {
  
  /**
   * 定时显示当前时间
   */
  void showTime();

  /**
   * 固定时间点执行
   */
  void showTimeOnce();

  /**
   * 删除所有过期的token
   */
  void deleteTokens();
}
