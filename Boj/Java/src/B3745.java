import java.io.IOException;
import java.util.Scanner;

public class B3745 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int[] chart = new int[N];

            for (int i = 0; i < N; i++) chart[i] = sc.nextInt();

            int[] lis = new int[N + 1];
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (lis[count] < chart[i]) {
                    lis[++count] = chart[i];
                } else {
                    int idx = binarySearch(lis, count, chart[i]);
                    lis[idx] = chart[i];
                }
            }
            sb.append(count).append("\n");
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
