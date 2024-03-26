import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11085 {
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        P = new int[p];
        for (int i = 0; i < p; i++) {
            P[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{s, e, cost});
        }

        int answer = 1000;
        while (!isSameParent(c, v)) {
            int[] road = pq.poll();
            if (isSameParent(road[0], road[1])) continue;
            union(road[0], road[1]);
            answer = Math.min(answer, road[2]);
        }
        System.out.print(answer);
    }

    static int find(int x) {
        if (x == P[x]) return x;
        else return P[x] = find(P[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) P[y] = x;
        else P[x] = y;
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
