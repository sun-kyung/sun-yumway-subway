package sunkyung.yumwaysubway;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import sunkyung.yumwaysubway.context.ApplicationContextListener;
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

  Scanner keyboard = new Scanner(System.in);
  Deque<String> commandStack = new ArrayDeque<>();
  Queue<String> commandQueue = new LinkedList<>();
  List<Order> orderList = new ArrayList<>();
  List<Side> sideList = new ArrayList<>();
  List<Board> boardList = new ArrayList<>();

  Set<ApplicationContextListener> listeners = new HashSet<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized();
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }

  public void service() {

    notifyApplicationInitialized();

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

    notifyApplicationDestroyed();
  }

  private void printCommandHistory(Iterator<String> iterator) {
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

  @SuppressWarnings("unchecked")
  private void loadOrderData() {
    File file = new File("./order.ser");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      orderList = (List<Order>) in.readObject();
      System.out.printf("총 %d개의 샌드위치 데이터를 로딩했습니다\n", orderList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! -" + e.getMessage());
    }
  }

  private void saveOrderData() {
    File file = new File("./order.ser");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(orderList);
      System.out.printf("총 %d개의 샌드위치 데이터를 저장했습니다\n", orderList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadSideData() {
    File file = new File("./side.ser");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      sideList = (List<Side>) in.readObject();

      System.out.printf("총 %d개의 사이드 데이터를 로딩했습니다\n", sideList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! -" + e.getMessage());
    }
  }

  private void saveSideData() {
    File file = new File("./side.ser");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(sideList);
      System.out.printf("총 %d개의 사이드 데이터를 저장했습니다\n", sideList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      boardList = (List<Board>) in.readObject();
      System.out.printf("총 %d개의 게시물 데이터를 로딩했습니다\n", boardList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! -" + e.getMessage());
    }
  }

  private void saveBoardData() {
    File file = new File("./board.ser");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(boardList);
      System.out.printf("총 %d개의 게시물 데이터를 저장했습니다\n", boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    App app = new App();
    app.service();
  }
}


