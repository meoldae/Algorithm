import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        outer:
        while (true) {
            String s = br.readLine();
            if (s.charAt(0) == '0') break;

            if (s.charAt(0) != '1' || s.charAt(s.length() - 1) != '2') {
                sb.append(tc++).append(". ").append("NOT").append("\n");
                continue;
            }

            boolean[] pair = new boolean[9];

            for (int i = 0; i < s.length() - 1; i++) {
                if (!isPossible(s.charAt(i), s.charAt(i + 1))) {
                    sb.append(tc++).append(". ").append("NOT").append("\n");
                    continue outer;
                }
                pair[s.charAt(i) - '0'] = true;
                pair[s.charAt(i + 1) - '0'] = true;
            }

            boolean flag = true;
            if ((pair[1] ^ pair[2]) || (pair[5] ^ pair[6])) flag = false;

            sb.append(tc++).append(". ").append(flag ? "VALID" : "NOT").append("\n");
        }

        System.out.print(sb);

    }

    public static boolean isPossible(char left, char right) {
        if (left == '1' || left == '3') {
            return right == '4' || right == '5';
        } else if (left == '2') {
            return false;
        } else if (left == '4' || left == '6') {
            return right == '2' || right == '3';
        } else if (left == '5' || left == '7') {
            return right == '8';
        } else {
            return right == '6' || right == '7';
        }
    }
}
