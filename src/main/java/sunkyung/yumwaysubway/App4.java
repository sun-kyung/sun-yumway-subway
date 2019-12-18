package sunkyung.yumwaysubway;

import java.sql.Date;
import java.util.Scanner;

public class App4 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    int count = 0;
    String[] title = new String[100];
    String[] contents = new String[100];
    Date[] today = new Date[100];
    int[] viewCount = new int[100];
    String response;
    
    for(int i = 0; i < 5; i++) {
    System.out.print("제목?");
    title[i] = keyboard.nextLine();
    System.out.print("내용?");
    contents[i] = keyboard.nextLine();
    today[i] = new Date(System.currentTimeMillis());
    viewCount[i] = 0;
    
    count++;
    System.out.println();
    System.out.print("계속 입력하시겠습니까? (Y/N)");
    response = keyboard.nextLine();
    if(!response.equalsIgnoreCase("Y")) {
      break;
     }
    }
    System.out.println();
    for(int i = 0; i < count; i++)
    System.out.printf("\n%s\n%s\n%s\n%s\n", title[i], contents[i], today[i], viewCount[i]);
    // 제목, 내용, 작성일, 조회수 순
    
    keyboard.close();
    
  }
}
