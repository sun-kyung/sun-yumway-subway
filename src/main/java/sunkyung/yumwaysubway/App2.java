package sunkyung.yumwaysubway;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in);
    

    class Order{
    String bread;
    String main;
    String cheese;
    String vegetable;
    String sauce;
    }

    String response;
    final int SIZE = 100;
    Order[] orders = new Order[SIZE];
    for(int i = 0; i < SIZE; i++) {
      orders[i] = new Order();
    }
    int count = 0;
    
    for(int i = 0; i < SIZE; i++) {
      Order order = orders[i];
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
      orders[i] = order;

      count++;
      System.out.println();
      System.out.println("계속 입력하시겠습니까? (Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }


    System.out.println();
    for(int i = 0; i < count; i++) {
      Order order = orders[i];
      System.out.printf("\n빵: %s\n메인: %s\n치즈: %s\n채소: %s\n소스: %s\n", 
          order.bread, order.main, order.cheese, order.vegetable, order.sauce);
    }
    keyboard.close();
  }
}
