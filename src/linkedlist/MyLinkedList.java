package linkedlist;

import java.util.Objects;

public class MyLinkedList<T> {

    private LinkedNode<T> head;

    private LinkedNode<T> tail;

    private int size;

    public MyLinkedList(LinkedNode<T> node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedNode<T> getHead() {
        return head;
    }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public LinkedNode<T> getTail() {
        return tail;
    }

    public void setTail(LinkedNode<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }

    public void addFirst(LinkedNode<T> node) {
        if (head == null) {
            this.setHead(node);
            this.setTail(node);
        } else {
            node.setNext(this.getHead());
            this.getHead().setPrevious(node);
            this.setHead(node);
        }
        this.incrementSize();
    }

    public void addLast(LinkedNode<T> node) {
        if (this.getTail() == null) {
            this.addFirst(node);
            return;
        } else {
            node.setPrevious(this.getTail());
            this.getTail().setNext(node);
            this.setTail(node);
        }
        this.incrementSize();
    }

    public void add(int index, LinkedNode<T> node) {
        if (index < 0 || index > this.getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            this.addFirst(node);
            return;
        }

        if (index == size) {
            this.addLast(node);
            return;
        }

        LinkedNode<T> temp = this.getHead();

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        node.setPrevious(temp.getPrevious());
        node.setNext(temp);
        temp.getPrevious().setNext(node);
        temp.setPrevious(node);

        this.incrementSize();
    }

    public void removeFirst() {
        if (this.getSize() <= 0) {
            return;
        }
        if (this.getSize() == 1) {
            this.setHead(null);
            this.setTail(null);
            this.decrementSize();
            return;
        }
        if (this.getHead() != null) {
            this.setHead(this.getHead().getNext());
            this.head.setPrevious(null);
            this.decrementSize();
        }
    }

    public void removeLast() {
        if (this.getSize() <= 0) {
            return;
        }
        if (this.getSize() == 1) {
            this.setHead(null);
            this.setTail(null);
            this.decrementSize();
            return;
        }
        if (this.getTail() != null) {
            this.setTail(this.getTail().getPrevious());
            this.getTail().setNext(null);
            this.decrementSize();
        }
    }

    public void remove(int index) {
        if (index < 0 || index > this.getSize() - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            this.removeFirst();
            return;
        }

        if (index == this.getSize() - 1) {
            this.removeLast();
            return;
        }

        LinkedNode<T> temp = this.getHead();

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());

        this.decrementSize();
    }

    public void remove(LinkedNode<T> node) {
        if (node == null || this.getHead() == null) {
            return;
        }

        if (node == this.getHead()) {
            this.removeFirst();
            return;
        }

        if (node == this.getTail()) {
            this.removeLast();
            return;
        }

        LinkedNode<T> temp = this.getHead().getNext();
        while (temp != null) {
            if (temp == node) {
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrevious(temp.getPrevious());
                this.decrementSize();
                break;
            }
            temp = temp.getNext();
        }
    }

    public LinkedNode<T> get(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return this.getHead();
        }

        if (index == this.getSize() - 1) {
            return this.getTail();
        }

        LinkedNode<T> temp = this.getHead();

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    public boolean contains(LinkedNode<T> node) {
        LinkedNode<T> temp = this.getHead();
        while (temp != null) {
            if (Objects.equals(temp.getData(), node.getData())) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void set(int index, LinkedNode<T> node) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        LinkedNode<T> temp = this.getHead();

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        if (temp == head) {
            node.setNext(this.getHead().getNext());
            if (this.getHead().getNext() != null) {
                this.getHead().getNext().setPrevious(node);
            }
            this.setHead(node);
            if (tail == temp) {
                this.setTail(node);
            }
        } else if (temp == tail) {
            node.setPrevious(this.getTail().getPrevious());
            this.getTail().getPrevious().setNext(node);
            this.setTail(node);
        } else {
            temp.getPrevious().setNext(node);
            temp.getNext().setPrevious(node);
            node.setPrevious(temp.getPrevious());
            node.setNext(temp.getNext());
        }

        temp.setNext(null);
        temp.setPrevious(null);
    }

    public void printList() {
        LinkedNode<T> temp = this.getHead();
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println("this node is: " + temp.getData());
            temp = temp.getNext();
        }
    }
}
