import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            degree[dst]++;
            graph[src].add(dst);
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++){
            if (degree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now + 1).append(" ");
            for (int next : graph[now]){
                degree[next]--;
                if (degree[next] == 0) queue.add(next);
            }
        }

        System.out.print(sb);

    }
}
