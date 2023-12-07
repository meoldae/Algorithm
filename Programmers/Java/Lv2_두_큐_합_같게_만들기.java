/**
 * Lv2_두_큐_합_같게_만들기
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Lv2_두_큐_합_같게_만들기 {
    public static int count;
    public static int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        Long sum1 = 0L;
        Long sum2 = 0L;
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        while(!q1.isEmpty() && !q2.isEmpty() && count <= (queue1.length * 4)) {
            int temp = 0;
            if (sum1 > sum2) {
                temp = q1.poll();
                q2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
            } else if (sum1 < sum2) {
                temp = q2.poll();
                q1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
            } else {
                return count;    
            }
            count++;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        // int[] queue1 = {3, 2, 7, 2};
        // int[] queue2 = {4, 6, 5, 1};
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(solution(queue1, queue2));
    }
}