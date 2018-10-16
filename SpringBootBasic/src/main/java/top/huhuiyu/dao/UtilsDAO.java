package top.huhuiyu.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * Utils-系统工具
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface UtilsDAO {
  /**
   * 查询系统时间
   * 
   * @return
   */
  Date queryTime();
}
