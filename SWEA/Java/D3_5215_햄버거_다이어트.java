import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거_다이어트 {
    static class Ingredient{
        int score;
        int calorie;

        public Ingredient(int score, int calorie) {
            this.score = score;
            this.calorie = calorie;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Ingredient[] arr = new Ingredient[n];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i] = new Ingredient(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            int answer = 0;
            for (int i = 0; i < (1 << n); i++) {
                int score = 0;
                int calorie = 0;
                for (int j = 0; j < n; j++){
                    if ((i & (1 << j)) != 0) {
                        calorie += arr[j].calorie;
                        score += arr[j].score;
                    }
                }
                if (calorie <= l) answer = Math.max(answer, score);
            }
            System.out.printf("#%d %d%n", tc, answer);
        }
    }
}
