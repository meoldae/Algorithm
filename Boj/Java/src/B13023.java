import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13023 {
    static ArrayList<ArrayList<Integer>> friends;
    static boolean[] visited;
    static int n, m;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        friends = new ArrayList<>();
        for (int i = 0; i < n; i++){
            friends.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
        }
        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(int now, int count) {
        if (flag) return;
        if (count == 5) {
            flag = true;
            return;
        }
        visited[now] = true;
        for (int next : friends.get(now)) {
            if (visited[next]) continue;
            dfs(next, count + 1);
        }
        visited[now] = false;
    }
}