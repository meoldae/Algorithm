import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13905 {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{h1, h2, k});
        }

        int answer = Integer.MAX_VALUE;
        boolean flag = false;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (!isSameParent(now[0], now[1])) {
                union(now[0], now[1]);
                answer = Math.min(answer, now[2]);
            }
            if (isSameParent(s, e)) {
                flag = true;
                break;
            }
        }
        System.out.print(flag ? answer : 0);
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

    public static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
