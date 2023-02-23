import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17471 {
    static int N;
    static int[] peoples;
    static ArrayList<int[]> selectedList;
    static int[] select;
    static Set<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graph = new HashSet[N];
        for (int i = 0; i < N; i++) graph[i] = new HashSet<>();

        for (int i = 0; i < N; i++) { // 구역 연결 관계 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken()) - 1;
                graph[next].add(i);
                graph[i].add(next);
            }
        }

        selectedList = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) { // 조합을 통해 구역 선택 ( 선택 O / 선택 X ) 2개 구역
            select = new int[i];
            comb(0, 0, i);
        }
        int answer = Integer.MAX_VALUE;
        int sum = Arrays.stream(peoples).sum();
        for (int[] selected : selectedList) {
            if (isConnected(selected, 1) && isConnected(selected, 0)) { // 선택 O, 선택 X 모두 연결 상태 확인
                answer = Math.min(answer, Math.abs(sum - (getPopulation(selected) * 2))); // 연결 확인 후 인구수 계산
            }
        }
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }

    static void comb(int count, int start, int limit) {
        if (count == limit) {
            int[] temp = new int[N];
            for (int num : select) temp[num] = 1;
            selectedList.add(temp);
            return;
        }
        for (int i = start; i < N; i++) {
            select[count] = i;
            comb(count + 1, i + 1, limit);
        }
    }

    static boolean isConnected(int[] selected, int flag) { // 연결 확인 함수 ( Flag 를 통해 선택 여부 구분 )
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {   // Flag 도시중 아무거나 선택
            if (selected[i] == flag) {
                queue.offer(i);
                visited[i] = true;
                break;
            }
        }
        int count = 0;
        for (int s : selected) if (s == flag) count++; // Flag 도시 수

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (--count == 0) return true; // Flag 도시 모두 갈 수 있으면
            for (int next : graph[now]) {
                if (selected[next] == flag && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    static int getPopulation(int[] selected) {
        int population = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i] == 1) population += peoples[i];
        }
        return population;
    }
}
