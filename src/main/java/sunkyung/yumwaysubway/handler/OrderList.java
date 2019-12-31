package sunkyung.yumwaysubway.handler;

import java.util.Arrays;
import sunkyung.yumwaysubway.domain.Order;

public class OrderList {
  public static final int DEFAULT_CAPACITY = 100;
  Order[] list;
  int size = 0;
  
  public OrderList() {
    this.list = new Order[DEFAULT_CAPACITY];
  }
  
  public OrderList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Order[DEFAULT_CAPACITY];
    this.list = new Order[capacity];
  }
  public Order[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Order order) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = order;
  }
}
