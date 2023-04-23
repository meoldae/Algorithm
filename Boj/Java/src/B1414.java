import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1414 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new int[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int totalCable = 0;
        for (int i = 0; i < N; i++) {
            p[i] = i;
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                int cable = input[j];
                if (cable == 48) continue;

                if (cable >= 97) cable -= 96;
                else if (cable >= 65) cable -= 38;

                if (cable != 0) pq.add(new int[]{cable, i, j});
                totalCable += cable;
            }
        }
        while (N - 1 > 0 && !pq.isEmpty()) {
            int[] now = pq.poll();
            if (!isSameParent(now[1], now[2])) {
                N--;
                totalCable -= now[0];
                union(now[1], now[2]);
            }
        }
        if (N > 1) System.out.print(-1);
        else System.out.print(totalCable);
    }

    static int find(int x){
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    static boolean isSameParent(int x, int y){
        return p[find(x)] == p[find(y)];
    }
}