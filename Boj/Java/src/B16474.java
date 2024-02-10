import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16474 {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int leftCount = Integer.parseInt(st.nextToken());
        List<Integer> leftPoles = new ArrayList<>();
        int rightCount = Integer.parseInt(st.nextToken());
        List<Integer> rightPoles = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < leftCount; i++) {
           leftPoles.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rightCount; i++) {
            rightPoles.add(Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int left = leftPoles.indexOf(Integer.parseInt(st.nextToken())) + 1;
            int right = rightPoles.indexOf(Integer.parseInt(st.nextToken())) + 1;
            queue.offer(new int[]{left, right});
        }


        boolean[] visited = new boolean[Math.max(leftCount, rightCount) + 1];
        lis = new int[Math.max(leftCount, rightCount) + 1];
        int count = 0;
        int duplicated = 0;
        while (!queue.isEmpty()) {
            int[] cable = queue.poll();
//            if (visited[cable[0]]) continue;
//            visited[cable[0]] = true;

            if (lis[count] < cable[1]) {
                lis[++count] = cable[1];
            }else {
                int idx = binarySearch(count, cable[1]);
                lis[idx] = cable[1];
                duplicated++;
            }
        }

        System.out.print(duplicated);
//        System.out.print(k - count);
    }

    public static int binarySearch(int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
