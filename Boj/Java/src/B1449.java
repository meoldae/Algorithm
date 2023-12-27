import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] leak = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) leak[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(leak);

        int right = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (right <= leak[i]) {
                answer++;
                right = leak[i] + L;
            }
        }
        System.out.print(answer);
    }
}
