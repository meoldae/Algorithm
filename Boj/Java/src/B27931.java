import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B27931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[N];
        int odd = Integer.MAX_VALUE;
        int even = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) points[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(points);

        int prevOdd = 0;
        int prevEven = 0;
        if (points[0] % 2 == 0) prevEven = points[0];
        else prevOdd = points[0];
        for (int i = 1; i < N; i++) {
            if (points[i] % 2 == 0) {
                if (prevEven != 0) even = Math.min(even, points[i] - prevEven);
                if (prevOdd != 0) odd = Math.min(odd, points[i] - prevOdd);
                prevEven = points[i];
            } else {
                if (prevOdd != 0) even = Math.min(even, points[i] - prevOdd);
                if (prevEven != 0) odd = Math.min(odd, points[i] - prevEven);
                prevOdd = points[i];
            }
        }
        System.out.print((even != Integer.MAX_VALUE) ? even : -1);
        System.out.print(" ");
        System.out.print((odd != Integer.MAX_VALUE) ? odd : -1);
    }
}