import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14248 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stones = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        visited[s] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);

        int answer = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();

            int nextRight = now + stones[now];
            if (nextRight <= n && !visited[nextRight]) {
                visited[nextRight] = true;
                queue.offer(nextRight);
                answer++;
            }

            int nextLeft = now - stones[now];
            if (0 < nextLeft && !visited[nextLeft]) {
                visited[nextLeft] = true;
                queue.offer(nextLeft);
                answer++;
            }
        }
        System.out.print(answer);
    }
}

