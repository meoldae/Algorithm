import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9009 {
    static StringBuilder answer;
    static int[] fArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        fArray = new int[46];
        fArray[1] = 1;
        makeFibo(45);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Integer> stack = new Stack<>();
            int target = Integer.parseInt(br.readLine());
            int idx = 45;
            while (target > 0) {
                if (target >= fArray[idx]) {
                    target -= fArray[idx];
                    stack.push(fArray[idx]);
                }
                idx--;
            }
            while (!stack.isEmpty()) answer.append(stack.pop()).append(" ");
            answer.append("\n");
        }
        System.out.print(answer);
    }

    static int makeFibo(int target) {
        if (target == 0 || target == 1) return fArray[target];
        if (fArray[target] > 1) return fArray[target];
        return fArray[target] = makeFibo(target - 1) + makeFibo(target - 2);
    }
}