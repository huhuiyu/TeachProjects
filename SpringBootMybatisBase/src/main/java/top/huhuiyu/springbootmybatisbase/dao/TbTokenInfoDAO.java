package top.huhuiyu.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * TbTokenInfo的DAO
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenInfoDAO {
  /**
   * -删除所有过期的TokenInfo
   * 
   * @return
   * @throws Exception
   */
  int deleteTokenInfos() throws Exception;
}
