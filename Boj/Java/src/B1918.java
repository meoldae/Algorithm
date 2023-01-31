import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : input) {
            if (65 <= c && c <= 90) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    static int priority(char c){
        if (c == '*' || c == '/'){
            return 1;
        }else if (c == '(' || c == ')'){
            return -1;
        }else {
            return 0;
        }
    }
}
