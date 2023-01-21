import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B9205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] input;

			int[][] graph = new int[n + 2][2];
			int[] visited = new int[n + 2];

			for (int j = 0; j < graph.length; j++) {
				input = br.readLine().split(" ");
				graph[j][0] = Integer.parseInt(input[0]);
				graph[j][1] = Integer.parseInt(input[1]);
			}

			boolean flag = false;
			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(graph[0][0], graph[0][1]));
			visited[0] = 1;
			outer:
			while (!queue.isEmpty()) {
				Point location = queue.poll();
				int x = location.x;
				int y = location.y;

				for (int k = 1; k < graph.length; k++) {
					if (visited[k] == 0) {
						if (Math.abs(x - graph[k][0]) + Math.abs(y - graph[k][1]) <= 1000) {
							queue.offer(new Point(graph[k][0], graph[k][1]));
							visited[k] = 1;
							if (k == graph.length - 1) {
								flag = true;
								break outer;
							}
						}
					}
				}
			}
			if (flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
}
