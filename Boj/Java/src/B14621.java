import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B14621 {
    static int N;
    static int M;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        p = new int[N];
        for (int i = 0; i < N; i++){
            p[i] = i;
        }

        String[] schools = br.readLine().split(" ");

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            int d = Integer.parseInt(input[2]);
            pq.add(new int[]{u, v, d});
        }

        int connected = 1;
        int answer = 0;
        while (!pq.isEmpty() && connected < N) {
            int[] temp = pq.poll();
            if (!schools[temp[0]].equals(schools[temp[1]])) {
                if (!isSameParent(temp[0], temp[1])) {
                    union(temp[0], temp[1]);
                    answer += temp[2];
                    connected++;
                }
            }
        }
        if (connected < N) System.out.print(-1);
        else System.out.print(answer);
    }

    static int find(int x){
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
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
