import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2263 {
    static int[] inorder;
    static int[] postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        makeTree(0, n-1, 0, n-1);
        System.out.println(sb);
    }

    static void makeTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) return;
        int root = postorder[postorderEnd]; // Post Order => Left, Right, Root
        sb.append(root).append(" ");

        int inorderRoot = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) inorderRoot = i;
        }
        int leftIdx = inorderRoot - inorderStart;

        makeTree(inorderStart, inorderRoot - 1, postorderStart, postorderStart + leftIdx - 1);
        makeTree(inorderRoot + 1, inorderEnd, postorderStart + leftIdx, postorderEnd - 1);

    }
}