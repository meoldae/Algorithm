import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[100][100]; // 가로 세로가 100인 정사각형 모양의 흰색 천
        int N = Integer.parseInt(br.readLine()); // 검은 스카프의 개수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1; // 검은 스카프의 왼쪽 변과 흰색 천의 왼쪽 변 사이 거리 == 열
            int x = Integer.parseInt(st.nextToken()) - 1; // 검은 스카프의 아래쪽 변과 흰색 천의 아래 쪽 변 사이 거리 == 행 ( x축에 대해 반전시켜서 사용 )

            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    if (x + a >= 100 || y + b >= 100)
                        continue; // 흰색 천 범위를 벗어나면 무시 (항상 증가하는 방향이므로 0보다 작은 경우는 없다.)
                    board[x + a][y + b] = 1; // 검은 색 스카프로 채움
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 1) { // 검은 스카프 이고
                    int tempCount = 0; // 가장자리 구분을 위한 임시 변수
                    for (int d = 0; d < 4; d++) { // 사방탐색 실시
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (0 > nx || nx >= 100 || 0 > ny || ny >= 100 || board[nx][ny] == 0) {
                            // 가장자리이거나 바로 인접한 공간이 흰색 천이면 임시 변수 증가
                            tempCount++;
                        }
                    }
                    if (tempCount >= 2) count += 2; // 인접한 공간이 흰색이 두 개 이상이면 맨 가장자리이므로 + 2
                    else if (tempCount == 1) count++; // 가장자리가 아니라 변이면 + 1
                }
            }
        }
        System.out.println(count); // 총 둘레 출력
    }
}
