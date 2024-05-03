import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] t = br.readLine().toCharArray();

        System.out.print(dfs(s, t) ? 1 : 0);
    }
    public static boolean dfs(String s, char[] t) {
        if (s.length() == t.length) {
            return s.equals(String.valueOf(t));
        }

        int size = t.length;
        char[] nextT = new char[size - 1];
        if (t[size - 1] == 'A') for (int i = 0; i < size - 1; i++) nextT[i] = t[i];
         else if (t[size - 1] == 'B') for (int i = 0; i < size - 1; i++) nextT[i] = t[size - 2 - i];

        return dfs(s, nextT);
    }
}
