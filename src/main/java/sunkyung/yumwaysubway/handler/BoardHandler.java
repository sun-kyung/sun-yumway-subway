package sunkyung.yumwaysubway.handler;

import java.sql.Date;
import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Board;

public class BoardHandler {
  BoardList boardList = new BoardList();
  public Scanner input;
  
  public BoardHandler(Scanner input) {
    this.input = input;
    boardList = new BoardList();
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    boardList = new BoardList(capacity);
  }

  public void listBoard() {
    Board[] boards = boardList.toArray();
    for (Board b : boards) {
      System.out.printf("\n%s\n%s\n%s\n%s\n", 
          b.getTitle(), b.getContents(), b.getToday(), b.getViewCount());
    }
  }
  public void addBoard() {
    Board board = new Board();
    System.out.print("제목?");
    board.setTitle(input.nextLine());
    System.out.print("내용?");
    board.setContents(input.nextLine());
    board.setToday(new Date(System.currentTimeMillis()));
    board.setViewCount(0);
    boardList.add(board);
  }
}
