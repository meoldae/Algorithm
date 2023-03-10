import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2239 {
    static boolean[][] rowVisit = new boolean[9][9];
    static boolean[][] colVisit = new boolean[9][9];
    static boolean[][] districtVisit = new boolean[9][9];
    static int[][] board = new int[9][9];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                if (row[j] != '0') {
                    rowVisit[i][(row[j] - '0') - 1] = true;
                    colVisit[j][(row[j] - '0') - 1] = true;
                    districtVisit[((i / 3) * 3) + (j / 3)][(row[j] - '0') - 1] = true;
                }
                board[i][j] = row[j] - '0';
            }
        }
        sudoku(0, 0);
    }

    static void sudoku(int x, int y) {
        if(flag) return;
        if (x == 8 && y == 9) {
            for (int[] row : board) {
                Arrays.stream(row).forEach(System.out::print);
                System.out.println();
            }
            flag = true;
            return;
        }

        if (y == 9) sudoku(x + 1, 0);

        else {
            if (board[x][y] == 0) {
                for (int i = 0; i < 9; i++) {
                    if (rowVisit[x][i] || colVisit[y][i] || districtVisit[((x / 3) * 3) + (y / 3)][i]) continue;
                    rowVisit[x][i] = true;
                    colVisit[y][i] = true;
                    districtVisit[((x / 3) * 3) + (y / 3)][i] = true;
                    board[x][y] = i + 1;
                    sudoku(x, y + 1);
                    rowVisit[x][i] = false;
                    colVisit[y][i] = false;
                    districtVisit[((x / 3) * 3) + (y / 3)][i] = false;
                    board[x][y] = 0;
                }
            } else sudoku(x, y + 1);

        }
    }
}
