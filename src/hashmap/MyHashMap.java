package hashmap;


import linkedlist.LinkedNode;
import linkedlist.MyLinkedList;


public class MyHashMap<K, V> {
    class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private MyLinkedList<Entry<K,V>>[] linkedLists;
    private int size;

    public MyHashMap(int size) {
        this.size = size;
        this.linkedLists = new MyLinkedList[size];
    }

    public int hashFunction(K key) {
        return Math.abs(key.hashCode() % this.size);
    }

    public void put(K key, V value) {
        int index = this.hashFunction(key);
        Entry<K, V> entry = new Entry<K, V>(key, value);
        LinkedNode<Entry<K,V>> node = new LinkedNode<Entry<K,V>>(entry);
        MyLinkedList<Entry<K,V>> actualList = this.linkedLists[index];

        if (actualList == null) {
            actualList = new MyLinkedList<Entry<K,V>>(node);
            this.linkedLists[index] = actualList;
        } else {
            boolean found = false;
            LinkedNode<Entry<K,V>> tempNode = actualList.getHead();
            for (int i = 0; i < actualList.getSize(); i++) {
                if (tempNode.getData().key.equals(key)) {
                    tempNode.getData().value = value;
                    found = true;
                    break;
                }
                tempNode = tempNode.getNext();
            }
            if (!found) {
                actualList.addLast(node);
            }
        }
    }

    public V get(K key){
        int index = this.hashFunction(key);
        MyLinkedList<Entry<K,V>> actualList = this.linkedLists[index];
        if (actualList == null) {
            return null;
        }
        LinkedNode<Entry<K,V>> tempNode = actualList.getHead();
        for (int i = 0; i < actualList.getSize(); i++) {
            if (tempNode.getData().key.equals(key)) {
                return tempNode.getData().value;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public void remove(K key){
        int index = this.hashFunction(key);
        MyLinkedList<Entry<K,V>> actualList = this.linkedLists[index];
        if (actualList == null) {
            return;
        }
        LinkedNode<Entry<K,V>> tempNode = actualList.getHead();
        for (int i = 0; i < actualList.getSize(); i++) {
            if (tempNode.getData().key.equals(key)) {
                actualList.remove(tempNode);
                break;
            }
            tempNode = tempNode.getNext();
        }
    }

    public boolean containsKey(K key){
        int index = this.hashFunction(key);
        MyLinkedList<Entry<K,V>> actualList = this.linkedLists[index];
        if (actualList == null) {
            return false;
        }
        LinkedNode<Entry<K,V>> tempNode = actualList.getHead();
        for (int i = 0; i < actualList.getSize(); i++) {
            if (tempNode.getData().key.equals(key)) {
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }

    public boolean containsValue(V value){
        for (MyLinkedList<Entry<K,V>> linkedList : linkedLists) {
            if(linkedList != null){
                LinkedNode<Entry<K,V>> tempNode = linkedList.getHead();
                for (int i = 0; i < linkedList.getSize(); i++) {
                    if (tempNode.getData().value.equals(value)) {
                        return true;
                    }
                    tempNode = tempNode.getNext();
                }
            }
        }
        return false;
    }

    public int size(){
        int size = 0;
        for (MyLinkedList<Entry<K,V>> linkedList : linkedLists) {
            if(linkedList != null){
                size += linkedList.getSize();
            }
        }
        return size;
    }

    public void printMap(){
        for (MyLinkedList<Entry<K,V>> linkedList : linkedLists) {
            if(linkedList != null){
                LinkedNode<Entry<K,V>> tempNode = linkedList.getHead();
                for (int i = 0; i < linkedList.getSize(); i++) {
                    System.out.println("Key: " + tempNode.getData().key + ", Value: " + tempNode.getData().value);
                    tempNode = tempNode.getNext();
                }
            }
        }
    }
}
