package top.huhuiyu.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * json统一应答格式（只要是数据应答都是用该格式）
 * 
 * @author DarkKnight
 *
 */
public class JsonMessage extends EntityBase {

  private static final long serialVersionUID = 6263151224945333453L;
  /**
   * code:服务器应答代码，200为正确，500为错误，其它为自定义，默认500
   */
  private int code = 500;
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
   * getMessage：静态工厂方法，获取一个JsonMessage的实例
   * 
   * @param success 是否成功应答
   * @param code    服务器应答code
   * @param message 服务器应答信息
   * @return
   */
  public static JsonMessage getMessage(boolean success, int code, String message) {
    JsonMessage json = new JsonMessage();
    json.setCode(code);
    json.setSuccess(success);
    json.setMessage(message);
    return json;
  }

  /**
   * getSuccess：委托方法，获取成功的应答
   * 
   * @param message 成功的消息
   * @return
   */
  public static JsonMessage getSuccess(String message) {
    // 成功应答的success为ture，code为200
    return JsonMessage.getMessage(true, 200, message);
  }

  /**
   * getFail：委托方法，获取指定错误code的失败应答
   * 
   * @param code
   * @param message
   * @return
   */
  public static JsonMessage getFail(int code, String message) {
    // 指定code的错误应答
    return JsonMessage.getMessage(false, code, message);
  }

  /**
   * getFail：错误应答的委托方法
   * 
   * @param message
   * @return
   */
  public static JsonMessage getFail(String message) {
    return JsonMessage.getMessage(false, 500, message);
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
