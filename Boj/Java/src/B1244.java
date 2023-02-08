import java.io.*;
import java.util.StringTokenizer;

public class B1244 {
    static int[] switches;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        switches = new int[n];
        for (int i = 0; i < n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine());
        for (int s = 0; s < students; s++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if (flag == 1) changeMale(location);
            else changeFemale(location);
        }
        for (int i = 1; i <= n; i++){
            bw.write(switches[i-1]+" ");
            if (i % 20 == 0){
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void changeMale(int idx){
        for (int i = 1; idx*i <= n; i++){
            switches[idx*i-1] = (switches[idx*i-1] + 1) % 2;
        }
    }
    static void changeFemale(int idx){
        switches[idx-1] = (switches[idx-1] + 1) % 2;
        for (int i = 1; i <= Math.min(idx-1, n-idx); i++){
            if (switches[idx-1-i] == switches[idx-1+i]){
                switches[idx-1-i] = (switches[idx-1-i] + 1) % 2;
                switches[idx-1+i] = (switches[idx-1+i] + 1) % 2;
            }
            else{
                return;
            }
        }
    }
}
