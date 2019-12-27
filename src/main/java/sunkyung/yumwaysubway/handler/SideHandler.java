package sunkyung.yumwaysubway.handler;

import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Side;
public class SideHandler {

  public static final int SIDE_SIZE = 100;
  Side[] sides;
  int sideCount = 0;
  public Scanner input;
  
  public SideHandler(Scanner input) {
    this.input = input;
    this.sides = new Side[SIDE_SIZE];
  }
  
  public void addSide() {
    Side side = new Side();
    System.out.print("쿠키? ");
    side.cookie = input.nextLine();

    System.out.print("음료? ");
    side.beverage = input.nextLine();

    System.out.print("그 외? ");
    side.others = input.nextLine();
    this.sides[this.sideCount++] = side;
    System.out.println("저장하였습니다.");
  }
  public void listSide() {
    for (int i = 0; i < this.sideCount; i++) {
      Side s = this.sides[i];
      System.out.printf("%s, %s, %s\n", s.cookie, s.beverage, s.others);
    }
  }
}
