package top.huhuiyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.entity.TbToken;

/**
 * TestDAO-测试用的mapper
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TestDAO {
  /**
   * TbToken的分页查询
   * @return
   * @throws Exception
   */
  List<TbToken> queryTokens() throws Exception;
}
