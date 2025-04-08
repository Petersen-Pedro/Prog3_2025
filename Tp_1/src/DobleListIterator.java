import java.util.Iterator;

public class DobleListIterator<T> implements Iterator<T> {
    private DobleNodo<T> puntero;

    public DobleListIterator(DobleNodo<T> puntero) {
        this.puntero = puntero;
    }

    public boolean hasNext() {
        return puntero != null;
    }

    public T next() {
        if (!hasNext()) {
            return null;
        }
        T data = puntero.getData();
        puntero = puntero.getNext();
        return data;
    }

    public boolean hasPrev() {
        return puntero != null;
    }

    public T prev() {
        if (!hasPrev()) {
            return null;
        }
        T data = puntero.getData();
        puntero = puntero.getPrev();
        return data;
    }

    public T get(){
        if (puntero == null) {
            return null;
        }
        return puntero.getData();
    }
}
