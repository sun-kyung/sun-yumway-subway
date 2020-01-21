package sunkyung.yumwaysubway.handler;

import java.util.AbstractList;
import java.util.List;
import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.util.Prompt;

public class SideAddCommand implements Command {

  List<Side> sideList;
  public Prompt prompt;

  public SideAddCommand(Prompt prompt, AbstractList<Side> list) {
    this.prompt = prompt;
    sideList = list;
  }

  @Override
  public void execute() {
    Side side = new Side();
    side.setNo(prompt.inputInt("번호? "));
    side.setCookie(prompt.inputString("쿠키? "));
    side.setBeverage(prompt.inputString("음료? "));
    side.setOthers(prompt.inputString("그 외? "));

    sideList.add(side);
    System.out.println("저장하였습니다.");
  }
}
