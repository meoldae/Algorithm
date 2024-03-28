import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] input = br.readLine().toCharArray();
            int result;

            if (isPalindrome(input)) result = 0;
            else if (isPseudoPalindrome(input)) result = 1;
            else result = 2;
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    static boolean isPalindrome(char[] str) {
        int left = 0;
        int right = str.length - 1;
        while(left < right) {
            if (str[left++] != str[right--]) return false;
        }
        return true;
    }

    static boolean isPseudoPalindrome(char[] str) {
        boolean rightFlag = true;
        int left = 0;
        int right = str.length - 1;

        int count = 0;
        while (left < right) {
            if (str[left++] != str[right--]) {
                if (count++ == 0) right++;
                else {
                    rightFlag = false;
                    break;
                }
            }
        }

        left = 0;
        right = str.length - 1;
        count = 0;
        boolean leftFlag = true;
        while (left < right) {
            if (str[left++] != str[right--]) {
                if (count++ == 0) left--;
                else {
                    leftFlag = false;
                    break;
                }
            }
        }
        return leftFlag || rightFlag;
    }
}
