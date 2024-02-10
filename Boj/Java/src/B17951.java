import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] papers = new int[N];
        st = new StringTokenizer(br.readLine());
        int right = 0;
        for (int i = 0; i < N; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
            right += papers[i];
        }

        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int group = 0;
            int score = 0;

            for (int correct : papers) {
                score += correct;
                if (score >= mid) {
                    group++;
                    score = 0;
                }
            }

            if (group >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }
}
