import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2412 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[200001];
        for (int i = 0; i <= 200000; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y].add(x);
        }

        for (int i = 0; i <= 200000; i++) graph[i].sort((o1, o2) -> o1 - o2);

        int answer = Integer.MAX_VALUE;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] == T) {
                answer = now[2];
                break;
            }

            for (int j = now[1] - 2; j <= now[1] + 2; j++) {
                if (j < 0 || 200000 < j) continue;

                for (int i = 0; i < graph[j].size(); i++) {
                    if (graph[j].get(i) > now[0] + 2) break;
                    else if (graph[j].get(i) < now[0] - 2) continue;
                    queue.offer(new int[]{graph[j].get(i), j, now[2] + 1});
                    graph[j].remove(i--);
                }
            }
        }
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
