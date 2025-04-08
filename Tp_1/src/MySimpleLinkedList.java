import java.util.Iterator;
import java.util.Objects;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{

    private Nodo<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T elemento) {
        Nodo<T> aux = new Nodo<T>(elemento, null);
        if (first != null)
            aux.setNext(this.first);
        this.first = aux;
        this.size++;
    }

    public T extractFront() {
        Nodo<T> aux = this.first;
        this.first = this.first.getNext();
        aux.setNext(null);
        this.size--;
        return aux.getInfo();
    }

    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        }
        return false;
    }

    public T get(int index) {
        if (!this.isEmpty()) {
            int pos = 0;
            Nodo<T> aux = this.first;
            while(aux.getNext()!=null && pos != index) {
                aux = aux.getNext();
                pos++;
            }
            if (pos == index) {
                return aux.getInfo();
            }
            else {
                return null;
            }
        }
        return null;
    }

    public int size() {
        int pos = 0;
        Nodo<T> aux = this.first;
        while(aux.getNext()!=null) {
            aux = aux.getNext();
            pos++;
        }
        return pos;
    }

    public int indexOf(T elemento) {
        Nodo<T> aux = this.first;
        int pos = 0;
        while(!Objects.equals(aux, elemento) && pos >= 0) {
            pos++;
        }
        if (Objects.equals(aux, elemento))
            return pos;
        else return -1;
    }

    public void insertOrdered(T elemento) {
        if (this.isEmpty() || this.first.getInfo().compareTo(elemento) >= 0) {
            insertFront(elemento);
        }
        else{
            Nodo<T> nuevo = new Nodo<>(elemento, null);

            Nodo<T> puntero = this.first;
            Nodo<T> aux = null;

            while(puntero != null && puntero.getInfo().compareTo(elemento) < 0) {
                aux = puntero;
                puntero = puntero.getNext();
            }
            nuevo.setNext(puntero);
            aux.setNext(nuevo);


        }

    }

    @Override
    public String toString() {
        StringBuilder bloque = new StringBuilder("[");
        Nodo<T> puntero = this.first;
        while (puntero != null) {
            bloque.append(puntero.getInfo());
            if (puntero.getNext() != null) {
                bloque.append(", ");
            }
            puntero = puntero.getNext();
        }
        bloque.append("]");
        return bloque.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<>(this.first);
    }
}
