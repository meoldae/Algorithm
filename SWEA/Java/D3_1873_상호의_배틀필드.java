import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_1873_상호의_배틀필드 {
    static char[][] board;
    static int[] tank;
    static int h, w;
    static Map<Character, Integer> direction;
    static Map<Character, Character> setting;

    public static void main(String[] args) throws IOException {
        direction = new HashMap<Character, Integer>() {{
            put('L', 0);
            put('R', 1);
            put('U', 2);
            put('D', 3);
        }};
        setting = new HashMap<Character, Character>() {{
            put('L', '<');
            put('R', '>');
            put('U', '^');
            put('D', 'v');
        }};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            board = new char[h][w];
            tank = new int[3];
            // 전장 정보 적용
            for (int i = 0; i < h; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == '<' || board[i][j] == '>' || board[i][j] == '^' || board[i][j] == 'v') {
                        tank[0] = i;
                        tank[1] = j;
                        for (Character key : setting.keySet()) {
                            if (setting.get(key) == board[i][j]) tank[2] = (char) key;
                        }
                    }
                }
            }

            // 명령의 수
            int n = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();
            for (char command : commands) {
                if (command != 'S') move(command);
                else shoot();
            }
            sb.append("#").append(tc).append(" ");
            for (char[] row : board) sb.append(String.valueOf(row)).append("\n");
        }
        System.out.println(sb);
    }

    static void move(char flag) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int d = direction.get(flag);
        int nx = tank[0] + dx[d];
        int ny = tank[1] + dy[d];
        if (0 <= nx && nx < h && 0 <= ny && ny < w) {
            if (board[nx][ny] == '.'){
                board[tank[0]][tank[1]] = '.';
                board[nx][ny] = setting.get(flag);
                tank[0] = nx;
                tank[1] = ny;
            }
        }
        board[tank[0]][tank[1]] = setting.get(flag);
        tank[2] = (char) flag;
    }

    static void shoot() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int d = direction.get((char) tank[2]);
        int x = tank[0];
        int y = tank[1];
        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || h <= nx || ny < 0 || w <= ny) return;

            if (board[nx][ny] == '*'){
                board[nx][ny] = '.';
                return;
            }
            if (board[nx][ny] == '#') return;
            x = nx;
            y = ny;
        }
    }
}
