import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2668 {
    static int[] numbers;
    static int N;

    static boolean[] visited;
    static boolean[] answer;
    static int answerCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        answer = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answerCount).append("\n");
        for (int i = 1; i <= N; i++) {
            if (answer[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int start, int end) {
        if (numbers[start] == end) {
            visited[numbers[start]] = true;
            for (int i = 1; i <= N; i++) {
                if (answer[i]) continue;
                if (visited[i]) {
                    answerCount++;
                    answer[i] = true;
                }
            }
            return;
        }

        if (!visited[numbers[start]]) {
            visited[numbers[start]] = true;
            dfs(numbers[start], end);
            visited[numbers[start]] = false;
        }
    }
}
