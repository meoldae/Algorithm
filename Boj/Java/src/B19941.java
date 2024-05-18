import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] bench = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (bench[i] == 'P') {
                int start = Math.max(i - k, 0);
                for (int j = start; j <= Math.min(i + k, n - 1); j++) {
                    if (bench[j] == 'H') {
                        bench[j] = 'X';
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
