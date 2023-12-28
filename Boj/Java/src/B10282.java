import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new int[]{a, s});
            }

            int[] distance = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[c] = 0;

            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            queue.offer(new int[]{c, 0});

            while(!queue.isEmpty()) {
                int[] now = queue.poll();

                if (distance[now[0]] < now[1]) continue;

                for (int[] next : graph[now[0]]) {
                    if (distance[next[0]] > now[1] + next[1]) {
                        distance[next[0]] = now[1] + next[1];
                        queue.offer(new int[]{next[0], now[1] + next[1]});
                    }
                }
            }

            int count = 0;
            int time = 0;
            for (int dist : distance) {
                if (dist != Integer.MAX_VALUE) {
                    count++;
                    time = Math.max(time, dist);
                }
            }

            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.print(sb);
    }
}
