import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        ArrayList<Integer>[] relation = new ArrayList[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) relation[i] = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            relation[parent].add(child);
            relation[child].add(parent);
        }
        Queue<int[]> queue = new LinkedList<>();
        visited[a] = true;
        queue.offer(new int[]{a, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == b) {
                System.out.print(now[1]);
                return;
            }
            for (int next : relation[now[0]]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(new int[]{next, now[1] + 1});
            }
        }
        System.out.print(-1);
    }
}