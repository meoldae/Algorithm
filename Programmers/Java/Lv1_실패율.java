import java.util.Arrays;

public class Lv1_실패율 {
    public static void main(String[] args) {
        int N = 2;
        int[] stages = {1, 1, 1, 1};
        Arrays.sort(stages);
        double[][] failRate = new double[N][2];

        int clearUser = 0;

        for (int i = 1; i <= N; i++) {
            failRate[i-1][1] = i;
        }

        for (int stage : stages) {
            if (stage > N) clearUser++;
            else failRate[stage - 1][0] += 1.0;
        }

        for (int i = N - 1; i >= 0; i--) {
            clearUser += (int) failRate[i][0];
            if (clearUser != 0.0) {
                failRate[i][0] = failRate[i][0] / clearUser;
            }
        }

        Arrays.sort(failRate, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Double.compare(o1[1], o2[1]);
            } else {
                return Double.compare(o2[0], o1[0]);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRate[i][1];
        }

//        return answer;
    }
}
