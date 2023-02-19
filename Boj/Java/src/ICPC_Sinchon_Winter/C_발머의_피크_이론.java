package ICPC_Sinchon_Winter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_발머의_피크_이론 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] alchoals = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int density = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            density += alchoals[i];
            if (i-L >= 0) density -= alchoals[i-L];
            if (129 <= density && density <= 138) answer++;
        }
        System.out.println(answer);
    }
}
