import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B18352 {
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        String answer = dijkstra(N, X, K);
        System.out.print(answer.length() == 0 ? -1 : answer);
    }

    public static String dijkstra(int N, int start, int K) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{start, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int next : graph[now[0]]) {
                if (distance[next] > now[1] + 1) {
                    distance[next] = now[1] + 1;
                    queue.offer(new int[]{next, now[1] + 1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) sb.append(i).append("\n");
        }
        return sb.toString();
    }
}
