import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7511 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("Scenario ").append(t).append(":\n");
            int n = Integer.parseInt(br.readLine());
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (!isSameParent(a, b)) {
                    union(a, b);
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int result = isSameParent(u, v) ? 1 : 0;
                sb.append(result).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int find(int x){
        if (p[x] == x) return p[x];
        return p[x] = find(p[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    public static boolean isSameParent(int x, int y){
        return find(x) == find(y);
    }
}
