import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(true) {
            Stack<Character> stack = new Stack<>();
            char[] input = br.readLine().toCharArray();
            if (input[0] == '-') break;

            int count = 0;
            for (char p : input) {
                if (p == '{') {
                    stack.push(p);
                } else {
                    if (stack.isEmpty()) {
                        stack.push('{');
                        count++;
                    } else {
                        stack.pop();
                    }
                }
            }
            count += stack.size() / 2;
            sb.append(idx++).append(". ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}