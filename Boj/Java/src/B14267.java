import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] company = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) company[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss == -1) continue;
            company[boss].add(i);
        }

        int[] point = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            point[no] += w;
        }

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i <= n; i++) {
            if (point[i] != 0) {
                pq.offer(new int[]{i, point[i]});
            }
        }

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int sub : company[now[0]]) {
                point[sub] += now[1];
                pq.offer(new int[]{sub, now[1]});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(point[i]).append(" ");
        System.out.print(sb);
    }
}
