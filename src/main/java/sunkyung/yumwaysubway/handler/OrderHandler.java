package sunkyung.yumwaysubway.handler;

import java.util.Scanner;

public class OrderHandler {
  public static class Order{
    String bread;
    String main;
    String cheese;
    String vegetable;
    String sauce;
  }
  public static final int ORDER_SIZE = 100;
  static Order[] orders = new Order[ORDER_SIZE];
  static int orderCount = 0;
  public static Scanner keyboard;

  public static void addOrder() {
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
  public static void listOrder() {

    System.out.println();
    for(int i = 0; i < orderCount; i++) {
      Order o = orders[i];
      System.out.printf("\n빵: %s\n메인: %s\n치즈: %s\n채소: %s\n소스: %s\n", 
          o.bread, o.main, o.cheese, o.vegetable, o.sauce);
    }
  }
}
