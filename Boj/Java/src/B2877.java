import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class B2877 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[][] planets = new int[n][3];
        for (int i = 0; i < n; i++){
            planets[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // X - Y - Z 축
        for(int i = 0; i < 3; i++){
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < n; j++){
                list.add(new int[]{planets[j][i], j});
            }
            list.sort((o1, o2) -> o1[0] - o2[0]);
            // 정렬 후 바로 옆 행성만 고려
            for (int j = 1; j < n; j++){
                int[] src = list.get(j-1);
                int[] dst = list.get(j);
                pq.add(new int[]{Math.abs(dst[0]-src[0]), src[1], dst[1]});
            }
        }
        int answer = 0;
        int count = 0;
        while(!pq.isEmpty()){
            if (count == n-1) break;
            int[] now = pq.poll();
            if (!isSameParent(now[1], now[2])){
                union(now[1], now[2]);
                answer += now[0];
                count++;
            }
        }
        System.out.print(answer);
    }

    static int find(int x){
        if (parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x <= y){
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
