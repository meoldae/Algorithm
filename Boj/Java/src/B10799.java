import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bracket = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < bracket.length; i++){
            if (bracket[i] == '(') stack.push(i);
            else{
                if (stack.pop() == i-1) answer += stack.size();
                else answer += 1;
            }
        }
        System.out.print(answer);
    }
}
