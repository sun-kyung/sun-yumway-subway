package sunkyung.yumwaysubway;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.handler.BoardAddCommand;
import sunkyung.yumwaysubway.handler.BoardDeleteCommand;
import sunkyung.yumwaysubway.handler.BoardDetailCommand;
import sunkyung.yumwaysubway.handler.BoardListCommand;
import sunkyung.yumwaysubway.handler.BoardUpdateCommand;
import sunkyung.yumwaysubway.handler.Command;
import sunkyung.yumwaysubway.handler.OrderAddCommand;
import sunkyung.yumwaysubway.handler.OrderDeleteCommand;
import sunkyung.yumwaysubway.handler.OrderDetailCommand;
import sunkyung.yumwaysubway.handler.OrderListCommand;
import sunkyung.yumwaysubway.handler.OrderUpdateCommand;
import sunkyung.yumwaysubway.handler.SideAddCommand;
import sunkyung.yumwaysubway.handler.SideDeleteCommand;
import sunkyung.yumwaysubway.handler.SideDetailCommand;
import sunkyung.yumwaysubway.handler.SideListCommand;
import sunkyung.yumwaysubway.handler.SideUpdateCommand;
import sunkyung.yumwaysubway.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {
    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    LinkedList<Order> orderList = new LinkedList<>();
    commandMap.put("/order/add", new OrderAddCommand(prompt, orderList));
    commandMap.put("/order/delete", new OrderDeleteCommand(prompt, orderList));
    commandMap.put("/order/detail", new OrderDetailCommand(prompt, orderList));
    commandMap.put("/order/update", new OrderUpdateCommand(prompt, orderList));
    commandMap.put("/order/list", new OrderListCommand(orderList));

    ArrayList<Side> sideList = new ArrayList<>();
    commandMap.put("/side/add", new SideAddCommand(prompt, sideList));
    commandMap.put("/side/delete", new SideDeleteCommand(prompt, sideList));
    commandMap.put("/side/detail", new SideDetailCommand(prompt, sideList));
    commandMap.put("/side/update", new SideUpdateCommand(prompt, sideList));
    commandMap.put("/side/list", new SideListCommand(sideList));

    LinkedList<Board> boardList = new LinkedList<>();
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));


    System.out.println("프로젝트명: 맛있는 서브웨이");
    System.out.println("설명: 서브웨이 샌드위치 종류와 조합");
    System.out.println("메뉴 종류: 5");
    System.out.println("샌드위치 종류: 26");
    System.out.println("쿠키 종류: 4");
    System.out.println("랩 종류: 4");
    System.out.println("샐러드 종류: 22");
    System.out.println("그 외 사이드, 파티: 15");


    String command;
    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      commandStack.push(command);
      commandQueue.offer(command);
      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        commandHandler.execute();
      } else if (!command.equalsIgnoreCase("quit")) {
        System.out.println("실행할 수 없는 명령입니다");
      }
    }
    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;
      if ((count % 5) == 0) {
        System.out.println(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}


