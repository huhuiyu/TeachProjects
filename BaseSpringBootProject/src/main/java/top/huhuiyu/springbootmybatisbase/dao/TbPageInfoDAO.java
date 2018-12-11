package top.huhuiyu.springbootmybatisbase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbPageInfo;

/**
 * TbPageInfo数据访问类
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbPageInfoDAO {
  /**
   * -查询数据
   * 
   * @return TbPageInfo数据集
   * @throws Exception 查询发生错误
   */
  List<TbPageInfo> queryAll() throws Exception;

  /**
   * -按照主键查询
   * 
   * @param tbPageInfo 主键信息
   * @return 查询结果
   * @throws Exception 查询发生错误
   */
  TbPageInfo queryByKey(TbPageInfo tbPageInfo) throws Exception;

  /**
   * -添加TbPageInfo
   * 
   * @param tbPageInfo 添加信息
   * @return 数据库影响行数
   * @throws Exception 添加发生错误
   */
  int add(TbPageInfo tbPageInfo) throws Exception;

  /**
   * -修改TbPageInfo
   * 
   * @param tbPageInfo 修改数据
   * @return 数据库影响行数
   * @throws Exception 修改发生错误
   */
  int modify(TbPageInfo tbPageInfo) throws Exception;

  /**
   * -删除TbPageInfo
   * 
   * @param tbPageInfo 删除数据
   * @return 数据库影响行数
   * @throws Exception 删除发生错误
   */
  int delete(TbPageInfo tbPageInfo) throws Exception;

}
