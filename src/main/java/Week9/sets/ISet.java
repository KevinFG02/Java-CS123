package Week9.sets;

public interface ISet {
    boolean add(Object obj);
    boolean contains(Object obj);
    boolean remove(Object obj);
    int size();
    boolean isEmpty();

    //ISet union(ISet otherSet);
    //ISet intersection(ISet otherSet);
    //ISet difference(ISet otherSet);
    //boolean subset(ISet otherSet); // Not a proper meaning they're not equal.
}
