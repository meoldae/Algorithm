import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        Stack<Integer> rooftop = new Stack<>();
        for (int i = 0; i < N; i++) {
            int building = Integer.parseInt(br.readLine());
            while(!rooftop.isEmpty() && rooftop.peek() <= building) rooftop.pop();
            answer += rooftop.size();
            rooftop.push(building);
        }
        System.out.println(answer);
    }
}
