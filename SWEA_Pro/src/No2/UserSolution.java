package No2;

import java.util.Map;
import java.util.TreeMap;

class UserSolution {
    int H, W = 0;
    TreeMap<Integer, Character> map;
    int CURSOR;

    void init(int mH, int mW, char mStr[]) {
        H = mH;
        W = mW;
        map = new TreeMap<Integer, Character>();
        CURSOR = 0;
        for (int i = 0; i < mStr.length; i++) {
            if (mStr[i] == '\0') break;
            map.put(i, mStr[i]);
        }
    }

    void insert(char mChar) {
        System.out.println("200");
        Map.Entry<Integer, Character> last = null;
        Map.Entry<Integer, Character> prev = null;
        last = map.floorEntry(map.size() - 1);
        map.put(map.size(), last.getValue());
        while (last.getKey() < CURSOR) {
            prev = map.lowerEntry(last.getKey());
            map.put(last.getKey(), prev.getValue());
            last = prev;
        }
        map.put(last.getKey(), mChar);
        CURSOR++;
        /*
        제일 마지막 입력부터 역순으로
        Map.size + 1 에 Map.size 원소 put (초과하는 경우 없음)
        Map.size 부터 CURSOR 까지 업데이트
        CURSOR 위치에 mChar 삽입( 덮어씌움 )
        CURSOR + 1 ( 입력 문자 우측에 위치 )
         */
    }

    char moveCursor(int mRow, int mCol) {
        System.out.println("300");
        int target = (W * (mRow - 1)) + (mCol - 1);
        if (target >= map.size() || target == (H * W) - 1) {
            CURSOR = map.size();
            return '$';
        } else {
            CURSOR = target;
            return map.get(target);
        }
    }

    int countCharacter(char mChar) {
        System.out.println("400");
        if (map.size() == CURSOR || CURSOR == (H * W) - 1) return 0;
        int count = 0;

        Map.Entry<Integer, Character> entry = map.ceilingEntry(CURSOR);
        if (entry == null) return 0;
        while(entry.getKey() < map.size() - 1) {
            if (entry.getValue() == mChar) count++;
            entry = map.higherEntry(entry.getKey());
        }
        return count;
    }
}