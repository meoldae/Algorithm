import java.util.Scanner;

public class B2661 {
    public static void main(String[] args) {
        dfs("", new Scanner(System.in).nextInt());
    }

    static void dfs(String s, int limit) {
        if (s.length() == limit) {
            System.out.print(s);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(s + i)) dfs(s + i, limit);
        }
    }

    static boolean isGood(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.substring(s.length() - i - i, s.length() - i).equals(s.substring(s.length() - i))) return false;
        }
        return true;
    }
}