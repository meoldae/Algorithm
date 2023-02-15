import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16935 {
    static int[][] board;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < r; i++) {
            rotation(commands[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int[] arr : board) {
            Arrays.stream(arr).forEach(num -> { sb.append(num).append(" ");});
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotation(int command) {
        int[][] result;
        Queue<int[][]> queue;
        int[][] temp1;
        int[][] temp2;
        int[][] temp3;
        int[][] temp4;
        switch (command) {
            case 1: // 상하 반전
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < m; j++) {
                        int temp = board[i][j];
                        board[i][j] = board[n - i - 1][j];
                        board[n - i - 1][j] = temp;
                    }
                }
                break;

            case 2: // 좌우 반전
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        int temp = board[i][j];
                        board[i][j] = board[i][m - j - 1];
                        board[i][m - j - 1] = temp;
                    }
                }
                break;

            case 3: // 시계방향으로 90도
                result = new int[board[0].length][board.length];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        result[j][n - i - 1] = board[i][j];
                    }
                }
                board = result;
                n = board.length;
                m = board[0].length;
                break;

            case 4: // 반시계방향으로 90도
                result = new int[board[0].length][board.length];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        result[m - j - 1][i] = board[i][j];
                    }
                }
                board = result;
                n = board.length;
                m = board[0].length;
                break;

            case 5:
                queue = new LinkedList<>();
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        int[][] area = new int[n / 2][m / 2];
                        for (int a = 0; a < n / 2; a++) {
                            for (int b = 0; b < m / 2; b++) {
                                area[a][b] = board[(n / 2) * i + a][(m / 2) * j + b];
                            }
                        }
                        queue.add(area);
                    }
                }
                temp1 = queue.poll();
                temp2 = queue.poll();
                temp3 = queue.poll();
                temp4 = queue.poll();
                queue.add(temp3);
                queue.add(temp1);
                queue.add(temp4);
                queue.add(temp2);

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        int[][] now = queue.poll();
                        for (int a = 0; a < n / 2; a++) {
                            for (int b = 0; b < m / 2; b++) {
                                board[(n / 2) * i + a][(m / 2) * j + b] = now[a][b];
                            }
                        }
                    }
                }
                break;
            case 6:
                queue = new LinkedList<>();
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        int[][] area = new int[n / 2][m / 2];
                        for (int a = 0; a < n / 2; a++) {
                            for (int b = 0; b < m / 2; b++) {
                                area[a][b] = board[(n / 2) * i + a][(m / 2) * j + b];
                            }
                        }
                        queue.add(area);
                    }
                }
                temp1 = queue.poll();
                temp2 = queue.poll();
                temp3 = queue.poll();
                temp4 = queue.poll();
                queue.add(temp2);
                queue.add(temp4);
                queue.add(temp1);
                queue.add(temp3);

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        int[][] now = queue.poll();
                        for (int a = 0; a < n / 2; a++) {
                            for (int b = 0; b < m / 2; b++) {
                                board[(n / 2) * i + a][(m / 2) * j + b] = now[a][b];
                            }
                        }
                    }
                }
                break;
        }
    }
}
