import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2848 {
    static int[] degree = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] algoSpots = new char[N][];
        boolean[] visited = new boolean[26];
        List<Integer>[] graph = new List[26];
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < N; i++) {
            algoSpots[i] = br.readLine().toCharArray();
            for (int j = 0; j < algoSpots[i].length; j++) {
                if (!visited[algoSpots[i][j] - 'a']) {
                    visited[algoSpots[i][j] - 'a'] = true;
                    count++;
                }
            }
        }

        for (int i = 0; i < 26; i++) graph[i] = new ArrayList<>();

        boolean flag = true;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < algoSpots[i].length; j++) {
                if (j < algoSpots[i + 1].length) {
                    if (algoSpots[i][j] != algoSpots[i + 1][j]) {
                        graph[algoSpots[i][j] - 'a'].add(algoSpots[i + 1][j] - 'a');
                        degree[algoSpots[i + 1][j] - 'a']++;
                        break;
                    }
                }else {
                    flag = false;
                    break;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] && degree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean order = true;
        for (int i = 0; i < count; i++) {
            if (queue.isEmpty()){
                flag = false;
                break;
            }
            int now = queue.poll();
            sb.append((char) (now+'a'));
            if (queue.size() >= 1) {
                order = false;
            }

            for (int next : graph[now]) {
                if (--degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (!flag) {
            System.out.print("!");
        }else if (order){
            System.out.print(sb);
        }else {
            System.out.print("?");
        }
    }
}