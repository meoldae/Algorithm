import java.util.Arrays;

public class Lv1_비밀_지도 {
    public static void main(String[] args) {
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        int n = 6;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int temp = arr1[i] | arr2[i];
            String decrypt = String.format("%"+n+"s", Integer.toBinaryString(temp));
            decrypt = decrypt.replaceAll("1", "#");
            decrypt = decrypt.replaceAll("0", " ");
            answer[i] = decrypt;
        }

        System.out.println(Arrays.deepToString(answer));

    }
}
