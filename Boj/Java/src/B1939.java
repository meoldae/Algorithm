import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1939 {
    static List<int[]>[] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = 0;

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[src].add(new int[]{dst, cost});
            graph[dst].add(new int[]{src, cost});
            right = Math.max(right, cost);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(mid, start, end)) left = mid + 1;
            else right = mid - 1;
        }
        System.out.print(right);
    }

    static boolean bfs(int mid, int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) return true;

            for (int[] next : graph[now]) {
                if (!visited[next[0]] && next[1] >= mid) {
                    visited[next[0]] = true;
                    queue.offer(next[0]);
                }
            }
        }
        return false;
    }
}
