import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        int[] pattern = new int[N];

        int j = 0;
        for (int i = 1; i < N; i++) {
            while (j > 0 & S[i] != S[j]) j = pattern[j - 1];

            if (S[i] == S[j]) pattern[i] = ++j;
            else pattern[i] = 0;
        }
        System.out.print(N - pattern[N - 1]);
    }
}