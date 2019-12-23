package sunkyung.yumwaysubway;

import java.sql.Date;
import java.util.Scanner;

public class BoardHandler {
  static class Board{
    static String title;
    static String contents;
    static Date today;
    static int viewCount;
  }
  static final int BOARD_SIZE = 100;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;
  static Scanner keyboard;

  static void listBoard() {
    for(int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("\n%s\n%s\n%s\n%s\n", b.title, b.contents, b.today, b.viewCount);
    }
  }
  static void addBoard() {
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
