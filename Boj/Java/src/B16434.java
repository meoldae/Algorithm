import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long H = Long.parseLong(st.nextToken());

        long left = 0, right = (Long.MAX_VALUE / 2) - 1;
        List<long[]> rooms = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long command = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            rooms.add(new long[]{command, a, h});
        }
        while (left < right) {
            long mid = (left + right) / 2;
            if (explore(rooms, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(right);
    }

    static boolean explore(List<long[]> rooms, long maxHealth, long attack) {
        long health = maxHealth;

        for (int i = 0; i < rooms.size(); i++) {
            long[] room = rooms.get(i);
            // 몬스터와 전투
            if (room[0] == 1) {
                long monsterH = room[2];
                long turn = monsterH / attack;
                if (monsterH % attack != 0) turn++;

                if ((turn - 1) * room[1] >= health) return false;
                else health -= (turn - 1) * room[1];
                // 회복 포션
            } else if (room[0] == 2) {
                attack += room[1];
                health = Math.min(maxHealth, health + room[2]);
            }
        }
        return true;
    }
}
