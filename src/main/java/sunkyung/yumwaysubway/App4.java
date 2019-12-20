package sunkyung.yumwaysubway;

import java.sql.Date;
import java.util.Scanner;

public class App4 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    class Board{
    String title;
    String contents;
    Date today;
    int viewCount;
    }
    
    String response;
    final int SIZE = 100;
    Board[] boards = new Board[SIZE];
    for(int i = 0; i < SIZE; i++) {
      boards[i] = new Board();
    }
    int count = 0;
    
    for(int i = 0; i < SIZE; i++) {
      Board board = boards[i];
    System.out.print("제목?");
    board.title = keyboard.nextLine();
    System.out.print("내용?");
    board.contents = keyboard.nextLine();
    board.today = new Date(System.currentTimeMillis());
    board.viewCount = 0;
    boards[i] = board;
    
    count++;
    System.out.println();
    System.out.print("계속 입력하시겠습니까? (Y/N)");
    response = keyboard.nextLine();
    if(!response.equalsIgnoreCase("Y")) {
      break;
     }
    }
    System.out.println();
    for(int i = 0; i < count; i++) {
      Board board = boards[i];
    System.out.printf("\n%s\n%s\n%s\n%s\n", board.title, board.contents, board.today, board.viewCount);
    }
    
    keyboard.close();
    
  }
}
