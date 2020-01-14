package sunkyung.yumwaysubway.handler;

import sunkyung.yumwaysubway.domain.Order;
import sunkyung.yumwaysubway.util.AbstractList;
import sunkyung.yumwaysubway.util.Prompt;

public class OrderHandler {

  AbstractList<Order> orderList;
  public Prompt prompt;

  public OrderHandler(Prompt prompt, AbstractList<Order> list) {
    this.prompt = prompt;
    orderList = list;
  }

  public void addOrder() {
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
  public void listOrder() {

    System.out.println();
    Order[] arr = orderList.toArray(new Order[this.orderList.size()]);
    for (Order o : arr) {
      System.out.printf("\n%d, %s, %s, %s, %s, %s\n", 
          o.getNo(), o.getBread(), o.getMain(), o.getCheese(), o.getVegetable(), o.getSauce());
    }
  }

  public void detailOrder() {
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

  public void deleteOrder() {
    int index = indexOfOrder(prompt.inputInt("번호? "));
    if (index == -1) {
      System.out.println("주문 번호가 유효하지 않습니다");
      return;
    }
    this.orderList.remove(index);
    System.out.println("주문을 삭제했습니다");
  }

  public void updateOrder() {
    int index = indexOfOrder(prompt.inputInt("번호? "));
    Order newOrder = new Order();
    if (index == -1) {
      System.out.println("주문 번호가 유효하지 않습니다");
      return;
    }
    Order oldOrder = this.orderList.get(index);
    newOrder.setBread(prompt.inputString(String.format("빵(%s)? ", 
        oldOrder.getBread()),oldOrder.getBread()));
    newOrder.setMain(prompt.inputString(String.format("메인(%s)? ", 
        oldOrder.getMain()),oldOrder.getMain()));
    newOrder.setCheese(prompt.inputString(String.format("치즈(%s)? ", 
        oldOrder.getCheese()),oldOrder.getCheese()));
    newOrder.setVegetable(prompt.inputString(String.format("채소(%s)? ", 
        oldOrder.getVegetable()),oldOrder.getVegetable()));
    newOrder.setSauce(prompt.inputString(String.format("소스(%s)? ", 
        oldOrder.getSauce()),oldOrder.getSauce()));

    newOrder.setNo(oldOrder.getNo());

    if(oldOrder.equals(newOrder)) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }
    this.orderList.set(index, newOrder);
    System.out.println("게시글을 변경했습니다");
  }
  private int indexOfOrder(int no) {
    for (int i = 0; i< this.orderList.size(); i++) {
      if (this.orderList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
