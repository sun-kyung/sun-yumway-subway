package sunkyung.yumwaysubway.handler;

import java.sql.Date;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.util.LinkedList;
import sunkyung.yumwaysubway.util.Prompt;

public class BoardHandler {
  LinkedList<Board> boardList;
  public Prompt prompt;
  
  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
    boardList = new LinkedList<>();
  }

  public void addBoard() {
    Board board = new Board();
    board.setNo(prompt.inputInt("번호?"));
    board.setTitle(prompt.inputString("제목?"));
    board.setContents(prompt.inputString("내용?"));
    board.setToday(new Date(System.currentTimeMillis()));
    board.setViewCount(0);
    boardList.add(board);
    System.out.println("저장했습니다");
  }

  public void listBoard() {
    Board[] arr = new Board[this.boardList.size()];
    this.boardList.toArray(arr);
    for (Board b : arr) {
      System.out.printf("\n%d\n%s\n%s\n%s\n%s\n", 
          b.getNo(), b.getTitle(), b.getContents(), b.getToday(), b.getViewCount());
    }
  }
  
  public void detailBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다");
      return;
    }
    Board board = this.boardList.get(index);
    
    System.out.printf("번호: %s\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getToday());
    System.out.printf("조회수: %s\n", board.getViewCount());
  }
  
  public void deleteBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다");
      return;
    }
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다");
  }
  
  public void updateBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    
    Board newBoard = new Board();
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }
    Board oldBoard = this.boardList.get(index);

    newBoard.setTitle(prompt.inputString(String.format("제목(%s)? ", 
        oldBoard.getTitle()),oldBoard.getTitle()));
    
    newBoard.setContents(prompt.inputString(String.format("내용(%s)? ", 
        oldBoard.getContents()),oldBoard.getContents()));
    
    newBoard.setNo(oldBoard.getNo());
    newBoard.setToday(oldBoard.getToday());
    newBoard.setViewCount(oldBoard.getViewCount());
    
    if(oldBoard.equals(newBoard)) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }
    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다");
    
  }
  private int indexOfBoard(int no) {
    for (int i = 0; i< this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}














