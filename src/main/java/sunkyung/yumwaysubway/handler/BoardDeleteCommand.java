package sunkyung.yumwaysubway.handler;

import java.util.AbstractList;
import java.util.List;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.util.Prompt;

public class BoardDeleteCommand implements Command {
  List<Board> boardList;
  public Prompt prompt;

  public BoardDeleteCommand(Prompt prompt, AbstractList<Board> list) {
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
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다");
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


