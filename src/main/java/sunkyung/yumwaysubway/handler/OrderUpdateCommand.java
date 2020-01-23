package sunkyung.yumwaysubway.handler;

import java.util.List;
import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.util.Prompt;

public class OrderUpdateCommand implements Command {

  List<Order> orderList;
  public Prompt prompt;

  public OrderUpdateCommand(Prompt prompt, List<Order> list) {
    this.prompt = prompt;
    orderList = list;
  }

  @Override
  public void execute() {
    int index = indexOfOrder(prompt.inputInt("번호? "));
    Order newOrder = new Order();
    if (index == -1) {
      System.out.println("주문 번호가 유효하지 않습니다");
      return;
    }
    Order oldOrder = this.orderList.get(index);
    newOrder.setBread(
        prompt.inputString(String.format("빵(%s)? ", oldOrder.getBread()), oldOrder.getBread()));
    newOrder.setMain(
        prompt.inputString(String.format("메인(%s)? ", oldOrder.getMain()), oldOrder.getMain()));
    newOrder.setCheese(
        prompt.inputString(String.format("치즈(%s)? ", oldOrder.getCheese()), oldOrder.getCheese()));
    newOrder.setVegetable(prompt.inputString(String.format("채소(%s)? ", oldOrder.getVegetable()),
        oldOrder.getVegetable()));
    newOrder.setSauce(
        prompt.inputString(String.format("소스(%s)? ", oldOrder.getSauce()), oldOrder.getSauce()));

    newOrder.setNo(oldOrder.getNo());

    if (oldOrder.equals(newOrder)) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }
    this.orderList.set(index, newOrder);
    System.out.println("게시글을 변경했습니다");
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
