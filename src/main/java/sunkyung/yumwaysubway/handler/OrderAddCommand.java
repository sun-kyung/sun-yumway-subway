package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.util.Prompt;

public class OrderAddCommand implements Command {

  List<Order> orderList;
  public Prompt prompt;

  public OrderAddCommand(Prompt prompt, List<Order> list) {
    this.prompt = prompt;
    orderList = list;
  }

  @Override
  public void execute() {
    Order order = new Order();
    order.setNo(prompt.inputInt("번호? "));
    order.setBread(prompt.inputString("빵? "));
    order.setMain(prompt.inputString("메인? "));
    order.setCheese(prompt.inputString("치즈? "));
    order.setVegetable(prompt.inputString("채소? "));
    order.setSauce(prompt.inputString("소스? "));
    orderList.add(order);
    System.out.println("저장하였습니다.");
  }
}
