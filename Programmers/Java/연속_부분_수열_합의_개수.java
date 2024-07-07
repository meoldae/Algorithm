import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public static int Solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int k = 0; k < elements.length; k++) {
                int sum = 0;
                for (int j = 0; j < i; j++) {
                    sum += elements[ (k + j) % elements.length ];
                }
                set.add(sum);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] elements = new int[]{7, 9, 1, 1, 4};

        System.out.println(Solution(elements));
    }
}
