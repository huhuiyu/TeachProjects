package top.huhuiyu.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.entity.TbToken;

/**
 * Token追踪 <br>
 * 如果客户端没有提供token，创建新的Token添加到数据库中，返回token给客户端 <br>
 * 如果客户端提供了token，就判断token是否在数据库中存在且没有过期（lastupdate） <br>
 * 不存在或者过期就回到新建的流程，存在就更新过期时间（lastupdate）<br>
 * 如果token对应的客户端长期不向服务器发起数据，会造成数据库资源浪费，
 * 所以要开启定时任务检查token的lastupdate，超过一定的时间就会自动清理
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * addToken-添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;

  /**
   * updateToken-更新token时间
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * queryToken-查询token是否存在
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * deleteTokens-删除过期的token
   * 
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;
}
