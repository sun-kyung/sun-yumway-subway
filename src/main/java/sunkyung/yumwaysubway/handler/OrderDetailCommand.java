package sunkyung.yumwaysubway.handler;

import java.util.AbstractList;
import java.util.List;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.util.Prompt;

public class OrderDetailCommand implements Command {

  List<Order> orderList;
  public Prompt prompt;

  public OrderDetailCommand(Prompt prompt, AbstractList<Order> list) {
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
    Order order = this.orderList.get(index);

    System.out.printf("번호: %d\n", order.getNo());
    System.out.printf("빵: %s\n", order.getBread());
    System.out.printf("메인: %s\n", order.getMain());
    System.out.printf("치즈: %s\n", order.getCheese());
    System.out.printf("채소: %s\n", order.getVegetable());
    System.out.printf("소스: %s\n", order.getSauce());
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
