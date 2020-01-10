package sunkyung.yumwaysubway.handler;

import sunkyung.yumwaysubway.domain.Side;
import sunkyung.yumwaysubway.util.LinkedList;
import sunkyung.yumwaysubway.util.Prompt;
public class SideHandler {

  LinkedList<Side> sideList;
  public Prompt prompt;
  
  public SideHandler(Prompt prompt) {
    this.prompt = prompt;
    sideList = new LinkedList<>();
  }
  
  public void addSide() {
    Side side = new Side();
    side.setNo(prompt.inputInt("번호? "));
    side.setCookie(prompt.inputString("쿠키? "));
    side.setBeverage(prompt.inputString("음료? "));
    side.setOthers(prompt.inputString("그 외? "));

    sideList.add(side);
    System.out.println("저장하였습니다.");
  }
  public void listSide() {
    Side[] arr = new Side[this.sideList.size()];
    this.sideList.toArray(arr);
    for (Side s : arr) {
      System.out.printf("%d, %s, %s, %s\n", 
          s.getNo(), s.getCookie(), s.getBeverage(), s.getOthers());
    }
  }
  public void detailSide() {
    int index = indexOfSide(prompt.inputInt("번호? "));
    
    if(index == -1) {
      System.out.println("사이드 번호가 유효하지 않습니다");
      return;
    }
    Side side = this.sideList.get(index);
    System.out.printf("쿠키: %s\n", side.getCookie());
    System.out.printf("음료: %s\n", side.getBeverage());
    System.out.printf("그 외: %s\n", side.getOthers());
  }
  public void deleteSide() {
    int index = indexOfSide(prompt.inputInt("번호? "));
    
    if(index == -1) {
      System.out.println("사이드 번호가 유효하지 않습니다");
      return;
    }
    this.sideList.remove(index);
    System.out.println("사이드를 삭제했습니다");
  }
  public void updateSide() {
    int index = indexOfSide(prompt.inputInt("번호? "));
    Side newSide = new Side();
    if(index == -1) {
      System.out.println("사이드 번호가 유효하지 않습니다");
      return;
    }
    Side oldSide = this.sideList.get(index);
    
    newSide.setCookie(prompt.inputString(String.format("쿠키(%s)? ", 
        oldSide.getCookie()),oldSide.getCookie()));
    newSide.setBeverage(prompt.inputString(String.format("음료(%s)? ", 
        oldSide.getBeverage()),oldSide.getBeverage()));
    newSide.setOthers(prompt.inputString(String.format("그 외(%s)? ", 
        oldSide.getOthers()),oldSide.getOthers()));
    newSide.setNo(oldSide.getNo());
    
    if(oldSide.equals(newSide)) {
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
