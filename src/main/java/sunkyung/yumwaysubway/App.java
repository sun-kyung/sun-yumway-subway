package sunkyung.yumwaysubway;

import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.handler.BoardHandler;
import sunkyung.yumwaysubway.handler.OrderHandler;
import sunkyung.yumwaysubway.handler.SideHandler;
import sunkyung.yumwaysubway.util.ArrayList;
import sunkyung.yumwaysubway.util.LinkedList;
import sunkyung.yumwaysubway.util.Prompt;
import sunkyung.yumwaysubway.util.Queue;
import sunkyung.yumwaysubway.util.Stack;
public class App {

  static Scanner keyboard = new Scanner(System. in);
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();
  
  public static void main(String[] args) {
    Prompt prompt = new Prompt(keyboard);
    
    LinkedList<Order> orderList = new LinkedList<>();
    OrderHandler o1 = new OrderHandler(prompt, orderList);
    
    ArrayList<Side> sideList = new ArrayList<>();
    SideHandler s1 = new SideHandler(prompt, sideList);
    
    LinkedList<Board> boardList = new LinkedList<>();
    BoardHandler b1 = new BoardHandler(prompt, boardList);


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
      if (command.length() == 0)
        continue;
      
      commandStack.push(command);
      commandQueue.offer(command);

      switch(command) {
        case "/order/add":
          o1.addOrder();
          break;

        case "/order/list":
          o1.listOrder();
          break;
          
        case "/order/delete":
          o1.deleteOrder();
          break;
          
        case "/order/detail":
          o1.detailOrder();
          break;
          
        case "/order/update":
          o1.updateOrder();
          break;

        case "/side/add":
          s1.addSide();
          break;

        case "/side/list":
          s1.listSide();
          break;
          
        case "/side/detail":
          s1.detailSide();
          break;
          
        case "/side/delete":
          s1.deleteSide();
          break;
          
        case "/side/update":
          s1.updateSide();
          break;

        case "/board/add":
          b1.addBoard();
          break;

        case "/board/list":
          b1.listBoard();
          break;
          
        case "/board/detail":
          b1.detailBoard();
          break;
          
        case "/board/delete":
          b1.deleteBoard();
          break;
          
        case "/board/update":
          b1.updateBoard();
          break;
          
        case "history":
          printCommandHistory();
          break;
          
        case "history2":
          printCommandHistory2();
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

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;
    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());
      if((++count % 5) == 0) {
        System.out.println(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  private static void printCommandHistory() {
    Stack<String> historyStack = (Stack<String>)commandStack.clone();
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;
      if((count % 5) == 0) {
        System.out.println(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}














