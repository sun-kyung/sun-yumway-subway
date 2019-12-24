package sunkyung.yumwaysubway.handler;

import java.sql.Date;
import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Board;

public class BoardHandler {

  public static final int BOARD_SIZE = 100;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;
  public static Scanner keyboard;

  public static void listBoard() {
    for(int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("\n%s\n%s\n%s\n%s\n", b.title, b.contents, b.today, b.viewCount);
    }
  }
  public static void addBoard() {
    Board board = new Board();
    System.out.print("제목?");
    board.title = keyboard.nextLine();
    System.out.print("내용?");
    board.contents = keyboard.nextLine();
    board.today = new Date(System.currentTimeMillis());
    board.viewCount = 0;
    boards[boardCount++] = board;
  }
}
