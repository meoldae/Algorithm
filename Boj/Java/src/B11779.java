import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11779 {
    static class Node {
        int location;
        int cost;

        public Node(int location, int cost) {
            this.location = location;
            this.cost = cost;
        }
    }

    static long[] distance;
    static int[][] route;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        route = new int[N][N];
        distance = new long[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if (route[src][dst] == 0) route[src][dst] = cost;
            else route[src][dst] = Math.min(route[src][dst], cost);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(start, end);
    }

    public static void dijkstra(int start, int end) {
        int[] path = new int[N];
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        heap.add(new Node(start, 0));
        distance[start] = 0;

        while (!heap.isEmpty()) {
            Node now = heap.poll();
            int dist = now.cost;
            int loca = now.location;

            if (distance[loca] < dist) {
                continue;
            }

            for (int i = 0; i < N; i++) {
                if (route[loca][i] == 0) continue;
                int nextCost = dist + route[loca][i];
                if (nextCost <= distance[i]) {
                    distance[i] = nextCost;
                    path[i] = now.location;
                    heap.add(new Node(i, nextCost));
                }
            }
        }
        System.out.println(distance[end]);
        int count = 1;
        for (int i = end; i != 0; i = path[i]){
            sb.append(i+1).append(" ");
            count++;
        }
        sb.append(start+1);
        sb.reverse();
        sb.insert(0, count+"\n");
        System.out.println(sb);
    }
}