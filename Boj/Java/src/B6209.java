import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B6209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(stones);

        int left = 0;
        int right = d;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            int now = 0;
            for (int stone : stones) {
                if (stone - now < mid) count++;
                else now = stone;
            }
            if (count <= m) left = mid + 1;
            else right = mid - 1;
        }
        System.out.print(left - 1);
    }
}
