package Week2.Friday.Stacks;

public interface IStack<T> {
    void push(T element);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
