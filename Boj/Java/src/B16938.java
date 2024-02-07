import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] problems = new int[N];
        for (int i = 0; i < N; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < Math.pow(2, N); i++) {
            int min = 0;
            int max = 0;
            int count = 0;
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if (((i >> j) & 1) == 1) {
                    if (min == 0) min = problems[j];
                    else min = Math.min(min, problems[j]);
                    if (max == 0) max = problems[j];
                    else max = Math.max(max, problems[j]);
                    sum += problems[j];
                    count++;
                }
            }
            if (count >= 2 && sum >= L && sum <= R && max-min >= X) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}