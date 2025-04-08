public class Nodo<T> {

    private T info;
    private Nodo<T> next;

    public Nodo() {
        this.info = null;
        this.next = null;
    }

    public Nodo(T info, Nodo<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public T getInfo() {return info;}
    public void setInfo(T info) {this.info = info;}
    public Nodo<T> getNext() {return next;}
    public void setNext(Nodo<T> next) {this.next = next;}
}
