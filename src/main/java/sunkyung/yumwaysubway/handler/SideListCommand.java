package sunkyung.yumwaysubway.handler;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import sunkyung.yumwaysubway.domain.Side;

public class SideListCommand implements Command {

  List<Side> sideList;

  public SideListCommand(AbstractList<Side> list) {
    sideList = list;
  }

  @Override
  public void execute() {
    Iterator<Side> iterator = sideList.iterator();
    while (iterator.hasNext()) {
      Side s = iterator.next();
      System.out.printf("%d, %s, %s, %s\n", s.getNo(), s.getCookie(), s.getBeverage(),
          s.getOthers());
    }
  }
}
