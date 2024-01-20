import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13424 {
    static List<int[]>[] graph;
    static int[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new int[]{b, c});
                graph[b].add(new int[]{a, c});
            }

            int K = Integer.parseInt(br.readLine());
            friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            int result = Integer.MAX_VALUE;
            int secretRoom = 0;
            for (int i = 1; i <= N; i++) {
                int totalCost = dijkstra(i);
                if (result > totalCost) {
                    secretRoom = i;
                    result = totalCost;
                }
            }
            sb.append(secretRoom).append("\n");
        }
        System.out.print(sb);
    }

    public static int dijkstra(int start) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int[] road : graph[now[0]]) {
                if (distance[road[0]] <= now[1] + road[1]) continue;

                distance[road[0]] = now[1] + road[1];
                queue.offer(new int[]{road[0], now[1] + road[1]});
            }
        }

        int sum = 0;
        for (int k : friends) {
            sum += distance[k];
        }

        return sum;
    }
}
