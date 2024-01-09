import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] words = new Integer[26];
        Arrays.fill(words, 0);
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            for (int j = 0; j < word.length; j++) {
                words[word[j] - 65] += (int) Math.pow(10, word.length - j - 1);
            }
        }

        Arrays.sort(words, Collections.reverseOrder());

        int answer = 0;
        int weight = 9;
        for (int value : words) {
            if (value != 0) {
                answer += value * weight;
                weight--;
            }
        }
        System.out.print(answer);
    }
}
