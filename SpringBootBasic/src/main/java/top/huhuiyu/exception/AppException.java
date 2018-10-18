package top.huhuiyu.exception;

/**
 * AppException-应用程序自定义异常（需要指定code和message）
 * 
 * @author DarkKnight
 *
 */
public class AppException extends Exception {
  private int code = 500;

  private static final long serialVersionUID = 2435323954031151166L;

  public AppException(int code, String message) {
    super(message);
    this.code = code;
  }

  public static AppException getAppException(int code, String message) {
    return new AppException(code, message);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

}
