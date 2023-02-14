import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{towers[i], i});
                answer[i] = 0;
            }else {
                while (!stack.isEmpty()) {
                    if (stack.peek()[0] < towers[i]){
                        stack.pop();
                        if (stack.isEmpty()){
                            answer[i] = 0;
                        }
                    }else {
                        answer[i] = stack.peek()[1]+1;
                        break;
                    }
                }
                stack.push(new int[]{towers[i], i});
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer).forEach(num -> sb.append(num).append(" "));
        System.out.println(sb);
    }
}
