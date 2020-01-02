package sunkyung.yumwaysubway.handler;

import java.sql.Date;
import java.util.Scanner;
import sunkyung.yumwaysubway.domain.Board;

public class BoardHandler {
  ArrayList boardList;
  public Scanner input;
  
  public BoardHandler(Scanner input) {
    this.input = input;
    boardList = new ArrayList();
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    boardList = new ArrayList(capacity);
  }

  public void listBoard() {
    Object[] arr = this.boardList.toArray();
    for (Object obj : arr) {
      Board b = (Board)obj;
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
