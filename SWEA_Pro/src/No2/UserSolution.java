package No2;

class UserSolution {
    int H, W;
    Node CURSOR = new Node();
    Node HEAD = new Node();
    Node TAIL = new Node();
    int size = 0;
    void init(int mH, int mW, char mStr[]) {
        System.out.println("100");
        H = mH;
        W = mW;
        Node now = new Node();
        HEAD = now;
        for (char c : mStr) {
            if (c == '\0') break;
            size++;
            Node next = new Node(c);
            next.prev = now;
            now.next = next;
            now = next;
            TAIL = now;
        }
        HEAD = HEAD.next;

        now = HEAD;
        while(true) {
            System.out.print(now.value);
            if (now.next == null) break;
            now = now.next;
        }
        System.out.println();
    }

    void insert(char mChar) {
        System.out.println("200");
        Node input = new Node(mChar);
        input.prev = CURSOR.prev;
        input.next = CURSOR.next;
        CURSOR.prev = input;

        Node now = HEAD;
        while(true) {
            System.out.print(now.value);
            if (now.next == null) break;
            now = now.next;
        }
        System.out.println();
    }

    char moveCursor(int mRow, int mCol) {
        System.out.println("300");
        int count = W * (mRow - 1) + (mCol - 1) - 1;

        Node now = HEAD;
        while(true) {
            System.out.print(now.value);
            if (now.next == null) break;
            now = now.next;
        }
        System.out.println();

        now = HEAD;
        for (int i = 0; i < count; i++) {
            if (now.next == null) {
                now.next = CURSOR;
                return '$';
            }
            now = now.next;
        }
        CURSOR.next = now.next;
        CURSOR.prev = now;
        return CURSOR.next.value;
    }

    int countCharacter(char mChar) {
        System.out.println("400");

        Node now = HEAD;
        while(true) {
            System.out.print(now.value);
            if (now.next == null) break;
            now = now.next;
        }
        System.out.println();

        now = CURSOR;
        int count = 0;
        while (true) {
            if (now.next == null) break;
            if (mChar == now.next.value) count++;
            now = now.next;
        }
        return count;
    }
}
class Node {
    char value;
    Node prev;
    Node next;

    public Node(char value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public Node() {

    }
}