import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(st.nextToken()));

            Deque<Integer> skip = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if ((i & 1) == 1) skip.offerFirst(pq.poll());
                else skip.offerLast(pq.poll());
            }

            int first = 0;
            int prev = 0;
            int answer = 0;
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    first = skip.pollFirst();
                    prev = first;
                } else {
                    int now = skip.pollFirst();
                    answer = Math.max(answer, Math.abs(now - prev));
                    prev = now;
                }
            }
            answer = Math.max(answer, Math.abs(first - prev));
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
