package linkedlist;

public class LinkedNode {
    private String Data;

    private LinkedNode next;

    private LinkedNode previous;

    public LinkedNode(String data, LinkedNode next, LinkedNode previous) {
        Data = data;
        this.next = next;
        this.previous = previous;
    }

    public LinkedNode(String data) {
        Data = data;
        this.next = null;
        this.previous = null;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode previous) {
        this.previous = previous;
    }
}
