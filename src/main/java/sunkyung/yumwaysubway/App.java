package sunkyung.yumwaysubway;

import java.sql.Date;
import java.util.Scanner;
public class App {

  static class Order{
    String bread;
    String main;
    String cheese;
    String vegetable;
    String sauce;
  }
  static final int ORDER_SIZE = 100;
  static Order[] orders = new Order[ORDER_SIZE];
  static int orderCount = 0;

  static class Side{
    String cookie;
    String beverage;
    String others;
  }
  static final int SIDE_SIZE = 100;
  static Side[] sides = new Side[SIDE_SIZE];
  static int sideCount = 0;

  static class Board{
    static String title;
    static String contents;
    static Date today;
    static int viewCount;
  }
  static final int BOARD_SIZE = 100;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;

  static Scanner keyboard = new Scanner(System. in);
  public static void main(String[] args) {


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
          addOrder();
        
          break;

        case "/order/list":
          listOrder();
          break;

        case "/side/add":
          addSide();
          break;

        case "/side/list":
          listSide();
          break;

        case "/board/add":
          addBoard();
          break;

        case "/board/list":
          listBoard();
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
  private static void listBoard() {
    for(int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("\n%s\n%s\n%s\n%s\n", b.title, b.contents, b.today, b.viewCount);
    }
  }
  private static void addBoard() {
    Board board = new Board();
    System.out.print("제목?");
    board.title = keyboard.nextLine();
    System.out.print("내용?");
    board.contents = keyboard.nextLine();
    board.today = new Date(System.currentTimeMillis());
    board.viewCount = 0;
    boards[boardCount++] = board;
  }
  private static void listSide() {
    for (int i = 0; i < sideCount; i++) {
      Side s = sides[i];
      System.out.printf("%s, %s, %s\n", s.cookie, s.beverage, s.others);
    }
  }
  private static void addSide() {
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
  private static void addOrder() {
    Order order = new Order();
    System.out.print("빵? ");
    order.bread = keyboard.nextLine();

    System.out.print("메인? ");
    order.main = keyboard.nextLine();

    System.out.print("치즈? ");
    order.cheese = keyboard.nextLine();

    System.out.print("채소? ");
    order.vegetable = keyboard.nextLine();

    System.out.print("소스? ");
    order.sauce = keyboard.nextLine();
    orders[orderCount++] = order;
    System.out.println("저장하였습니다.");
  }
  private static void listOrder() {

    System.out.println();
    for(int i = 0; i < orderCount; i++) {
      Order o = orders[i];
      System.out.printf("\n빵: %s\n메인: %s\n치즈: %s\n채소: %s\n소스: %s\n", 
          o.bread, o.main, o.cheese, o.vegetable, o.sauce);
    }
  }
}
