import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3124_최소_스패닝_트리 {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            p = new int[V];
            int[][] list = new int[E][];
            for (int i = 0; i < V; i++) p[i] = i;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                list[i] = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};
            }
            Arrays.sort(list, (o1, o2) -> o1[2] - o2[2]);

            long answer = 0;
            for (int[] edge : list) {
                if (!isSameParent(edge[0], edge[1])) {
                    union(edge[0], edge[1]);
                    answer += (long) edge[2];
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (!isSameParent(x, y)) {
            if (x <= y) p[y] = x;
            else p[x] = y;
        }
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
