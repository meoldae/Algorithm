import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph[src].add(new int[]{dst, cost});
        }

        int[] distance = new int[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (distance[now[0]] < now[1]) continue;

            for (int[] e : graph[now[0]]) {
                if (now[1] + e[1] < distance[e[0]]){
                    distance[e[0]] = now[1] + e[1];
                    pq.offer(new int[]{e[0], now[1] + e[1]});
                }
            }
        }
        for (int dist : distance) {
            System.out.println((dist != Integer.MAX_VALUE) ? dist : "INF");
        }
    }
}
