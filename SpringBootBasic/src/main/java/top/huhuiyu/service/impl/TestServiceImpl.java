package top.huhuiyu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.huhuiyu.dao.TestDAO;
import top.huhuiyu.entity.JsonMessage;
import top.huhuiyu.entity.TbToken;
import top.huhuiyu.service.TestService;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {

  @Autowired
  private TestDAO testDAO;

  @Override
  public JsonMessage queryTokens() throws Exception {
    // 查询前设置分页参数（第几页，每页记录数）
    PageHelper.startPage(1, 5);
    // 查询结果可以返回为Page（带分页的List集合扩展，也就是Page<>和List<>可以互换）
    Page<TbToken> pages = (Page<TbToken>) testDAO.queryTokens();
    List<TbToken> list = testDAO.queryTokens();
    // 获取到分页的信息
    JsonMessage json = JsonMessage.getSuccess("");
    Map<String, Object> datas = json.getDatas();
    // 分页查询集
    datas.put("pages", pages);
    // 原始查询集
    datas.put("list", list);
    // 总记录数
    datas.put("total", pages.getTotal());
    return json;
  }

}
