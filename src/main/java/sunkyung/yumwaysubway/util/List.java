package sunkyung.yumwaysubway.util;

public interface List<E> {
  public abstract void add(E e);
  public abstract void add(int index, E value);
  public abstract E get(int index);
  public abstract E remove(int index);
  public abstract E set(int index, E value);
  public abstract Object[] toArray();
  public abstract E[] toArray(E[] arr);
  int size();
}