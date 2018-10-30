package top.huhuiyu.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -测试的dao
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TestDAO {

  /**
   * -添加tokeninfo
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addTokenInfo(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;
}
