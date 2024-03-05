import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B7490 {
    static StringBuilder answer = new StringBuilder();
    static int N;
    static char[] operands;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            operands = new char[N - 1];
            backtracking(0);
            answer.append("\n");
        }
        System.out.println(answer);
    }

    public static void backtracking(int count) {
        if (count == N - 1) {
            StringBuilder sb = new StringBuilder();

            Deque<Integer> numbers = new ArrayDeque<>();
            numbers.offer(1);

            for (int i = 0; i < (N * 2) - 1; i++) {
                if ((i & 1) == 0) {
                    sb.append((i / 2) + 1);
                } else {
                    char operand = operands[i / 2];
                    sb.append(Character.toString(operand));
                    if (operand == ' ') numbers.offerLast(numbers.pollLast() * 10 + (i / 2) + 2);
                    else numbers.offerLast((i / 2) + 2);
                }
            }

            int sum = numbers.pollFirst();
            for (int i = 0; i < N - 1; i++) {
                if (operands[i] == ' ') continue;
                if (operands[i] == '+') sum += numbers.pollFirst();
                else if (operands[i] == '-') sum -= numbers.pollFirst();
            }

            if (sum == 0) answer.append(sb).append("\n");
            return;
        }

        operands[count] = ' ';
        backtracking(count + 1);

        operands[count] = '+';
        backtracking(count + 1);

        operands[count] = '-';
        backtracking(count + 1);

    }
}
