import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<int[]>[] networks = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) networks[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            networks[p].add(new int[]{q, r});
            networks[q].add(new int[]{p, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int count = 0;

            boolean[] visited = new boolean[N + 1];
            visited[v] = true;

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{v, Integer.MAX_VALUE});
            while(!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] != v && now[1] >= k) count++;

                for (int[] next : networks[now[0]]) {
                    if (visited[next[0]]) continue;
                    visited[next[0]] = true;
                    queue.offer(new int[]{next[0], Math.min(now[1], next[1])});
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
