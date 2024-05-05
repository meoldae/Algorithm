import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int snow = Integer.parseInt(st.nextToken());
            if (snow > 1440) {
                System.out.print(-1);
                return;
            } else {
                pq.offer(snow);
            }
        }

        int time = 0;
        while (!pq.isEmpty()) {
            int snow1 = pq.poll();
            if (pq.isEmpty()) time += snow1;
            else {
                int snow2 = pq.poll();
                pq.add(snow1 - snow2);
                time += snow2;
            }
        }
        System.out.print(time <= 1440 ? time : -1);
    }
}
