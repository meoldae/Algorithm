import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B3584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> edge = new HashMap<>();
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                edge.put(child, parent);
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] parents = new boolean[N + 1];

            while(true) {
                parents[a] = true;
                if (edge.containsKey(a)) a = edge.get(a);
                else break;
            }

            while(true){
                if (parents[b]) {
                    sb.append(b).append("\n");
                    break;
                }
                b = edge.get(b);
            }
        }
        System.out.print(sb);
    }
}
