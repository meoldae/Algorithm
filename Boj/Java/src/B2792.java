import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];
        int left = 0;
        int right = 0;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, jewels[i]);
        }

        while(left < right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 0; i < M; i++){
                count += Math.ceil(jewels[i] / (mid*1.0));
            }
            if (count > N) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        System.out.print(right);
    }
}
