import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snacks = new int[N];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);

        int left = 1;
        int right = snacks[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int snack : snacks) {
                count += snack / mid;
            }

            if (count >= M) left = mid + 1;
            else right = mid - 1;
        }
        System.out.print(right);
    }
}
