import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        int start = 0;
        int end = K;
        int coupon = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            if (map.containsKey(sushi[i])) map.put(sushi[i], map.get(sushi[i]) + 1);
            else map.put(sushi[i], 1);

            if (sushi[i] == C) coupon++;
        }

        if (coupon == 0) answer = Math.max(answer, map.size() + 1);
        else answer = Math.max(answer, map.size());

        while(end < N + K) {
            int tempEnd = end % N;
            if (map.containsKey(sushi[tempEnd])) map.put(sushi[tempEnd], map.get(sushi[tempEnd]) + 1);
            else map.put(sushi[tempEnd], 1);
            if (sushi[tempEnd] == C) coupon++;
            end++;

            if (map.get(sushi[start]) == 1) map.remove(sushi[start]);
            else map.put(sushi[start], map.get(sushi[start]) - 1);
            if (sushi[start] == C) coupon--;
            start++;

            if (coupon == 0) answer = Math.max(answer, map.size() + 1);
            else answer = Math.max(answer, map.size());
        }

        System.out.print(answer);
    }
}
