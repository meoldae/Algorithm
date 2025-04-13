import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B33679 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] yjLis = new int[N + 1];
        int[] hgLis = new int[N + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] yj = new int[N];
        int[] hg = new int[N];
        for (int i = 0; i < N; i++) {
            yj[i] = Integer.parseInt(st1.nextToken());
            hg[i] = Integer.parseInt(st2.nextToken());
        }

        int yjMaxScore = 0;
        int hgMaxScore = 0;

        for (int i = 0; i < N; i++) {
            int yjScore = 0;
            int hgScore = 0;
            for (int j = 0; j < N; j++) {

                int yjBullet = yj[(j + i) % N];
                int hgBullet = hg[(j + i) % N];
    
    
                if (yjLis[yjScore] < yjBullet) {
                    yjLis[++yjScore] = yjBullet;
                } else {
                    int chamber = binarySearch(yjLis, yjScore, yjBullet);
                    yjLis[chamber] = yjBullet;
                }
    
                if (hgLis[hgScore] < hgBullet) {
                    hgLis[++hgScore] = hgBullet;
                } else {
                    int chamber = binarySearch(hgLis, hgScore, hgBullet);
                    hgLis[chamber] = hgBullet;
                }
            }
            yjMaxScore = Math.max(yjMaxScore, yjScore);
            hgMaxScore = Math.max(hgMaxScore, hgScore);
        }

        if (yjMaxScore > hgMaxScore) {
            System.out.println("YJ Win!");
        } else if (yjMaxScore == hgMaxScore) {
            System.out.println("Both Win!");
        } else {
            System.out.println("HG Win!");
        }
    }

    public static int binarySearch(int[] lis, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
