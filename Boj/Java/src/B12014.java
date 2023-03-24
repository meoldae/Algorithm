import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] stocks = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) stocks[i] = Integer.parseInt(st.nextToken());

            int[] lis = new int[N + 1];
            int count = 0;
            for (int stock : stocks) {
                if (lis[count] < stock) {
                    lis[++count] = stock;
                } else {
                    int idx = binarySearch(lis, count, stock);
                    lis[idx] = stock;
                }
            }
            sb.append("Case #").append(tc).append("\n");
            sb.append((count >= K) ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

    static int binarySearch(int[] lis, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}