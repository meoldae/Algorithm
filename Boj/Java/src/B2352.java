import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ports = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ports[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N + 1];

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (lis[count] < ports[i]) { // 증가 수열
                lis[++count] = ports[i];
            } else { // 아닐 때 해당 원소 위치 찾음
                int idx = binarySearch(lis, count, ports[i]);
                lis[idx] = ports[i];
            }
        }
        System.out.print(count);
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
