import java.util.Iterator;
import java.util.Objects;

public class DobleLinkedList<T extends Comparable<T>> implements Iterable<T>{
    private DobleNodo<T> first;
    private DobleNodo<T> last;
    private int size;

    public DobleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFirst(T data) {
        DobleNodo<T> aux = new DobleNodo<T>(data);
        this.first.setPrev(aux);
        this.first = aux;
    }
    public void insertLast(T data) {
        DobleNodo<T> aux = new DobleNodo<T>(data);
        this.last.setNext(aux);
        this.last = aux;
    }

    @Override
    public Iterator<T> iterator() {
        return new DobleListIterator<T>(this.first);
    }
}
