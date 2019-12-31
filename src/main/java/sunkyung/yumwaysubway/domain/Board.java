package sunkyung.yumwaysubway.domain;

import java.sql.Date;

public class Board {
  private String title;
  private String contents;
  private Date today;
  private int viewCount;
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getToday() {
    return today;
  }
  public void setToday(Date today) {
    this.today = today;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

}
