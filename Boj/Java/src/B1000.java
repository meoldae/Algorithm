import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class B1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        String[] arr = s.split(" ");
        
        int answer = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}