//Baekjoon 1516

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1516 {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] degree = new int[n];
        int[][] graph = new int[n][n];
        int[] costs = new int[n];
        int[] answers = new int[n];

        for (int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            costs[i] = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length-1; j++){
                int src = Integer.parseInt(input[j]) - 1;
                graph[src][i] = 1;
                degree[i]++;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            if (degree[i] == 0){
                pq.add(new Node(i, costs[i]));
                answers[i] = costs[i];
            }
        }
        while (!pq.isEmpty()){
            Node now = pq.poll();
            for (int i = 0; i < graph[now.idx].length; i++){
                if (graph[now.idx][i] == 1){
                    degree[i]--;
                    if (degree[i] == 0){
                        pq.add(new Node(i, now.cost+costs[i]));
                        answers[i] = now.cost + costs[i];
                    }
                }
            }
        }

        for (int c : answers){
            System.out.println(c);
        }
    }    
}
