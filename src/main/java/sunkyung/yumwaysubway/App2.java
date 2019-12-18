package sunkyung.yumwaysubway;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in);

    int count = 0;
    String[] bread = new String[100];
    String[] main = new String[100];
    String[] cheese = new String[100];
    String[] vegetable = new String[100];
    String[] sauce = new String[100];
    String response;

    for(int i = 0; i < 5; i++) {
      System.out.print("빵? ");
      bread[i] = keyboard.nextLine();

      System.out.print("메인? ");
      main[i] = keyboard.nextLine();

      System.out.print("치즈? ");
      cheese[i] = keyboard.nextLine();

      System.out.print("채소? ");
      vegetable[i] = keyboard.nextLine();

      System.out.print("소스? ");
      sauce[i] = keyboard.nextLine();

      count++;
      System.out.println();
      System.out.println("계속 입력하시겠습니까? (Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }


    System.out.println();
    for(int i = 0; i < count; i++)
      System.out.printf("\n빵: %s\n메인: %s\n치즈: %s\n채소: %s\n소스: %s\n", 
          bread[i], main[i], cheese[i], vegetable[i], sauce[i]);

    keyboard.close();

  }

}
