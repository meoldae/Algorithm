import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971 {
    static int minCost = Integer.MAX_VALUE;
    static int N;
    static int[][] costs;
    static int[][] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        route = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) costs[i][j] = Integer.parseInt(st.nextToken());
        }
        /*
        순회 : 결국 모든 도시를 원처럼 돌기때문에 출발지가 어디던 단 한번만 돌면 된다.
         */
        tsp(0, 0, 1);
        System.out.print(minCost);
    }
    static void tsp(int start, int now, int count){
        if (count == N) {
            if (costs[now][start] != 0) {
                minCost = Math.min(minCost, route[start][now] + costs[now][start]);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (i != start && costs[now][i] != 0 && route[start][i] == 0){
                route[start][i] = route[start][now] + costs[now][i];
                tsp(start, i, count+1);
                route[start][i] = 0;
            }
        }
    }
    /*
    DP 문제지만.. 완전탐색 재귀로 풀어버린 케이스
    실버문제기에 완전탐색이 풀린듯
     */
}