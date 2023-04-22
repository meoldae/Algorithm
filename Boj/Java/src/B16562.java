import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16562 {
    static int[] p, friendsFee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        friendsFee = new int[N];
        p = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            friendsFee[i] = Integer.parseInt(st.nextToken());
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            union(v, w);
        }

        boolean[] visited = new boolean[N];
        int fee = 0;
        for (int i = 0; i < N; i++) {
            int now = find(i);
            if (visited[now]) continue;
            visited[now] = true;
            fee += friendsFee[now];
        }
        if (fee > K) System.out.print("Oh no");
        else System.out.print(fee);
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (!isSameParent(x, y)) {
            if (friendsFee[x] <= friendsFee[y]) p[y] = x;
            else p[x] = y;
        }
    }

    static boolean isSameParent(int x, int y){
        return p[x] == p[y];
    }
}
