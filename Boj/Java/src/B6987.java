import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B6987 {
    static int[][] group;
    static int[] selected;
    static int answer;
    static List<int[]> combinations = new ArrayList<>();
    static int[][] match = new int[][]{{0, 2}, {1, 1}, {2, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        selected = new int[2];
        comb(0, 0);

        outer:
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            group = new int[6][3];
            int j = 0;
            while (j < 18) { // 경기 결과
                group[j / 3][j % 3] = Integer.parseInt(st.nextToken());
                j++;
            }
            for (int[] row : group){
                if (Arrays.stream(row).sum() != 5){
                    sb.append(0).append(" ");
                    continue outer;
                }
            }
            answer = 0;
            backTrack(0);
            sb.append(answer).append(" ");
        }
        System.out.print(sb);
    }

    static void comb(int count, int start) {
        if (count == 2) {
            combinations.add(new int[]{selected[0], selected[1]});
            return;
        }
        for (int i = start; i < 6; i++) {
            selected[count] = i;
            comb(count + 1, i + 1);
        }
    }

    static void backTrack(int count) {
        if (answer == 1) return;
        if (count == 15) {
            answer = 1;
            return;
        }
        int[] game = combinations.get(count);
        for (int[] result : match) {
            if (group[game[0]][result[0]] > 0 && group[game[1]][result[1]] > 0) {
                group[game[0]][result[0]]--;
                group[game[1]][result[1]]--;
                backTrack(count + 1);
                group[game[0]][result[0]]++;
                group[game[1]][result[1]]++;
            }
        }
    }
}
