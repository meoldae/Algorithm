package No2;

public class temp {

    public static void main(String[] args) {
        Node CURSOR = new Node();
        Node now = new Node();
        CURSOR.next = now;
        now.prev = CURSOR;
        int size = 0;
        for (char c : new char[]{'b', 'c', 'd', 'e', 'g'}) {
            if (c == '\0') break;
            size++;
            Node next = new Node(c);
            next.prev = now;
            now.next = next;
            now = next;
        }
        CURSOR.next = CURSOR.next.next;
        CURSOR.next.prev = CURSOR;
        now = CURSOR.next;
    }
}
