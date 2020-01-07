package sunkyung.yumwaysubway.handler;

import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.util.ArrayList;

public class OrderHandler {

  ArrayList<Order> orderList;
  public Scanner input;
  
  public OrderHandler(Scanner input) {
    this.input = input;
    orderList = new ArrayList<>();
  }
  
  public OrderHandler(Scanner input, int capacity) {
    this.input = input;
    orderList = new ArrayList<>(capacity);
  }

  public void addOrder() {
    Order order = new Order();
    System.out.print("빵? ");
    order.setBread(input.nextLine());

    System.out.print("메인? ");
    order.setMain(input.nextLine());

    System.out.print("치즈? ");
    order.setCheese(input.nextLine());

    System.out.print("채소? ");
    order.setVegetable(input.nextLine());

    System.out.print("소스? ");
    order.setSauce(input.nextLine());
    orderList.add(order);
    System.out.println("저장하였습니다.");
  }
  public void listOrder() {

    System.out.println();
    Order[] arr = orderList.toArray(new Order[this.orderList.size()]);
    for (Order o : arr) {
      System.out.printf("\n빵: %s\n메인: %s\n치즈: %s\n채소: %s\n소스: %s\n", 
          o.getBread(), o.getMain(), o.getCheese(), o.getVegetable(), o.getSauce());
    }
  }
}
