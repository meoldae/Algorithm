package SONGDO_CodeMaster_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_CodeMaster_2023 {
    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String answer = "";
        if ("SONGDO".equals(input)) answer = "HIGHSCHOOL";
        else if("CODE".equals(input)) answer = "MASTER";
        else if("2023".equals(input)) answer = "0611";
        else if ("ALGORITHM".equals(input)) answer = "CONTEST";
        System.out.print(answer);
    }
}
