package sunkyung.yumwaysubway.handler;

import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Side;
public class SideHandler {

  ArrayList sideList;
  public Scanner input;
  
  public SideHandler(Scanner input) {
    this.input = input;
    sideList = new ArrayList();
  }
  public SideHandler(Scanner input, int capacity) {
    this.input = input;
    sideList = new ArrayList(capacity);
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
    Object[] arr = sideList.toArray();
    for (Object obj : arr) {
      Side s = (Side)obj;
      System.out.printf("%s, %s, %s\n", s.getCookie(), s.getBeverage(), s.getOthers());
    }
  }
}
