package top.huhuiyu.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.springbootmybatisbase.dao.TbTokenInfoDAO;
import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;
import top.huhuiyu.springbootmybatisbase.model.UtilModel;
import top.huhuiyu.springbootmybatisbase.service.UtilService;
import top.huhuiyu.springbootmybatisbase.utils.ImageCode;
import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  @Override
  public String makeImageCode(UtilModel model) throws Exception {
    // 产生图片校验码
    String code = ImageCode.makeCode();
    // 获取token信息
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    // 判断图片校验码是否存在
    TbTokenInfo sinfo = tbTokenInfoDAO.queryImageCode(tokenInfo);
    if (sinfo == null) {
      // 不存在就将图片code写入
      tokenInfo.setInfo(code);
      tbTokenInfoDAO.addImageCode(tokenInfo);
    } else {
      // 存在就更新图片code
      sinfo.setInfo(code);
      tbTokenInfoDAO.updateImageCode(sinfo);
    }
    return code;
  }

  @Override
  public boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception {
    // code不存在就返回false
    if (MyUtils.isEmpty(tokenInfo.getInfo())) {
      return false;
    }
    // 获取数据库中code
    TbTokenInfo sinfo = tbTokenInfoDAO.queryImageCode(tokenInfo);
    if (sinfo == null) {
      // 不存在就返回false
      return false;
    }
    // 删除数据库中的code（只能使用一次）
    tbTokenInfoDAO.deleteImageCode(sinfo);
    // 返回数据库中code和传入的code比对结果
    return sinfo.getInfo().equalsIgnoreCase(tokenInfo.getInfo());
  }

}
