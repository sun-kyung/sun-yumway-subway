package sunkyung.yumwaysubway;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
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
  static LinkedList<Order> orderList = new LinkedList<>();
  static ArrayList<Side> sideList = new ArrayList<>();
  static LinkedList<Board> boardList = new LinkedList<>();

  public static void main(String[] args) {

    loadOrderData();
    loadSideData();
    loadBoardData();
    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/order/add", new OrderAddCommand(prompt, orderList));
    commandMap.put("/order/delete", new OrderDeleteCommand(prompt, orderList));
    commandMap.put("/order/detail", new OrderDetailCommand(prompt, orderList));
    commandMap.put("/order/update", new OrderUpdateCommand(prompt, orderList));
    commandMap.put("/order/list", new OrderListCommand(orderList));

    commandMap.put("/side/add", new SideAddCommand(prompt, sideList));
    commandMap.put("/side/delete", new SideDeleteCommand(prompt, sideList));
    commandMap.put("/side/detail", new SideDetailCommand(prompt, sideList));
    commandMap.put("/side/update", new SideUpdateCommand(prompt, sideList));
    commandMap.put("/side/list", new SideListCommand(sideList));

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
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
        }
      } else if (!command.equalsIgnoreCase("quit")) {
        System.out.println("실행할 수 없는 명령입니다");
      }
    }
    keyboard.close();
    saveOrderData();
    saveSideData();
    saveBoardData();
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

  private static void loadOrderData() {
    File file = new File("./order.csv");
    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine();
          String[] data = line.split(",");

          Order order = new Order();
          order.setNo(Integer.parseInt(data[0]));
          order.setBread(data[1]);
          order.setMain(data[2]);
          order.setCheese(data[3]);
          order.setVegetable(data[4]);
          order.setSauce(data[5]);

          orderList.add(order);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 샌드위치 데이터를 로딩했습니다\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! -" + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveOrderData() {
    File file = new File("./order.csv");
    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;
      for (Order order : orderList) {
        String line = String.format("%d,%s,%s,%s,%s,%s", order.getNo(), order.getBread(),
            order.getMain(), order.getCheese(), order.getVegetable(), order.getSauce());
        out.write(line);
        count++;
      }
      System.out.printf("총 %d개의 샌드위치 데이터를 저장했습니다\n", count);
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

  private static void loadSideData() {
    File file = new File("./side.csv");
    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine();
          String[] data = line.split(",");

          Side side = new Side();
          side.setNo(Integer.parseInt(data[0]));
          side.setCookie(data[1]);
          side.setBeverage(data[2]);
          side.setOthers(data[3]);

          sideList.add(side);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 사이드 데이터를 로딩했습니다\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! -" + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveSideData() {
    File file = new File("./side.csv");
    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;
      for (Side side : sideList) {
        String line = String.format("%d,%s,%s,%s", side.getNo(), side.getCookie(),
            side.getBeverage(), side.getOthers());
        out.write(line);
        count++;
      }
      System.out.printf("총 %d개의 사이드 데이터를 저장했습니다\n", count);
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.csv");
    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine();
          String[] data = line.split(",");

          Board board = new Board();
          board.setNo(Integer.parseInt(data[0]));
          board.setTitle(data[1]);
          board.setContents(data[2]);
          board.setToday(Date.valueOf(data[3]));
          board.setViewCount(Integer.parseInt(data[4]));

          boardList.add(board);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 게시물 데이터를 로딩했습니다\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! -" + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.csv");
    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;
      for (Board board : boardList) {
        String line = String.format("%d,%s,%s,%s,%d", board.getNo(), board.getTitle(),
            board.getContents(), board.getToday(), board.getViewCount());
        out.write(line);
        count++;
      }
      System.out.printf("총 %d개의 게시물 데이터를 저장했습니다\n", count);
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }
}


