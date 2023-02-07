import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] word = br.readLine().toCharArray();
        int idx = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        while (idx < str.length) {
            stack1.push(str[idx++]);
            if (stack1.peek() == word[word.length - 1]) {
                stack2.push(stack1.pop());
                for (int i = word.length - 2; i >= 0; i--) {
                    if (!stack1.isEmpty() && stack1.peek() != word[i]){
                        while(!stack2.isEmpty()){
                            stack1.push(stack2.pop());
                        }
                        break;
                    }
                    stack2.push(stack1.pop());
                }
                stack2.clear();
            }
        }
        if (stack1.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack1.isEmpty()) {
                sb.append(stack1.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}
