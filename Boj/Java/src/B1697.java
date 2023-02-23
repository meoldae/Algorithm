import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[200001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N] = 1;
        int[] direction = new int[]{1, -1, 2};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == K) {
                System.out.print(now[1]);
                break;
            }
            for (int d : direction) {
                int next;
                if (d == 2 && now[0] > 0) next = now[0] * d;
                else next = now[0] + d;

                if (0 <= next && next <= 100000 && visited[next] == 0) {
                    visited[next] = 1;
                    queue.offer(new int[]{next, now[1] + 1});
                }
            }
        }
    }
}
