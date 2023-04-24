import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] distance = new int[N + 1];
        List<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{cost, B});
            graph[B].add(new int[]{cost, A});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        distance[1] = 0;
        pq.offer(new int[]{1, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int[] next : graph[now[0]]) {
                if (now[1] + next[0] < distance[next[1]]) {
                    distance[next[1]] = now[1] + next[0];
                    pq.offer(new int[]{next[1], now[1] + next[0]});
                }
            }
        }

        System.out.print(distance[N]);
    }
}
