import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] input = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            input[i][0] = c;
            input[i][1] = s;
            // 정답 출력을 위한 인덱스 기억
            input[i][2] = i;
        }

        // 공의 크기 오름차순으로 정렬
        Arrays.sort(input, (o1, o2) -> o1[1] - o2[1]);

        // 공의 색상 관계 없이 누적 합
        List<Integer> totalPrefixSum = new ArrayList<>();
        totalPrefixSum.add(0);

        // 공의 색상 별 누적합을 저장할 맵
        Map<Integer, List<Integer>> prefixSum = new HashMap<>();
        // 정답 출력을 위한 배열
        int[] answer = new int[N];
        int[] count = new int[200001];
        int totalCount = 0;
        int size = 0;

        for (int[] i : input) {
            // 이 색상이 처음일 경우
            if (!prefixSum.containsKey(i[0])) {
                prefixSum.put(i[0], new ArrayList<>());
                prefixSum.get(i[0]).add(0);
            }

            if (i[1] > size) {
                size = i[1];
                totalCount = 0;
                Arrays.fill(count, 0);
            }
            else {
                totalCount++;
            }

            // 전체 누적 합에서 현재 색상의 누적합을 뺀 값. 단, 크기가 동일한 공의 갯수 만큼 생략하도록..
            answer[i[2]] = totalPrefixSum.get(totalPrefixSum.size() - 1 - totalCount) - prefixSum.get(i[0]).get(prefixSum.get(i[0]).size() - 1 - count[i[0]]++);

            prefixSum.get(i[0]).add(prefixSum.get(i[0]).get(prefixSum.get(i[0]).size() - 1) + i[1]);
            totalPrefixSum.add(totalPrefixSum.get(totalPrefixSum.size() - 1) + i[1]);
        }

        for (int a : answer) {
            sb.append(a).append("\n");
        }
        System.out.print(sb);
    }
}
