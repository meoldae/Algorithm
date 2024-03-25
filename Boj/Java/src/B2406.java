import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2406 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (!isSameParent(x, y)) union(x, y);
        }

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 1) continue;
            for (int j = 1; j <= n; j++) {
                int network = Integer.parseInt(st.nextToken());
                if (i == j || j == 1) continue;
                pq.offer(new int[]{i, j, network});
            }
        }

        StringBuilder sb = new StringBuilder();
        int answer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] relation = pq.poll();
            if (isSameParent(relation[0], relation[1])) continue;
            answer += relation[2];
            count++;
            union(relation[0], relation[1]);
            sb.append(relation[0]).append(" ").append(relation[1]).append("\n");
        }
        sb.insert(0, "\n").insert(0, count).insert(0, " ").insert(0, answer);
        System.out.print(sb);
    }

    static int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
