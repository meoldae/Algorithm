import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] answer = new boolean[N + 1];
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int temp = numbers[i];
            while(temp <= N) {
                if (!answer[temp]) {
                    answer[temp] = true;
                    break;
                }
                temp += K;
            }
        }

        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (!answer[i]) {
                flag = false;
                break;
            }
        }

        System.out.print(flag ? 1 : 0);
    }
}
