import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] mileage = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            if (p < l) {
                mileage[i] = 1;
                continue;
            }

            int[] subject = new int[p];
            for (int j = 0; j < p; j++) subject[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(subject);
            mileage[i] = subject[p - l];
        }

        int answer = 0;
        Arrays.sort(mileage);
        for (int s : mileage) {
            m -= s;
            if (m >= 0) answer++;
            else break;
        }
        System.out.print(answer);
    }
}
