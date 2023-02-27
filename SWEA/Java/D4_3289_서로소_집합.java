import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소_집합 {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = new int[N + 1];
            for (int i = 0; i < N + 1; i++) p[i] = i;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                if (Integer.parseInt(st.nextToken()) == 0){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (!isSameParent(a, b)) union(a, b);
                }else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (isSameParent(a, b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
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

        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
