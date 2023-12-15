import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> shortcut = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            if (end > D) continue; // 역주행 불가

            if (end - start > cost) { // 지름길이 아닌 경우는 생각하지 않음
                shortcut.offer(new int[]{start, end, cost});
            }
        }

        int[] distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        int current = 0;
        while(current < D) {
            if (!shortcut.isEmpty() && current == shortcut.peek()[0]) {  // 지름길 존재
                distance[shortcut.peek()[1]] = Math.min(distance[shortcut.peek()[1]], distance[current] + shortcut.peek()[2]);
                shortcut.poll();
            } else { // 지름길 없다면 1씩 이동
                distance[current + 1] = Math.min(distance[current + 1], distance[current] + 1);
                current++;
            }
        }
        System.out.println(distance[D]);
    }
}