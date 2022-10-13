//Baekjoon 15964
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B15964{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        String[] arr = input.split(" ");

        long answer = 0;
        answer = (Long.parseLong(arr[0]) + Long.parseLong(arr[1]))*(Long.parseLong(arr[0]) - Long.parseLong(arr[1]));

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();   
    }
}