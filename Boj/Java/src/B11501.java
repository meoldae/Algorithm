import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] stocks = new long[n];
            for (int i = 0; i < n; i++) stocks[i] = Long.parseLong(st.nextToken());

            long answer = 0;
            long price = stocks[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (stocks[i] <= price)  answer += price - stocks[i];
                else price = stocks[i];
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
