import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {
    static int L, C;
    static String[] chars;
    static StringBuilder sb = new StringBuilder();
    static String[] key;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = br.readLine().split(" ");
        key = new String[L];
        Arrays.sort(chars);
        encrypt(0, 0, 0, 0);
        System.out.print(sb);
    }

    static void encrypt(int start, int count, int vowel, int cons) {
        if (count == L) {
            if (vowel >= 1 && cons >= 2) {
                Arrays.stream(key).forEach(ch -> sb.append(ch));
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            key[count] = chars[i];
            if ("aeiou".contains(chars[i])) encrypt(i + 1, count + 1, vowel + 1, cons);
            else encrypt(i + 1, count + 1, vowel, cons + 1);
        }
    }
}