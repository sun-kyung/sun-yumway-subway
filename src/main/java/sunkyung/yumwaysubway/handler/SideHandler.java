package sunkyung.yumwaysubway.handler;

import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.util.ArrayList;
public class SideHandler {

  ArrayList<Side> sideList;
  public Scanner input;
  
  public SideHandler(Scanner input) {
    this.input = input;
    sideList = new ArrayList<>();
  }
  public SideHandler(Scanner input, int capacity) {
    this.input = input;
    sideList = new ArrayList<>(capacity);
  }
  
  public void addSide() {
    Side side = new Side();
    System.out.print("쿠키? ");
    side.setCookie(input.nextLine());

    System.out.print("음료? ");
    side.setBeverage(input.nextLine());

    System.out.print("그 외? ");
    side.setOthers(input.nextLine());
    sideList.add(side);
    System.out.println("저장하였습니다.");
  }
  public void listSide() {
    Side[] arr = this.sideList.toArray(new Side[] {});
    for (Side s : arr) {
      System.out.printf("%s, %s, %s\n", s.getCookie(), s.getBeverage(), s.getOthers());
    }
  }
}
