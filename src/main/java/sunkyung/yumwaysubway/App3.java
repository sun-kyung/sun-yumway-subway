package sunkyung.yumwaysubway;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in);
    
    class Side{
    String cookie;
    String beverage;
    String others;
    }

    String response;
    final int SIZE = 100;
    Side[] sides = new Side[SIZE];
    for(int i = 0; i < SIZE; i++) {
      sides[i] = new Side();
    }
    int count = 0;
      
      
    for(int i = 0; i < SIZE; i++) {
      Side side = sides[i];
      System.out.print("쿠키? ");
      side.cookie = keyboard.nextLine();

      System.out.print("음료? ");
      side.beverage = keyboard.nextLine();

      System.out.print("그 외? ");
      side.others = keyboard.nextLine();
      
      sides[i] = side;
      count++;

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }
    System.out.println();
    for (int i = 0; i < count; i++) {
      Side side = sides[i];
      System.out.printf("%s, %s, %s\n", side.cookie, side.beverage, side.others);
    }

    keyboard.close();
  }
}
