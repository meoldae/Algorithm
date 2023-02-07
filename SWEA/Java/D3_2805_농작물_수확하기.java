import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2805_농작물_수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {

            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            // 위 절반
            for (int i = 0; i < n / 2; i++) {
                char[] arr = br.readLine().toCharArray();
                int range = 2 * i + 1;
                for (int j = 0; j < range; j++) {
                    sum += arr[n / 2 + j - i] - '0';
                }
            }
            // 가운데
            char[] arr = br.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                sum += arr[i] - '0';
            }
            // 아래 절반
            for (int i = n - (n / 2); i < n; i++) {
                arr = br.readLine().toCharArray();
                int range = (2*(n-(i+1))) + 1;
                for (int j = 0; j < range; j++) {
                    sum += arr[n / 2 + j - (n-i-1)] - '0';
                }

            }
            System.out.printf("#%d %d%n", tc, sum);
        }
    }
}
