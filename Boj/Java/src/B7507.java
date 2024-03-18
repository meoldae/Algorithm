import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B7507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            List<int[]> games = new LinkedList<>();
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                games.add(new int[]{d, start, end});
            }
            games.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    if (o1[2] == o2[2]) return o1[1] - o2[1];
                    return o1[2] - o2[2];
                }
                return o1[0] - o2[0];
            });

            int answer = 0;
            int day = 0;
            int time = 0;
            for (int[] game : games) {
                if (game[0] > day) { // 날짜가 바뀌면
                    day = game[0];
                    answer++;
                    time = game[2];
                } else {
                    if (time <= game[1]) {
                        time = game[2];
                        answer++;
                    }
                }
            }
            sb.append("Scenario #").append(tc).append(":\n").append(answer).append("\n\n");
        }
        System.out.print(sb);
    }
}