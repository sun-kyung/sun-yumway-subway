package sunkyung.yumwaysubway;

import java.sql.Date;
import java.util.Scanner;

public class App4 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("제목?");
    String title = keyboard.nextLine();
    System.out.print("내용?");
    String contents = keyboard.nextLine();
    
    Date today = new Date(System.currentTimeMillis());
    int count = 0;
    
    System.out.println();
    
    System.out.printf("제목: %s\n", title);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("작성일: %s\n", today);
    System.out.printf("조회수: %s\n", count);
    
    keyboard.close();
    
  }
}
