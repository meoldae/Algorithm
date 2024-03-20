import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        Queue<Long> cards = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long next = cards.poll() + cards.poll();
            cards.offer(next);
            cards.offer(next);
        }

        long answer = 0;
        while(!cards.isEmpty()) {
            answer += cards.poll();
        }
        System.out.print(answer);
    }
}