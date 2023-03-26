import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < N; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[V];
            for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken()) - 1;
                int dst = Integer.parseInt(st.nextToken()) - 1;
                graph[src].add(dst);
                graph[dst].add(src);
            }

            sb.append(bfs(graph) ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    static boolean bfs(List<Integer>[] graph){
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int v = 0; v < graph.length; v++){
            if (visited[v] == 0){
                queue.add(v);
                visited[v] = 1;
            }
            while(!queue.isEmpty()){
                int now = queue.poll();

                for (int next : graph[now]) {
                    if (visited[next] == visited[now]) return false;

                    if (visited[next] == 0) {
                        visited[next] = visited[now] * -1;
                        queue.add(next);
                    }
                }
            }
        }
        return true;
    }
}
