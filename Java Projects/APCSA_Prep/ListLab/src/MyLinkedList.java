import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 * A LinkedList class that behaves like a linked list. It holds elements (order matters).
 * It can be converted to string form, return its size, get an element at any index,
 * set an element at any index to another value, add an element to any position in the list,
 * remove any element from the list, and create iterators for the list.
 *
 * @param <E>   the data type of elements that will be stored in the arraylist.
 *
 * @author  Michael Chinkov
 * @version v1:
 */
public class MyLinkedList<E>
{
    private DoubleNode first;
    private DoubleNode last;
    private int size;

    /**
     * A constructor for the MyLinkedList class.
     * @postcondition   creates a MyLinkedList<E> object,
     *                  sets the size of the linked list to 0,
     *                  and sets the first/last nodes to null.
     */
    public MyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @precondition  0 <= index <= size / 2
     * @postcondition starting from first, returns the node
     *               with given index (where index 0
     *               returns first)
     */
    private DoubleNode getNodeFromFirst(int index)
    {
        DoubleNode temp = first;
        for (int i = 0; i < index; i++)
        {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * @precondition  size / 2 <= index < size
     * @postcondition starting from last, returns the node
     *               with given index (where index size-1
     *               returns last)
     */
    private DoubleNode getNodeFromLast(int index)
    {
        DoubleNode temp = last;
        for (int i = size-1; i > index; i--)
        {
            temp = temp.getPrevious();
        }
        return temp;
    }

    /**
     * @precondition  0 <= index < size
     * @postcondition starting from first or last (whichever
     *               is closer), returns the node with given
     *               index
     */
    private DoubleNode getNode(int index)
    {
        if (index > size/2)
        {
            return getNodeFromLast(index);
        }
        return getNodeFromFirst(index);
    }

    /**
     * Returns the size of the linked list
     * @return  the size of the linked list
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns the element at index
     * @param index     The index of the element to return
     * @precondition    index is in the interval [0,size)
     * @return          the object at index
     */
    public E get(int index)
    {
        return (E) getNode(index).getValue();
    }

    /**
     * Sets the element at index to obj
     * @param index     the index of the element to replace
     * @param obj       the new object
     * @precondition    index is in the interval [0,size)
     * @postcondition   replaces the element at position index with obj
     * @return          the element formerly at the specified position
     */
    public E set(int index, E obj)
    {
        E node = get(index);
        getNode(index).setValue(obj);
        return node;
    }

    /**
     * Adds an element obj to the end of the list
     * @param obj       the object to be appended to the list
     * @postcondition   appends obj to end of list and adjusts size
     * @return          true
     */
    public boolean add(E obj)
    {
        DoubleNode node = new DoubleNode(obj);
        if (size == 0)
        {
            first = node;
            last = node;
        }
        node.setPrevious(last);
        last.setNext(node);
        last = node;
        size++;
        return true;
    }

    /**
     * Removes the element at index
     * @param index     the index of the element to be removed
     * @precondition    index is in the interval [0,size)
     * @postcondition   removes element from position index, moving elements
     *                  at position index + 1 and higher to the left
     *                  (subtracts 1 from their indices) and adjusts size
     * @return          the element formerly at the specified position
     */
    public E remove(int index)
    {
        DoubleNode temp = getNode(index);
        boolean indexAtOne = index == 0;
        boolean indexAtEnd = index == size-1;

        if (size == 1){
            getNode(index).setPrevious(null);
            getNode(index).setNext(null);
            first = null;
            last = null;
        }

        else if (indexAtOne) {
            temp.getNext().setPrevious(null);
            first = temp.getNext();
        }

        else if (indexAtEnd){
            temp.getPrevious().setNext(null);
            last = temp.getPrevious();
        }
        else{
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }
        size--;


        return (E) temp.getValue();
    }
}