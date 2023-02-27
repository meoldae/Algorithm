import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D4_7465_창용_마을_무리의_개수 {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = new int[N];
            for (int i = 0; i < N; i++) p[i] = i;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                union(a, b);
            }
            Set<Integer> town = new HashSet<>();
            for (int i = 0; i < N; i++) town.add(find(i));
            sb.append("#").append(tc).append(" ").append(town.size()).append("\n");
        }
        System.out.print(sb);
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
