package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.util.Prompt;

public class SideUpdateCommand implements Command {

  List<Side> sideList;
  public Prompt prompt;

  public SideUpdateCommand(Prompt prompt, List<Side> list) {
    this.prompt = prompt;
    sideList = list;
  }

  @Override
  public void execute() {
    int index = indexOfSide(prompt.inputInt("번호? "));
    Side newSide = new Side();
    if (index == -1) {
      System.out.println("사이드 번호가 유효하지 않습니다");
      return;
    }
    Side oldSide = this.sideList.get(index);

    newSide.setCookie(
        prompt.inputString(String.format("쿠키(%s)? ", oldSide.getCookie()), oldSide.getCookie()));
    newSide.setBeverage(prompt.inputString(String.format("음료(%s)? ", oldSide.getBeverage()),
        oldSide.getBeverage()));
    newSide.setOthers(
        prompt.inputString(String.format("그 외(%s)? ", oldSide.getOthers()), oldSide.getOthers()));
    newSide.setNo(oldSide.getNo());

    if (oldSide.equals(newSide)) {
      System.out.println("사이드 변경을 취소했습니다");
      return;
    }
    sideList.set(index, newSide);
    System.out.println("사이드를 변경했습니다");
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
