import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chef = new int[n][2];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            chef[i][0] = Integer.parseInt(st.nextToken());
            chef[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << n); i++){
            int sour = 1;
            int bitter = 0;
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) != 0){
                    sour *= chef[j][0];
                    bitter += chef[j][1];
                }
            }
            answer = Math.min(answer, Math.abs(sour - bitter));
        }
        System.out.println(answer);
    }
}

