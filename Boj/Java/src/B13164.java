import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] diff = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            int next = Integer.parseInt(st.nextToken());
            diff[i] = next - now;
            now = next;
        }

        Arrays.sort(diff);
        int answer = 0;
        for (int i = 0; i < N - K; i++) answer += diff[i];
        System.out.print(answer);
    }
}
