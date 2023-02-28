import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1238_Contact {
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            list = new ArrayList[101];
            for (int i = 0; i < 101; i++) list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }

            boolean[] visited = new boolean[101];
            visited[start] = true;
            Queue<Integer> queue = new LinkedList<>();

            for (int next : list[start]) queue.offer(next);

            int answer = 0;
            while (!queue.isEmpty()) {
                int round = 0;
                int roundSize = queue.size();
                for (int i = 0; i < roundSize; i++) { //  현재 라운드 반복
                    int now = queue.poll();
                    round = Math.max(round, now);
                    for (int next : list[now]) {
                        if (visited[next]) continue; // 방문 안했으면
                        visited[next] = true; // 방문처리
                        queue.offer(next);
                    }
                }
                answer = round; // 라운드 마다 해당 라운드의 최대값으로 갱신
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
