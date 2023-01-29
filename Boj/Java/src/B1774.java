import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class B1774 {
    static int[] p;
    static class Node implements Comparable<Node>{
        int src;
        int dst;
        double distance;

        public Node(int src, int dst, double distance) {
            this.src = src;
            this.dst = dst;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        p = new int[n];
        Point[] loca = new Point[n];
        PriorityQueue<Node> heapq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            loca[i] = new Point(x, y);
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int src = Integer.parseInt(input[0])-1;
            int dst = Integer.parseInt(input[1])-1;
            heapq.add(new Node(src, dst, 0));
        }

        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (i != j){
                    heapq.add(new Node(i, j, getDistance(loca[i], loca[j])));
                }
            }
        }
        double answer = 0;
        while (! heapq.isEmpty()){
            Node now = heapq.poll();
            if (!isSameParent(now.src, now.dst)){
                if (now.src < now.dst){
                    union(now.src, now.dst);
                }else {
                    union(now.dst, now.src);
                }
                answer += now.distance;
            }
        }
        System.out.printf("%.2f", answer);
    }

    static double getDistance(Point a, Point b){
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    static int find(int s){
        if (s == p[s]){
            return s;
        }else {
            p[s] = find(p[s]);
            return p[s];
        }
    }
    static void union(int s, int e){
        int x = find(s);
        int y = find(e);

        if (x != y){
            p[y] = x;
        }
    }
    static boolean isSameParent(int s, int e){
        int x = find(s);
        int y = find(e);

        return x == y;
    }
}