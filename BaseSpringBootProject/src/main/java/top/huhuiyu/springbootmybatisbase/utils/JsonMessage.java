package top.huhuiyu.springbootmybatisbase.utils;

import java.util.HashMap;
import java.util.Map;

import top.huhuiyu.springbootmybatisbase.base.BaseEntity;

/**
 * json统一应答格式（只要是数据应答都是用该格式）
 * 
 * @author DarkKnight
 *
 */
public class JsonMessage extends BaseEntity {

  private static final long serialVersionUID = 6263151224945333453L;
  public static final int OK = 200;
  public static final int ERROR = 500;
  /**
   * code:服务器应答代码，200为正确，500为错误，其它为自定义，默认500
   */
  private int code = ERROR;
  /**
   * message：服务器应答信息，默认为空
   */
  private String message = "";
  /**
   * datas：服务器应答数据的集合
   */
  private Map<String, Object> datas = new HashMap<>();
  /**
   * success：服务器是否正确应答，默认为false
   */
  private boolean success = false;

  /**
   * 服务器token信息
   */
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * 静态工厂方法，获取一个JsonMessage的实例
   * 
   * @param success 是否成功应答
   * @param code    服务器应答code
   * @param message 服务器应答信息
   * @return JsonMessage的实例
   */
  public static JsonMessage getMessage(boolean success, int code, String message) {
    JsonMessage json = new JsonMessage();
    json.setCode(code);
    json.setSuccess(success);
    json.setMessage(message);
    return json;
  }

  /**
   * 委托方法，获取成功的应答
   * 
   * @param message 成功的消息
   * @return JsonMessage的实例
   */
  public static JsonMessage getSuccess(String message) {
    // 成功应答的success为ture，code为200
    return JsonMessage.getMessage(true, OK, message);
  }

  /**
   * 委托方法，获取指定错误code的失败应答
   * 
   * @param code    错误代码
   * @param message 错误消息
   * @return JsonMessage的实例
   */
  public static JsonMessage getFail(int code, String message) {
    // 指定code的错误应答
    return JsonMessage.getMessage(false, code, message);
  }

  /**
   * 错误应答的委托方法
   * 
   * @param message 错误消息
   * @return JsonMessage的实例
   */
  public static JsonMessage getFail(String message) {
    return JsonMessage.getMessage(false, ERROR, message);
  }

  /**
   * 放置应答数据
   * 
   * @param key  应答key
   * @param data 应答数据
   * @return 当前实例
   */
  public JsonMessage putData(String key, Object data) {
    datas.put(key, data);
    return this;
  }

  public JsonMessage() {
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getDatas() {
    return datas;
  }

  public void setDatas(Map<String, Object> datas) {
    this.datas = datas;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

}
