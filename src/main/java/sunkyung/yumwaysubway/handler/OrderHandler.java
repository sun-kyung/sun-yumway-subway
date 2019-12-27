package sunkyung.yumwaysubway.handler;

import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Order;

public class OrderHandler {

  public static final int ORDER_SIZE = 100;
  Order[] orders;
  int orderCount = 0;
  public Scanner input;
  public OrderHandler(Scanner input) {
    this.input = input;
    this.orders = new Order[ORDER_SIZE];
  }

  public void addOrder() {
    Order order = new Order();
    System.out.print("빵? ");
    order.bread = input.nextLine();

    System.out.print("메인? ");
    order.main = input.nextLine();

    System.out.print("치즈? ");
    order.cheese = input.nextLine();

    System.out.print("채소? ");
    order.vegetable = input.nextLine();

    System.out.print("소스? ");
    order.sauce = input.nextLine();
    this.orders[this.orderCount++] = order;
    System.out.println("저장하였습니다.");
  }
  public void listOrder() {

    System.out.println();
    for(int i = 0; i < this.orderCount; i++) {
      Order o = this.orders[i];
      System.out.printf("\n빵: %s\n메인: %s\n치즈: %s\n채소: %s\n소스: %s\n", 
          o.bread, o.main, o.cheese, o.vegetable, o.sauce);
    }
  }
}
