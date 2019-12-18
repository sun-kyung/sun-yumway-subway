package sunkyung.yumwaysubway;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in);
    
    System.out.print("쿠키? ");
    String cookie = keyboard.nextLine();
    
    System.out.print("음료? ");
    String beverage = keyboard.nextLine();
    
    System.out.print("사이드? ");
    String side = keyboard.nextLine();
    
    System.out.println();

    
    System.out.printf("쿠키: %s\n", cookie);
    System.out.printf("음료: %s\n", beverage);
    System.out.printf("사이드: %s\n", side);
    
    keyboard.close();
    
  }

}
