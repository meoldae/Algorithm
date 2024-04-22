import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18429 {
    static int N, K, answer;
    static boolean[] visited;
    static int[] kit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        kit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) kit[i] = Integer.parseInt(st.nextToken());
        exercise(0, 500);
        System.out.print(answer);
    }

    public static void exercise(int day, int weight) {
        if (weight < 500) return;

        if (day >= N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                exercise(day + 1, weight - K + kit[i]);
                visited[i] = false;
            }
        }
    }
}