import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Baekjoon 1613

class B1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }
                graph[i][j] = 100000;
            }
        }

        for (int i = 0; i < k; i++){
            input = br.readLine().split(" ");
            int src = Integer.parseInt(input[0]);
            int dst = Integer.parseInt(input[1]);
            graph[src-1][dst-1] = 1;
        }

        for (int i = 0;  i < n; i++){
            for (int j = 0; j < n; j++){
                for (int z = 0; z < n; z++){
                    if (j == z || graph[j][z] == 1){
                        continue;
                    }
                    graph[j][z] = Math.min(graph[j][z], graph[j][i] + graph[i][z]);
                }
            }
        }
        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < s; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            if (graph[a-1][b-1] == 100000 && graph[b-1][a-1] == 100000){
                System.out.println(0);
            } else if (graph[a-1][b-1] < graph[b-1][a-1]){
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        }
    }
}