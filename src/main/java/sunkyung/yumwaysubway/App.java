package sunkyung.yumwaysubway;

import java.util.Scanner;
import sunkyung.yumwaysubway.handler.BoardHandler;
import sunkyung.yumwaysubway.handler.OrderHandler;
import sunkyung.yumwaysubway.handler.SideHandler;
public class App {

  static Scanner keyboard = new Scanner(System. in);
  public static void main(String[] args) {
    
    OrderHandler o1 = new OrderHandler(keyboard);
    OrderHandler o2 = new OrderHandler(keyboard);
    SideHandler s1 = new SideHandler(keyboard);
    BoardHandler b1 = new BoardHandler(keyboard);


    System.out.println("프로젝트명: 맛있는 서브웨이");
    System.out.println("설명: 서브웨이 샌드위치 종류와 조합");
    System.out.println("메뉴 종류: 5");
    System.out.println("샌드위치 종류: 26");
    System.out.println("쿠키 종류: 4");
    System.out.println("랩 종류: 4");
    System.out.println("샐러드 종류: 22");
    System.out.println("그 외 사이드, 파티: 15");


    String command;
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch(command) {
        case "/order/add":
          o1.addOrder();
          break;

        case "/order/list":
          o1.listOrder();
          break;
          
        case "/order2/add":
          o2.addOrder();
          break;

        case "/order2/list":
          o2.listOrder();
          break;

        case "/side/add":
          s1.addSide();
          break;

        case "/side/list":
          s1.listSide();
          break;

        case "/board/add":
          b1.addBoard();
          break;

        case "/board/list":
          b1.listBoard();
          break;

        default: 
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    }
    while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕!");
    keyboard.close();
  }
}
