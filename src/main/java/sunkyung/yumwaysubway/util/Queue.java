package sunkyung.yumwaysubway.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{
  public void offer(E value) {
    this.add(value);
  }
  public E poll() {
    return this.remove(0);
  }
  @Override
  public Queue<E> clone(){
    Queue<E> temp = new Queue<E>();
    for (int i = 0; i < size; i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
}
