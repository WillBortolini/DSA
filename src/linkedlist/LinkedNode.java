package linkedlist;

public class LinkedNode<T> {
    private T Data;

    private LinkedNode<T> next;

    private LinkedNode<T> previous;

    public LinkedNode(T data, LinkedNode<T> next, LinkedNode<T> previous) {
        Data = data;
        this.next = next;
        this.previous = previous;
    }

    public LinkedNode(T data) {
        Data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public LinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode<T> previous) {
        this.previous = previous;
    }
}
