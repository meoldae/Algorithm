import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] lights = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lights);

        int left = 1;
        int right = N;

        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            boolean flag = true;
            int prev = 0;

            for (int light : lights) {
                if (light - mid <= prev) prev = light + mid;
                else {
                    flag = false;
                    break;
                }
            }

            if (flag && prev >= N) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}
