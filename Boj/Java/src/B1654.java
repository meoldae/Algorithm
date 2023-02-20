import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cables = new int[k];
        for (int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }
        long left = 1;
        long mid = 0;
        long right = (long) Arrays.stream(cables).max().getAsInt();
        while (left <= right) {
            mid = (left + right) / 2;
            int count = 0;
            for (int cable : cables) count += cable / mid;
            if (count >= n) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(right);
    }
}
