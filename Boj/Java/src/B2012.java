import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));

        int order = 1;
        long answer = 0L;
        while (!pq.isEmpty()) {
            answer += Math.abs(order - pq.poll());
            order++;
        }
        System.out.print(answer);
    }
}
