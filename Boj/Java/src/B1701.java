import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();

        int answer = 0;
        for (int start = 0; start < S.length; start++) {
            int j = 0;
            int[] pattern = new int[S.length];

            for (int i = 1; i < S.length; i++) {
                if (start + j >= S.length || start + i >= S.length) break;

                while(j > 0 && S[i + start] != S[j + start]) j = pattern[j - 1];
                if (S[i + start] == S[j + start]) pattern[i] = ++j;
                else pattern[i] = 0;
                answer = Math.max(answer, j);
            }
        }
        System.out.print(answer);
    }
}
