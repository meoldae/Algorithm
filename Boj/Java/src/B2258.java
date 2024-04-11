import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] meats = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meats[i][0] = Integer.parseInt(st.nextToken());
            meats[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meats, (o1, o2) -> {
            if (o1[1] == o2[1]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });

        int weightSum = 0;
        int priceSum = 0;
        int answer = Integer.MAX_VALUE;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            weightSum += meats[i][0];

            if (prev < meats[i][1]) prev = priceSum = meats[i][1];
            else priceSum += meats[i][1];

            if (weightSum >= M) {
                answer = Math.min(answer, priceSum);
            }
        }
        System.out.print(weightSum >= M ? answer : -1);
    }
}