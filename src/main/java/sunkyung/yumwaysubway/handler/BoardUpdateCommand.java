package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.util.Prompt;

public class BoardUpdateCommand implements Command {
  List<Board> boardList;
  public Prompt prompt;

  public BoardUpdateCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    boardList = list;
  }

  @Override
  public void execute() {
    int index = indexOfBoard(prompt.inputInt("번호? "));

    Board newBoard = new Board();
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }
    Board oldBoard = this.boardList.get(index);

    newBoard.setTitle(
        prompt.inputString(String.format("제목(%s)? ", oldBoard.getTitle()), oldBoard.getTitle()));

    newBoard.setContents(prompt.inputString(String.format("내용(%s)? ", oldBoard.getContents()),
        oldBoard.getContents()));

    newBoard.setNo(oldBoard.getNo());
    newBoard.setToday(oldBoard.getToday());
    newBoard.setViewCount(oldBoard.getViewCount());

    if (oldBoard.equals(newBoard)) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }
    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다");

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


