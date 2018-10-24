package top.huhuiyu.springbootmybatisbase.utils;

import com.github.pagehelper.Page;

import top.huhuiyu.springbootmybatisbase.base.BaseEntity;

/**
 * -分页信息
 * 
 * @author DarkKnight
 *
 */
public class PageBean extends BaseEntity {

  private static final long serialVersionUID = -2736869221982512811L;
  private int pageSize = 10;
  private int pageNumber = 1;
  private int pageCount = 0;
  private long total = 0;

  public PageBean() {
  }

  /**
   * -设置分页信息
   * 
   * @param page
   */
  public void setPageInfo(Page<?> page) {
    pageCount = page.getPages();
    pageNumber = page.getPageNum();
    pageSize = page.getPageSize();
    total = page.getTotal();
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

}
