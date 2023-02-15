import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int r = 0; r < 10; r++){
                for (int c = 0; c < 10; c++) { 
                    board[r+x][c+y] = 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }
}
