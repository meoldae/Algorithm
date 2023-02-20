import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());
            Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).forEach(pq::offer);
            long answer = 0;
            while(!pq.isEmpty()){
                long a = pq.poll();
                long b = pq.poll();
                answer += a + b;
                if (!pq.isEmpty()) pq.offer(a+b);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
