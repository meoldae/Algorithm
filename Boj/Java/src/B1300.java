import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = K;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            // 핵심 : Mid 보다 작은 원소를 구하는 방법
            for (int i = 1; i <= N; i++) count += Math.min(mid / i, N);

            if (count >= K) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        System.out.print(left);
    }
}
