package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.util.Prompt;

public class OrderDeleteCommand implements Command {

  List<Order> orderList;
  public Prompt prompt;

  public OrderDeleteCommand(Prompt prompt, List<Order> list) {
    this.prompt = prompt;
    orderList = list;
  }

  @Override
  public void execute() {
    int index = indexOfOrder(prompt.inputInt("번호? "));
    if (index == -1) {
      System.out.println("주문 번호가 유효하지 않습니다");
      return;
    }
    this.orderList.remove(index);
    System.out.println("주문을 삭제했습니다");
  }

  private int indexOfOrder(int no) {
    for (int i = 0; i < this.orderList.size(); i++) {
      if (this.orderList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
