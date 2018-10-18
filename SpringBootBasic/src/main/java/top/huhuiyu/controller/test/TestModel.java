package top.huhuiyu.controller.test;

import top.huhuiyu.model.BaseModel;

/**
 * TestModel-测试用的model层，model层可以组合不同的数据传输，以适配页面不同的数据模型
 * 
 * @author DarkKnight
 *
 */
public class TestModel extends BaseModel {

  private static final long serialVersionUID = 4734230327560640256L;

  /**
   * model层定义的对象数据，可以直接new创建出来，可以减少null值判断
   */
  private TestEntity entity = new TestEntity();

  public TestModel() {
  }

  public TestEntity getEntity() {
    return entity;
  }

  public void setEntity(TestEntity entity) {
    this.entity = entity;
  }

}
