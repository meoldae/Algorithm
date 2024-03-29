import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        int[] types = new int[d + 1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            if (types[sushi[i]]++ == 0) result++;
        }

        int answer = types[c] == 0 ? result + 1 : result;
        int left = 0;
        int right = k;
        while (left < n) {
            if (--types[sushi[left++]] == 0) result--;
            if (types[sushi[(right++) % n]]++ == 0) result++;
            answer = Math.max(answer, types[c] == 0 ? result + 1 : result);
        }
        System.out.print(answer);
    }
}