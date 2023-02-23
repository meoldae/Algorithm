import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
    static HashSet<Integer>[] graph;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken()) - 1;
        graph = new HashSet[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) graph[i] = new HashSet<Integer>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            graph[src].add(dst);
            graph[dst].add(src);
        }
        dfs(V);
        sb.append("\n");
        bfs();
        System.out.print(sb);
    }

    static void bfs() {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + 1).append(" ");
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    static void dfs(int now) {
        visit[now] = true;
        sb.append(now+1).append(" ");
        for (int next : graph[now]){
            if (!visit[next]){
                dfs(next);
            }
        }
    }
}
