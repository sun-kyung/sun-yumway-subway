package sunkyung.yumwaysubway;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in);
    int count = 0;
    String[] cookie = new String[100];
    String[] beverage = new String[100];
    String[] side = new String[100];
    String response;

    for(int i = 0; i < 5; i++) {
      System.out.print("쿠키? ");
      cookie[i] = keyboard.nextLine();

      System.out.print("음료? ");
      beverage[i] = keyboard.nextLine();

      System.out.print("사이드? ");
      side[i] = keyboard.nextLine();
      
      count++;

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }
    System.out.println();
    for (int i = 0; i < count; i++)
      System.out.printf("%s, %s, %s\n", cookie[i], beverage[i], side[i]);

    keyboard.close();
  }
}
