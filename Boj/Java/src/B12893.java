import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B12893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] friends = new int[n + 1];

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int start = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
            start = a;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        if (start != 0) {
            queue.offer(start);
            friends[start] = 1;
        }

        boolean flag = true;

        outer:
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (friends[now] == friends[next]) {
                    flag = false;
                    break outer;
                }

                if (friends[next] == 0){
                    friends[next] = friends[now] * -1;
                    queue.offer(next);
                }
            }
        }
        System.out.print(flag ? 1 : 0);
    }
}