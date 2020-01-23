package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.util.Prompt;

public class SideDetailCommand implements Command {

  List<Side> sideList;
  public Prompt prompt;

  public SideDetailCommand(Prompt prompt, List<Side> list) {
    this.prompt = prompt;
    sideList = list;
  }

  @Override
  public void execute() {
    int index = indexOfSide(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("사이드 번호가 유효하지 않습니다");
      return;
    }
    Side side = this.sideList.get(index);
    System.out.printf("쿠키: %s\n", side.getCookie());
    System.out.printf("음료: %s\n", side.getBeverage());
    System.out.printf("그 외: %s\n", side.getOthers());
  }

  private int indexOfSide(int no) {
    for (int i = 0; i < this.sideList.size(); i++) {
      if (this.sideList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
