package bag;

//this defines the behavior of our data structures
public interface Collection<T> {
    boolean add(T obj);
    boolean remove(T search);
    void clear();
    boolean contains(T obj);
    int size();
    boolean isEmpty();
    T getSomething();
}
