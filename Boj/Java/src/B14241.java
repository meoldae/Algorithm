import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B14241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int slime = Integer.parseInt(st.nextToken());
            pq.offer(-1 * slime);
        }

        int answer = 0;

        while(pq.size() > 1) {
            int x = pq.poll() * -1;
            int y = pq.poll() * -1;
            answer += x * y;
            pq.offer((x + y) * -1);
        }
        System.out.print(answer);
    }
}
