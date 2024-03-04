import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2174 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Map<String, Integer> direction = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        direction.put("N", 0);
        direction.put("E", 1);
        direction.put("S", 2);
        direction.put("W", 3);

        int[][] robots = new int[N + 1][];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = (B - Integer.parseInt(st.nextToken())) + 1;
            int d = direction.get(st.nextToken());
            robots[i] = new int[]{x, y, d};
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());

            for (int r = 0; r < repeat; r++) {
                if (command.equals("L")) {
                    robots[order][2] = (robots[order][2] + 3) % 4;
                } else if (command.equals("R")) {
                    robots[order][2] = (robots[order][2] + 1) % 4;
                } else if (command.equals("F")) {
                    robots[order][0] = robots[order][0] + dx[robots[order][2]];
                    robots[order][1] = robots[order][1] + dy[robots[order][2]];
                    if (0 >= robots[order][0] || A < robots[order][0] || 0 >= robots[order][1] || B < robots[order][1]) {
                        System.out.print("Robot " + order + " crashes into the wall");
                        return;
                    }
                    for (int j = 1; j <= N; j++) {
                        if (j == order) continue;
                        if (robots[order][0] == robots[j][0] && robots[order][1] == robots[j][1]) {
                            System.out.print("Robot " + order + " crashes into robot " + j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.print("OK");
    }
}

//5 4
//2 4
//1 1 E
//5 4 W
//1 F 3
//2 F 1
//1 L 1
//1 F 3
//Robot 1 crashes into robot 2

//5 4
//2 3
//1 1 E
//5 4 W
//1 F 4
//1 L 1
//1 F 20
//Robot 1 crashes into robot 2