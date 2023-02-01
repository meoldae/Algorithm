import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class B2638 {
    static int[][] cheese;
    static int[][] airCondition;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<Point> list = new ArrayList<>();
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        cheese = new int[n][m];
        airCondition = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(input[j]);
                if (cheese[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
        }
        bfs();

        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!list.isEmpty()) {
            List<Point> delete = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int air = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = list.get(i).x + dx[d];
                    int ny = list.get(i).y + dy[d];

                    if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                        if (cheese[nx][ny] == 0 && airCondition[nx][ny] == 3){
                            air += 1;
                            if (air >= 2){
                                delete.add(list.get(i));
                                break;
                            }
                        }
                    }
                }
            }
            for (Point del : delete){
                cheese[del.x][del.y] = 0;
                list.remove(del);
            }
            bfs();
            answer++;
        }
        System.out.println(answer);
    }
    static void bfs(){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()){
            Point now = queue.poll();

            for (int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)){
                    if (visited[nx][ny] == 0){
                        if (cheese[nx][ny] == 0){
                            queue.add(new Point(nx, ny));
                            visited[nx][ny] = 1;
                            airCondition[nx][ny] = 3;
                        }
                    }
                }
            }
        }
    }
}