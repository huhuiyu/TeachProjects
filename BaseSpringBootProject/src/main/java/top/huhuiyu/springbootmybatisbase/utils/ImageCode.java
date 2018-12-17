package top.huhuiyu.springbootmybatisbase.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 图片校验码工具
 *
 * @author DarkKnight
 *
 */
public class ImageCode {
  private static final String CODES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final Font FONT = new Font(null, Font.BOLD | Font.ITALIC, 28);
  private static final Random RANDOM = new Random();
  private static final int LENGTH = 5;
  private static final int MAX_LENGTH = 10;
  private static final int AMOUNT = 20;

  private static final FontMetrics FONT_METRICS;
  static {
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics graphics = image.getGraphics();
    graphics.setFont(FONT);
    FONT_METRICS = graphics.getFontMetrics();
  }

  /**
   * 生成默认长度的随机字符
   *
   * @return 默认长度的随机字符
   */
  public static String makeCode() {
    return makeCode(LENGTH);
  }

  /**
   * 生成指定长度的随机字符
   *
   * @param length 随机字符长度
   * @return 指定长度的随机字符
   */
  public static String makeCode(int length) {
    length = length < LENGTH ? LENGTH : length;
    length = length > MAX_LENGTH ? MAX_LENGTH : length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      sb.append(CODES.charAt(RANDOM.nextInt(CODES.length())));
    }
    return sb.toString();
  }

  /**
   * 绘制code对应的图片
   *
   * @param code 图片code
   * @return code对应的图片
   */
  public static BufferedImage makeImage(String code) {
    // 绘图高度
    int height = FONT_METRICS.getHeight();
    // 绘图宽度
    int width = FONT_METRICS.stringWidth(code);
    int ascent = FONT_METRICS.getMaxAscent();

    // 创建内存图片
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics();
    graphics.setFont(FONT);
    // 绘制背景颜色
    graphics.setColor(Color.YELLOW);
    graphics.fillRect(0, 0, width, height);
    // 绘制文字
    graphics.setColor(Color.BLUE);
    graphics.drawString(code, 0, (FONT_METRICS.getHeight() / 2 + ascent / 2 - 2));
    // 绘制干扰线
    graphics.setColor(Color.BLACK);
    for (int i = 0; i < AMOUNT; i++) {
      int startx = RANDOM.nextInt(width);
      int starty = RANDOM.nextInt(height);
      int endx = RANDOM.nextInt(width);
      int endy = RANDOM.nextInt(height);
      graphics.drawLine(startx, starty, endx, endy);
    }
    return image;
  }

}
