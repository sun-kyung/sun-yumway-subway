package sunkyung.yumwaysubway.handler;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import sunkyung.yumwaysubway.domain.Order;

public class OrderListCommand implements Command {

  List<Order> orderList;

  public OrderListCommand(AbstractList<Order> list) {
    orderList = list;
  }

  @Override
  public void execute() {

    Iterator<Order> iterator = orderList.iterator();
    while (iterator.hasNext()) {
      Order o = iterator.next();
      System.out.printf("\n%d, %s, %s, %s, %s, %s\n", o.getNo(), o.getBread(), o.getMain(),
          o.getCheese(), o.getVegetable(), o.getSauce());
    }
  }
}
