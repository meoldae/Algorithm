import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639 {
    static class Node {
        int value = 0;
        Node left = null;
        Node right = null;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int num) {
            // 값 작을 때
            if (num < value) {
                // 하위노드가 존재하면 한 단계 더 탐색
                if (this.left != null) {
                    this.left.insert(num);
                // left가 null이면 새 자식노드 생성
                } else {
                    this.left = new Node(num);
                }
            // 값 클 때
            }else {
                // 하위노드가 존재하면 한 단계 더 탐색
                if (this.right != null){
                    this.right.insert(num);
                // right가 null이면 새 자식노드 생성
                } else {
                    this.right = new Node(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input = "";

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }

    static void postOrder(Node root) {

        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.println(root.value);
    }
}
