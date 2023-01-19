import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d, n;
        String[] input = br.readLine().split(" ");
        d = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        Stack<Integer> depthR = new Stack<>();
        Stack<Integer> depthL = new Stack<>();

        input = br.readLine().split(" ");
        for (int i = d-1; i >= 0; i--) {
            depthR.push(Integer.parseInt(input[i]));
        }

        int[] dough = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            dough[i] = Integer.parseInt(input[i]);
        }

        while (true) {
            if (depthR.peek() >= dough[0]) {
                depthL.push(depthR.pop());
            }else {
                depthL.pop();
                break;
            }
        }
        boolean flag = false;
        for (int i = 1; i < dough.length; i++) {
            while (!depthL.isEmpty()) {
                if (depthL.peek() < dough[i]) {
                    depthL.pop();
                }
                else {
                    break;
                }
            }
            if (i == dough.length && !depthL.isEmpty()) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println(0);
        }else {
            System.out.println(depthL.size());
        }
    }
}