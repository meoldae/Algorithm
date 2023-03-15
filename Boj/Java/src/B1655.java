import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        maxHeap.offer(-1 * Integer.parseInt(br.readLine()));
        sb.append(-1 * maxHeap.peek()).append("\n");

        for (int i = 1; i < N; i++){

            int num = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) {
                if (-1 * maxHeap.peek() < num) {
                    minHeap.offer(num);
                    sb.append(minHeap.peek()).append("\n");
                }
                else{
                    maxHeap.offer(-1 * num);
                    sb.append(-1 * maxHeap.peek()).append("\n");
                }
            }else{
                if (maxHeap.size() > minHeap.size()){
                    if (-1 * maxHeap.peek() >= num) maxHeap.offer(-1 * num);
                    else minHeap.offer(num);

                }else {
                    if (minHeap.peek() <= num) minHeap.offer(num);
                    else maxHeap.offer(-1 * num);
                }

                if (Math.abs(maxHeap.size() - minHeap.size()) > 1){
                    if (minHeap.size() > maxHeap.size()) {
                        maxHeap.offer(-1 * minHeap.poll());
                        sb.append(-1 * maxHeap.peek()).append("\n");
                    }
                    else if (maxHeap.size() > minHeap.size()) {
                        minHeap.offer(-1 * maxHeap.poll());
                        sb.append(-1 * maxHeap.peek()).append("\n");
                    }
                }
                else {
                    if (minHeap.size() > maxHeap.size()) sb.append(minHeap.peek()).append(" ");
                    else if (minHeap.size() < maxHeap.size()) sb.append(-1 * maxHeap.peek()).append(" ");
                    else sb.append(-1*maxHeap.peek()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
