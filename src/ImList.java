/**
 * Represents an immutable list.
 * @param <E> type of elements in the list, must be immutable.
 */

public interface ImList<E> {

    // Data type definition:
    //      ImList<E> = Empty + Cons(first:E, rest:ImList).

    /**
     * Create an empty list.
     *
     * @param <E> type of elements in the list, must be immutable.
     * @return a new empty list.
     */
    public static <E> ImList<E> empty() {
        return new Empty<>();
    }

    /**
     *
     * @param e element to add to the list
     * @return a new list formed by adding element e to the front of another list
     */
    public ImList<E> cons(E e);

    /**
     *
     * @return the first element of the list. Requires the list to be nonempty
     */
    public E first();

    /**
     *
     * @return the list of all elements of this list except for the first, requires the list to be nonempty
     */
    public ImList<E> rest();

    /**
     *
     * @return the size of the list
     */
    public int size();

    /**
     *
     * @return true iff this list is empty
     */
    public boolean isEmpty();

    /**
     *
     * @param other list to append to this list
     * @return list with the elements of this followed by the elements of other
     */
    public ImList<E> append(ImList<E> other);

    /**
     *
     * @param e element to find in the list
     * @return true if element is found in the list
     */
    public boolean contains(E e);

}
