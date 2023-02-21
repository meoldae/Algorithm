import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
    static int n, count;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queens = new int[n];
        backTrack(0);
        System.out.println(count);
    }

    static void backTrack(int now) {
        if (now == n) {
            count++;
            return;
        }
        outer:
        for (int i = 0; i < n; i++) {
            queens[now] = i;
            for (int j = 0; j < now; j++) {
                if (queens[now] == queens[j] || Math.abs(now - j) == Math.abs(queens[now] - queens[j])) continue outer;
            }
            backTrack(now + 1);
        }
    }
}