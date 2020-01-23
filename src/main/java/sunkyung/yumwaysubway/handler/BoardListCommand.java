package sunkyung.yumwaysubway.handler;

import java.util.Iterator;
import java.util.List;
import sunkyung.yumwaysubway.domain.Board;

public class BoardListCommand implements Command {
  List<Board> boardList;

  public BoardListCommand(List<Board> list) {
    boardList = list;
  }

  @Override
  public void execute() {
    Iterator<Board> iterator = boardList.iterator();
    while (iterator.hasNext()) {
      Board b = iterator.next();
      System.out.printf("\n%d\n%s\n%s\n%s\n%s\n", b.getNo(), b.getTitle(), b.getContents(),
          b.getToday(), b.getViewCount());
    }
  }
}


