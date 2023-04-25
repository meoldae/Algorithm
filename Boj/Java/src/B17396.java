import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B17396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sight = new int[N];
        long[] distance = new long[N];
        List<int[]>[] graph = new ArrayList[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sight[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[1] - o2[1]));
        distance[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] now = pq.poll();

            if (distance[(int) now[0]] < now[1]) continue;

            for (int[] next : graph[(int) now[0]]) {
                if (sight[next[0]] == 1 && next[0] < N - 1) continue;
                if (now[1] + next[1] < distance[next[0]]) {
                    distance[next[0]] = now[1] + (long) next[1];
                    pq.offer(new long[]{next[0], now[1] + next[1]});
                }
            }
        }
        System.out.print(distance[N - 1] == Long.MAX_VALUE ? -1 : distance[N - 1]);
    }
}
