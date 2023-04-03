import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken()) - 1;
            int tall = Integer.parseInt(st.nextToken()) - 1;
            graph[small][tall] = 1;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                   if (j == k) continue;
                   if (graph[j][i] == 1 && graph[i][k] == 1) {
                       graph[j][k] = 1;
                   }
                }
            }
        }

        int answer = 0;
        for (int row = 0; row < N; row++){
            int count = 0;
            for (int col = 0; col < N; col++){
                if (graph[row][col] == 1 || graph[col][row] == 1) count++;
            }
            if (count == N-1) answer++;
        }
        System.out.print(answer);



    }
}