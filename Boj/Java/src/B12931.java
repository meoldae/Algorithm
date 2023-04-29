import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        int count = 0;
        while (true) {
            int odd = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((nums[i] & 1) == 1) {
                    nums[i] -= 1;
                    odd++;
                }
                sum += nums[i];
            }
            if (odd > 0) count += odd;
            else {
                sum = 0;
                for (int i = 0; i < N; i++) {
                    nums[i] >>= 1;
                    sum += nums[i];
                }
                if (sum != 0) count++;
            }
            if (sum == 0) break;
        }
        System.out.print(count);
    }
}
