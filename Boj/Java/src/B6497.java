import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B6497 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) {
                System.out.print(sb);
                return;
            }

            p = new int[m];
            for (int i = 0; i < m; i++) p[i] = i;

            PriorityQueue<int[]> roads = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            int total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int h1 = Integer.parseInt(st.nextToken());
                int h2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                total += cost;

                roads.offer(new int[]{h1, h2, cost});
            }

            int count = 0;
            int result = 0;
            while (!roads.isEmpty() && count < m) {
                int[] now = roads.poll();

                if (isSameParent(now[0], now[1])) continue;

                union(now[0], now[1]);
                result += now[2];
                count++;
            }
            sb.append(total - result);
            sb.append("\n");
        }
    }

    public static int find(int x) {
        if (p[x] == x) return x;
        else return p[x] = find(p[x]);
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