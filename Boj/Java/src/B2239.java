import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239 {
    static boolean[][] rowVisit = new boolean[9][9];
    static boolean[][] colVisit = new boolean[9][9];
    static boolean[][] districtVisit = new boolean[9][9];
    static char[][] board = new char[9][];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                if (row[j] != '0') {
                    rowVisit[i][(row[j] - '0') - 1] = true;
                    colVisit[j][(row[j] - '0') - 1] = true;
                    districtVisit[(i / 3) + (j / 3)][(row[j] - '0') - 1] = true;
                }
            }
            board[i] = row;
        }
        input(0, 0);
    }

    static void input(int x, int y) {
        if (flag) return;
        for (int j = y; j < 9; j++) {
            for (int num = 0; num < 9; num++) {
                if (board[x][j] == '0') {
                    if (rowVisit[x][num] || colVisit[j][num] || districtVisit[(x / 3) + (j / 3)][num]) continue;
                    board[x][j] = (char) num;
                    input(x, j + 1);
                    board[x][j] = '0';
                }
            }
        }

        for (int i = x + 1; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 8 && j == 8) {
                    flag = true;
                    for (char[] c : board) {
                        System.out.println(new String(c));
                    }
                    return;
                }
                for (int num = 0; num < 9; num++) {
                    if (board[i][j] == '0') {
                        if (rowVisit[i][num] || colVisit[j][num] || districtVisit[(i / 3) + (j / 3)][num]) continue;
                        board[i][j] = (char) num;
                        input(x, j + 1);
                        board[i][j] = '0';
                    }
                }
            }
        }
    }
}
