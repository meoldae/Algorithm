import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] meow = new int[26];
        int left = 0;
        int right = 0;
        int answer = 0;
        int count = 0;

        while(right < s.length()) {
            if (meow[s.charAt(right++) - 97]++ == 0) count++;

            while (count > N) {
                if (--meow[s.charAt(left++) - 97] == 0) count--;
            }
            answer = Math.max(answer, right - left);
        }
        System.out.print(answer);
    }
}
