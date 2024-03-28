import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12919 {
    static String a;
    static String b;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        dfs(b.length(), new StringBuilder(b));

        System.out.print(flag ? 1 : 0);
    }

    public static void dfs(int length, StringBuilder sb) {
        if (flag) return;

        if (length == a.length()) {
            if (sb.toString().equals(a)) {
                flag = true;
                return;
            }
            return;
        }
        if (sb.charAt(sb.length() - 1) == 'A') dfs(length - 1, new StringBuilder(sb).deleteCharAt(sb.length() - 1));
        if (sb.charAt(0) == 'B') dfs(length - 1, new StringBuilder(sb).deleteCharAt(0).reverse());
    }
}
