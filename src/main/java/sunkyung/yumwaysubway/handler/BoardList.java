package sunkyung.yumwaysubway.handler;

import java.util.Arrays;
import sunkyung.yumwaysubway.domain.Board;

public class BoardList {
  public static final int DEFAULT_CAPACITY = 100;
  Board[] list;
  int size = 0;

  public BoardList() {
    this.list = new Board[DEFAULT_CAPACITY];
  }
  public BoardList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Board[DEFAULT_CAPACITY];
    this.list = new Board[capacity];
  }
  public Board[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Board board) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = board;
  }
}
