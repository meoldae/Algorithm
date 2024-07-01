import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] inkScore = new long[N];
        long[] viscosity = new long[N];

        for (int i = 0; i < N; i++) inkScore[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) viscosity[i] = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(binarySearch(i, N - 1, inkScore[i], viscosity) - i).append(" ");
        }
        System.out.print(sb);
    }

    public static int binarySearch(int left, int right, long ink, long[] viscosity) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (viscosity[mid] <= ink) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}