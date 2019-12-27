package sunkyung.yumwaysubway.handler;

import java.sql.Date;
import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Board;

public class BoardHandler {

  public static final int BOARD_SIZE = 100;
  Board[] boards;
  int boardCount = 0;
  public Scanner input;
  
  public BoardHandler(Scanner input) {
    this.boards = new Board[BOARD_SIZE];
    this.input = input;
  }

  public void listBoard() {
    for(int i = 0; i < this.boardCount; i++) {
      Board b = this.boards[i];
      System.out.printf("\n%s\n%s\n%s\n%s\n", b.title, b.contents, b.today, b.viewCount);
    }
  }
  public void addBoard() {
    Board board = new Board();
    System.out.print("제목?");
    board.title = input.nextLine();
    System.out.print("내용?");
    board.contents = input.nextLine();
    board.today = new Date(System.currentTimeMillis());
    board.viewCount = 0;
    this.boards[this.boardCount++] = board;
  }
}
