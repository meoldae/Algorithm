package DataStructure;

public class MyLinkedList {

    static class Node {
        int value;
        Node next;
        Node prev;
    }

    private int SIZE;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        SIZE = 0;
        head = null;
        tail = null;
    }

    public int size(){
        return this.SIZE;
    }

    public void add(Node node){
        if (head == null){
            this.head = node;
            this.tail = node;
        }else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
    }
}
