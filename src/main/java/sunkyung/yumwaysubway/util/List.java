package sunkyung.yumwaysubway.util;

public interface List<E> {
  void add(E e);
  void add(int index, E value);
  E get(int index);
  E remove(int index);
  E set(int index, E value);
  Object[] toArray();
  E[] toArray(E[] arr);
  int size();
  
  Iterator<E> iterator();
}
