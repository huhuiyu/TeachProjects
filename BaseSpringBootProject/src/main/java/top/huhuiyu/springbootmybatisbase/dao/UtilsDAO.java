package top.huhuiyu.springbootmybatisbase.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;

/**
 * 工具类dao
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface UtilsDAO {
  /**
   * 查询数据库当前时间
   * 
   * @return 数据库当前时间
   * @throws Exception 处理发生异常
   */
  Date queryTime() throws Exception;

  /**
   * 查询token
   * 
   * @param token token信息
   * @return token信息
   * @throws Exception 处理发生异常
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * 添加token
   * 
   * @param token token信息
   * @return 添加token的结果
   * @throws Exception 处理发生异常
   */
  int addToken(TbToken token) throws Exception;

  /**
   * 更新token
   * 
   * @param token token信息
   * @return 更新token的结果
   * @throws Exception 处理发生异常
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * 删除所有过期token
   * 
   * @return 删除所有过期token的结果
   * @throws Exception 处理发生异常
   */
  int deleteTokens() throws Exception;

  /**
   * 删除所有过期的TokenInfo
   * 
   * @return 删除所有过期TokenInfo的结果
   * @throws Exception 处理发生异常
   */
  int deleteTokenInfos() throws Exception;

  /**
   * 添加图片校验码
   * 
   * @param tokenInfo 带图片校验码的tokenInfo信息
   * @return 添加图片校验码的结果
   * @throws Exception 处理发生异常
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询图片校验码
   * 
   * @param tokenInfo 带图片校验码的tokenInfo信息
   * @return 查询图片校验码的结果
   * @throws Exception 处理发生异常
   */
  TbTokenInfo queryImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 更新图片校验码
   * 
   * @param tokenInfo 带图片校验码的tokenInfo信息
   * @return 更新图片校验码的结果
   * @throws Exception 处理发生异常
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除图片校验码
   * 
   * @param tokenInfo 带图片校验码的tokenInfo信息
   * @return 删除图片校验码的结果
   * @throws Exception 处理发生异常
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;
}
