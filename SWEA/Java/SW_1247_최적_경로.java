import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1247_최적_경로 {
    static int N;
    static int[] company, house, visited;
    static List<int[]> guests;
    static int distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            company = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            house = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            visited = new int[N];
            guests = new ArrayList<>();
            for (int i = 0; i < N; i++){
                guests.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            distance = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++){
                visited[i] = 1;
                dfs(i, 1, getDist(company, guests.get(i)));
                visited[i] = 0;
            }
            sb.append("#").append(tc).append(" ").append(distance).append("\n");
        }
        System.out.println(sb);
    }
    static int getDist(int[] src, int[] dst){
        return Math.abs(src[0] - dst[0]) + Math.abs(src[1] - dst[1]);
    }

    static void dfs(int idx, int count, int dist){
        if (count == N){
            distance = Math.min(distance, dist + getDist(guests.get(idx), house));
            return;
        }
        for (int i = 0; i < N; i++){
            if (visited[i] == 1) continue;
            visited[i] = 1;
            dfs(i, count + 1, dist + getDist(guests.get(idx), guests.get(i)));
            visited[i] = 0;
        }
    }
}
