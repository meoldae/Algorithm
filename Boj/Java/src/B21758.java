import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] honey = new int[N];
        int[] honeySum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            honey[i - 1] = Integer.parseInt(st.nextToken());
            honeySum[i] = honey[i - 1] + honeySum[i - 1];
        }
        int answer = 0;
        for (int i = 2; i < N; i++) {
            
            // 벌통이 우측 끝 일때 
            int case1 = (honeySum[N] - honey[0] - honey[i - 1]) + (honeySum[N] - honeySum[i]);
            answer = Math.max(case1, answer);
            
            
            // 벌통이 중간 일때
            int case2 = (honeySum[i] - honey[0]) + (honeySum[N - 1] - honeySum[i - 1]);
            answer = Math.max(case2, answer);
            
            
            // 벌통이 좌측 끝 일때
            int case3 = (honeySum[N - 1] - honey[i - 1]) + (honeySum[i - 1]);
            answer = Math.max(case3, answer);
        }
        System.out.print(answer);
    }
}