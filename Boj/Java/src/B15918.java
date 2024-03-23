import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15918 {
    static int N, answer;
    static boolean[] visited;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        selected = new int[2 * N];

        selected[x - 1] = selected[y - 1] = y - x - 1;
        visited[y - x - 1] = true;

        dfs(0);

        System.out.print(answer);
    }

    static void dfs(int count) {
        if (count == 2 * N) {
            answer++;
            return;
        }

        if (selected[count] == 0) {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (count + i + 1 < 2 * N && selected[count + i + 1] == 0) {
                        selected[count] = selected[count + i + 1] = i;
                        visited[i] = true;
                        dfs(count + 1);
                        selected[count] = selected[count + i + 1] = 0;
                        visited[i] = false;
                    }
                }
            }
        } else {
            dfs(count + 1);
        }
    }
}