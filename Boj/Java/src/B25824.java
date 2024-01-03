import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B25824 {
    public static int STUDENT_COUNT = 12;
    public static int[][] latencies;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        latencies = new int[STUDENT_COUNT][STUDENT_COUNT];
        visited = new boolean[STUDENT_COUNT];

        for (int i = 0; i < STUDENT_COUNT; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < STUDENT_COUNT; j++) {
                latencies[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        message(0, 1, 0);
        message(0, 1, 1);

        System.out.print(answer);
    }

    public static void message(int time, int count, int student) {
        if (time >= answer) return;

        if (count == STUDENT_COUNT) {
            answer = Math.min(answer, time);
            return;
        }

        if ((count & 1) == 1) { // 홀수 : 그룹 내 전달
            // 홀수 : -1 (1->0, 3->2, 5->4)
            // 짝수 : +1 (0->1, 2->3, 4->5)
            if ((student & 1) == 1) message(time + latencies[student][student - 1], count + 1, student - 1);
            else message(time + latencies[student][student + 1], count + 1, student + 1);
        } else {    // 짝수 : 다음 그룹으로
            int nextGroup = ((student / 2) + 1) * 2;
            // 다음 그룹 두 개 모두 전달
            message(time + latencies[student][nextGroup], count + 1, nextGroup);
            message(time + latencies[student][nextGroup + 1], count + 1, nextGroup + 1);
        }
    }
}