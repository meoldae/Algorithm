import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	final static int BOARD_SIZE = 19;
	static int[][] board;

//	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[BOARD_SIZE][BOARD_SIZE];
//		visited = new boolean[BOARD_SIZE][BOARD_SIZE];
		String[] input;

		for (int i = 0; i < BOARD_SIZE; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						if (checkConcave(i, j, d)) {
							System.out.println(board[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
		return;
	}

	// 오목 체크
	static boolean checkConcave(int x, int y, int direction) {
		Queue<Point> queue = new LinkedList<>();
		int r, c, nx, ny;
		int count = 1;
		// 우상단 > 가로 > 우하단 > 세로
		int[] dx = new int[] { -1, 0, 1, 1 };
		int[] dy = new int[] { 1, 1, 1, 0 };

		// 육목 체크용..하드코딩
		int[] sx = new int[] { 1, 0, -1, -1 };
		int[] sy = new int[] { -1, -1, -1, 0 };

		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point location = queue.poll();
			r = location.x;
			c = location.y;

			nx = r + dx[direction];
			ny = c + dy[direction];

			if ((0 <= nx && nx < BOARD_SIZE) && (0 <= ny && ny < BOARD_SIZE)) {
				if (board[r][c] == board[nx][ny]) {
					queue.offer(new Point(nx, ny));
					count++;
					if (count > 5) {
						return false;
					}
				}
			}
		}
		if (count == 5) {
//			System.out.println("x,y: "+x+" "+y);
//			System.out.println(direction);
//			System.out.println();
			if ((0 <= x + sx[direction] && x + sx[direction] < BOARD_SIZE) && 0 <= y + sy[direction]
					&& y + sy[direction] < BOARD_SIZE) {
//				System.out.println(board[x][y]);
//				System.out.println(board[x+sx[direction]][y+sy[direction]]);
				if (board[x + sx[direction]][y + sy[direction]] == board[x][y]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
