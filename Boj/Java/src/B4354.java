import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] s = br.readLine().toCharArray();
            if ('.' == s[0]) break;

            int[] pattern = new int[s.length];

            int j = 0;
            for (int i = 1; i < s.length; i++) {
                if (j > 0 && s[i] != s[j]) j = pattern[j - 1];

                if (s[i] == s[j]) pattern[i] = ++j;
                else pattern[i] = 0;
            }
            if (s.length % (s.length - pattern[s.length - 1]) != 0) sb.append(1).append("\n");
            else sb.append(s.length / (s.length - pattern[s.length - 1])).append("\n");
        }
        System.out.println(sb);
    }
}
