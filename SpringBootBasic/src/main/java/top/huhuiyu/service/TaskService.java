package top.huhuiyu.service;

import org.springframework.scheduling.annotation.Scheduled;

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

  void deleteTokens();
}
