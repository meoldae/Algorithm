import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992 {
    static char[][] image;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        image = new char[n][];
        for (int i = 0; i < n; i++) {
            image[i] = br.readLine().toCharArray();
        }
        divide(0, 0, n);
        System.out.println(sb);
    }

    static void divide(int x, int y, int l) {
        int flag = image[x][y];
        boolean isPrint = true;
        outer:
        for (int i = x; i < x + l; i++) {
            for (int j = y; j < y + l; j++) {
                if (image[i][j] != flag) {
                    sb.append("(");
                    divide(x, y, l / 2);
                    divide(x, y + l / 2, l / 2);
                    divide(x + l / 2, y, l / 2);
                    divide(x + l / 2, y + l / 2, l / 2);
                    sb.append(")");
                    isPrint = false;
                    break outer;
                }
            }
        }
        if (isPrint) sb.append(flag - '0');
    }
}