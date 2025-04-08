import org.w3c.dom.Node;
import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {
    private Nodo<T> puntero;

    public MyListIterator(Nodo<T> puntero) {
        this.puntero = puntero;
    }

    @Override
    public boolean hasNext() {
        return this.puntero != null;
    }

    @Override
    public T next() {
        if (this.puntero == null)
            return null;
        T data = this.puntero.getInfo();
        this.puntero = this.puntero.getNext();
        return data;
    }

    public T get(){
        return this.puntero.getInfo();
    }



}
