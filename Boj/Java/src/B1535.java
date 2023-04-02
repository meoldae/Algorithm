import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] HP = new int[N+1];
        int[] happy = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) HP[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) happy[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[100];

        for (int i = 1; i <= N; i++){
            for (int j = 99; j > 0; j--){
                if (j < HP[i]) break;
                dp[j] = Math.max(dp[j], dp[j - HP[i]] + happy[i]);
            }
        }
        System.out.println(dp[99]);
    }
}
