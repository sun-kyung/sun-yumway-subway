package sunkyung.yumwaysubway.handler;

import java.util.Scanner;
public class SideHandler {
  public static class Side{
    String cookie;
    String beverage;
    String others;
  }
  public static final int SIDE_SIZE = 100;
  static Side[] sides = new Side[SIDE_SIZE];
  static int sideCount = 0;
  public static Scanner keyboard;
  
  public static void addSide() {
    Side side = new Side();
    System.out.print("쿠키? ");
    side.cookie = keyboard.nextLine();

    System.out.print("음료? ");
    side.beverage = keyboard.nextLine();

    System.out.print("그 외? ");
    side.others = keyboard.nextLine();
    sides[sideCount++] = side;
    System.out.println("저장하였습니다.");
  }
  public static void listSide() {
    for (int i = 0; i < sideCount; i++) {
      Side s = sides[i];
      System.out.printf("%s, %s, %s\n", s.cookie, s.beverage, s.others);
    }
  }
}
