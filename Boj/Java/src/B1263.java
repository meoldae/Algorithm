import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> tasks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            tasks.add(new int[]{T, S});
        }

        tasks.sort((o1, o2) -> o2[1] - o1[1]);
        int[] lastTask = tasks.get(0);
        int time = lastTask[1] - lastTask[0];
        for (int i = 1; i < tasks.size(); i++) {
            int[] now = tasks.get(i);

            time = Math.min(time, now[1]);
            time -= now[0];

            if (time < 0) {
                System.out.print(-1);
                return;
            }
        }
        System.out.print(time);
    }
}
