import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] stations = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) stations[i] = Integer.parseInt(st.nextToken());
        stations[0] = 0;
        stations[N + 1] = L;
        Arrays.sort(stations);

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int additional = 0;

            for (int i = 1; i < stations.length; i++) {
                int distance = stations[i] - stations[i - 1];
                if (distance / mid > 0) {
                    if (distance % mid == 0) additional += (distance / mid) - 1;
                    else additional += distance / mid;
                }
            }

            if (additional > M) left = mid + 1;
            else right = mid - 1;
        }
        System.out.print(left);
    }
}
