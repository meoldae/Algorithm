import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21939 {
    static class Problem implements Comparable<Problem> {
        private int level;
        private int no;

        public Problem(int level, int no) {
            this.level = level;
            this.no = no;
        }

        @Override
        public int compareTo(Problem p) {
            if (this.level == p.level) return this.no - p.no;
            return this.level - p.level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Problem> problems = new TreeSet<>();
        Map<Integer, Integer> index = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            problems.add(new Problem(L, P));
            index.put(P, L);
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int P = Integer.parseInt(st.nextToken());
            if ("add".equals(command)) {
                int L = Integer.parseInt(st.nextToken());
                problems.add(new Problem(L, P));
                index.put(P, L);

            } else if ("recommend".equals(command)) {
                if (P == 1) {
                    sb.append(problems.last().no).append("\n");
                } else {
                    sb.append(problems.first().no).append("\n");
                }
            } else if ("solved".equals(command)) {
                problems.remove(new Problem(index.get(P), P));
                index.remove(P);
            }
        }
        System.out.print(sb);
    }
}
