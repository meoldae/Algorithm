import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16719 {
    static boolean[] visited;
    static char[] s;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();
        visited = new boolean[s.length];

        dfs(0, s.length);

        System.out.print(answer);
    }

    public static void dfs(int left, int right) {
        int idx = left;

        for (int i = left; i < right; i++) {
            if (visited[i]) continue;
            if (s[idx] > s[i]) {
                idx = i;
            }
        }

        if(visited[idx]) return;

        visited[idx] = true;
        for (int i = 0; i < s.length; i++) {
            if (visited[i]) answer.append(s[i]);
        }

        answer.append("\n");

        if (idx < right - 1) dfs(idx + 1, right);
        dfs(left, idx);
    }
}