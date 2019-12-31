package sunkyung.yumwaysubway.handler;

import java.util.Arrays;
import sunkyung.yumwaysubway.domain.Side;

public class SideList {
  public static final int DEFAULT_CAPACITY = 100;
  Side[] list;
  int size = 0;
  
  public SideList() {
    this.list = new Side[DEFAULT_CAPACITY];
  }
  
  public SideList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Side[DEFAULT_CAPACITY];
    this.list = new Side[capacity];
  }
  
  public void add(Side side) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = side;
  }
  public Side[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
}
