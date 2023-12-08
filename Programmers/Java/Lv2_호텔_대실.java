import java.util.Arrays;
import java.time.LocalTime;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int[][] convertedBookTime = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            convertedBookTime[i][0] = convert(book_time[i][0]);
            convertedBookTime[i][1] = convert(book_time[i][1]);
        }
        
        Arrays.sort(convertedBookTime, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        
        int roomCount = 1;
        for (int[] reservation : convertedBookTime) {
            if (pq.isEmpty()) {
                pq.offer(reservation[1]);
            } else {
                if (reservation[0] >= pq.peek()+10) {
                    pq.poll();
                } else {
                    roomCount++;
                }
                pq.offer(reservation[1]);
            }
        }
        
        return roomCount;
    }
    
    public int convert(String time) {
        int result = 0;
        int temp = Integer.parseInt(time.replace(":", ""));
        result += (temp / 100) * 60;
        result += (temp % 100);
        return result;
    }
}
