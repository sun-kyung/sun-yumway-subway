package sunkyung.yumwaysubway;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in);
    
    System.out.print("빵? ");
    String bread = keyboard.nextLine();
    
    System.out.print("메인? ");
    String main = keyboard.nextLine();
    
    System.out.print("치즈? ");
    String cheese = keyboard.nextLine();
    
    System.out.print("채소? ");
    String vegetable = keyboard.nextLine();
    
    System.out.print("소스? ");
    String sauce = keyboard.nextLine();
    
    
    System.out.println();
    
    System.out.printf("빵: %s\n", bread);
    System.out.printf("메인: %s\n", main);
    System.out.printf("치즈: %s\n", cheese);
    System.out.printf("채소: %s\n", vegetable);
    System.out.printf("소스: %s\n", sauce);
    
    keyboard.close();
    
  }

}
