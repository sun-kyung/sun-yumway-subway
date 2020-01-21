package sunkyung.yumwaysubway.handler;

import java.sql.Date;
import java.util.AbstractList;
import java.util.List;
import sunkyung.yumwaysubway.domain.Board;
import sunkyung.yumwaysubway.util.Prompt;

public class BoardAddCommand implements Command {
  List<Board> boardList;
  public Prompt prompt;

  public BoardAddCommand(Prompt prompt, AbstractList<Board> list) {
    this.prompt = prompt;
    boardList = list;
  }

  @Override
  public void execute() {
    Board board = new Board();
    board.setNo(prompt.inputInt("번호?"));
    board.setTitle(prompt.inputString("제목?"));
    board.setContents(prompt.inputString("내용?"));
    board.setToday(new Date(System.currentTimeMillis()));
    board.setViewCount(0);
    boardList.add(board);
    System.out.println("저장했습니다");
  }
}


