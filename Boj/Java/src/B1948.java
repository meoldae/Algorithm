import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        ArrayList<int[]>[] reversed = new ArrayList[N + 1];
        int[] count = new int[N + 1];
        int[] degree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reversed[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[src].add(new int[]{dst, cost});
            reversed[dst].add(new int[]{src, cost});
            degree[dst]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int[] next : graph[now]) {
                count[next[0]] = Math.max(count[next[0]], count[now] + next[1]);
                degree[next[0]]--;
                if (degree[next[0]] == 0) {
                    queue.offer(next[0]);
                }
            }
        }
        int loads = 0;

        queue = new LinkedList<>();
        queue.offer(end);
        boolean[] visited = new boolean[N + 1];

        // 역추적하면서 가중치 뺐을 때 최대값인 노드만 방문 하도록 ( 중복 제거 )
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now]) continue;
            visited[now] = true;

            for (int[] before : reversed[now]) {
                if (count[before[0]] == count[now] - before[1]) {
                    queue.add(before[0]);
                    loads++;
                }
            }
        }
        System.out.println(count[end]);
        System.out.print(loads);
    }
}