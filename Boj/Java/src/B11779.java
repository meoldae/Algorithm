import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11779 {
    static ArrayList<ArrayList<int[]>> graph;
    static int[] path;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        path = new int[n];
        graph = new ArrayList<>();
        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int e = Integer.parseInt(st.nextToken()) - 1;
        dijkstra(s, e);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int dist = now[1];
            int location = now[0];

            if (distance[location] < dist) {
                continue;
            }
            for (int[] next : graph.get(location)) {
                int nextCost = dist + next[1];
                if (nextCost < distance[next[0]]) {
                    distance[next[0]] = nextCost;
                    path[next[0]] = location;
                    pq.add(new int[]{next[0], nextCost});
                }
            }
        }
        System.out.println(distance[end]);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = end; i != start; i = path[i]) {
            stack.push(i+1);
            count++;
        }
        System.out.println(count+1);
        sb.append(start+1).append(" ");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}