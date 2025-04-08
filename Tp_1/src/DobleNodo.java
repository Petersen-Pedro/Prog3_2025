public class DobleNodo<T> {
    private T data;
    private DobleNodo<T> next;
    private DobleNodo<T> prev;

    public DobleNodo(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public DobleNodo<T> getNext() {
        return next;
    }

    public void setNext(DobleNodo<T> next) {
        this.next = next;
    }

    public DobleNodo<T> getPrev() {
        return prev;
    }

    public void setPrev(DobleNodo<T> prev) {
        this.prev = prev;
    }
}
