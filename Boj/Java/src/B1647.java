import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B1647 {
    static int[] parent;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        IntStream.range(0, n).forEach(num -> parent[num] = num);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{src, dst, cost});
        }
        int load = 0;
        int totalCost = 0;
        while (load < n - 2) {
            int[] now = pq.poll();
            if (!isSameParent(now[0], now[1])){
                union(now[0], now[1]);
                totalCost += now[2];
                load++;
            }
        }
        System.out.println(totalCost);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) parent[y] = x;
        else parent[x] = y;
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
