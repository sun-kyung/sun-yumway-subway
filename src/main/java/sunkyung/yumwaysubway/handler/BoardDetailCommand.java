package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.util.Prompt;

public class BoardDetailCommand implements Command {
  List<Board> boardList;
  public Prompt prompt;

  public BoardDetailCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    boardList = list;
  }

  @Override
  public void execute() {
    int index = indexOfBoard(prompt.inputInt("번호? "));
    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다");
      return;
    }
    Board board = this.boardList.get(index);

    System.out.printf("번호: %s\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getToday());
    System.out.printf("조회수: %s\n", board.getViewCount());
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


