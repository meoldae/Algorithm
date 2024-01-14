import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ingredients = new int[N];
        for (int i = 0; i < N; i++) ingredients[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ingredients);

        int left = 0;
        int right = ingredients.length - 1;

        int answer = 0;
        while(left < right) {
            int sum = ingredients[left] + ingredients[right];
            if (sum == M) {
                answer++;
                left++;
                right--;
            } else if (sum > M) {
                right--;
            } else {
                left++;
            }
        }
        System.out.print(answer);
    }
}
