import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805 {
    static int M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(trees);
        System.out.print(binarySearch(1, trees[N - 1]));
    }

    static int binarySearch(int left, int right) {
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long target = 0;

            for (int tree : trees) if (tree > mid) target += tree - mid;
            if (target > M) left = mid + 1;
            else if (target < M) right = mid - 1;
            else return mid;
        }
        return right;
    }
}
