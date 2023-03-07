import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11437 {
    static class Node {
        int value;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    static ArrayList<Integer>[] graph;
    static Node[] trees;
    static int[] level;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        level = new int[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); // 양방향 그래프
        }
        trees = new Node[N + 1];
        makeTree();

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(LCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.print(sb);
    }

    static void makeTree() { // 트리 생성용
        Queue<Node> queue = new LinkedList<>();
        trees[1] = new Node(1);
        queue.add(trees[1]);
        level[1] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int child : graph[now.value]) {
                if (trees[child] != null) continue;
                level[child] = level[now.value] + 1;
                Node myChild = new Node(child); // 자식 노드
                myChild.parent = now;
                trees[child] = myChild;
                queue.add(myChild);
            }
        }
    }

    static int LCA(int a, int b) {
        int levelA = level[a];
        int levelB = level[b];
        int diff = Math.abs(levelB - levelA);
        if (diff > 0) {
            Node now = (levelA > levelB) ? trees[a] : trees[b];
            for (int i = 0; i < diff; i++) now = now.parent;
            if (levelA > levelB) {
                a = now.value;
            }else {
                b = now.value;
            }
        }

        Node A = trees[a];
        Node B = trees[b];
        while(true){
            if (A.value == B.value) return A.value;
            if (A.parent == null || B.parent == null) return 1;

            A = A.parent;
            B = B.parent;
        }
    }
}
