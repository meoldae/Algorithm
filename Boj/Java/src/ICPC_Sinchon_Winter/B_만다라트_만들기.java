package ICPC_Sinchon_Winter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_만다라트_만들기 {
    static class Outer{
        String semiGoal;
        List<Inner> list = new ArrayList<>();
    }
    static class Inner{
        String detail;
        public Inner(String detail){
            this.detail = detail;
        }
    }

    static String[][] mandalart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mandalart = new String[9][9];
        for (int i = 0; i < 9; i++){
            mandalart[i] = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        }

    }
    static void divide(){

    }
}
