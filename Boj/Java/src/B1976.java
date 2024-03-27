import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // if (i == j) continue; 이 구문때문에 String Token 이 온전히 소모되지 않았다.

                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = Integer.parseInt(st.nextToken());
        boolean flag = true;

        while(st.hasMoreTokens()) {
            int city = Integer.parseInt(st.nextToken());
            if (!isSameParent(root, city)) {
                flag = false;
                break;
            }
        }
        System.out.print(flag ? "YES" : "NO");
    }

    static int find(int x) {
        if (x == p[x]) return p[x];
        else return p[x] = find(p[x]);
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
