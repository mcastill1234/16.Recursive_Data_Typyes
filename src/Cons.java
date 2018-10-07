
/**
 * An implementation of ImList
 *
 * @param <E> type of elements in the list, must be immutable.
 */

public class Cons<E> implements ImList<E> {

    private final E e;
    private final ImList<E> rest;
    private int size = 0;

    // Abstraction function:
    //      Represents the result of the cons operation (an element glued together with another list)
    // Rep invariant:
    //      e != null, rest != null, size >=0
    //      size > 0 implies size == 1 + rest.size()
    // Safety from rep exposure:
    //      fields e, rest are private final and size is private and immutable. Observers return immutable types,
    //      constructors and mutators return new objects.

    public Cons(E e, ImList<E> rest) {
        this.e = e;
        this.rest = rest;
    }

    @Override
    public ImList<E> cons(E e) {
        return new Cons<>(e, this);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public E first() {
        return e;
    }

    @Override
    public ImList<E> rest() {
        return rest;
    }

    @Override
    public int size() {
        if (size == 0) {
            return size = 1 + rest.size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ImList<E> append(ImList<E> other) {
        return new Cons<>(e, rest.append(other));
    }

    @Override
    public boolean contains(E e) {
        if (this.e == e) {
            return true;
        }
        return rest.contains(e);
    }
}
