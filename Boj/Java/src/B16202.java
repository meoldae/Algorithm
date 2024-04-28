import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B16202 {
    static int N, M, K;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<int[]> graph = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.add(new int[]{x, y, i});
        }

        graph.sort((o1, o2) -> o1[2] - o2[2]);

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < K; k++) {
            sb.append(getMST(graph)).append(" ");
            graph.remove(0);
        }
        System.out.print(sb);
    }

    static int getMST(List<int[]> graph) {
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) p[i] = i;

        int result = 0;
        int count = 1;
        for (int[] g : graph) {
            if (isSameParent(g[0], g[1])) continue;
            union(g[0], g[1]);
            result += g[2];
            if (++count >= N) break;
        }
        return count >= N ? result : 0;
    }

    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    static boolean isSameParent(int x, int y){
        return find(x) == find(y);
    }
}
