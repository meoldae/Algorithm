package ICPC_Sinchon_Winter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_알파벳_블록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> flags = new ArrayDeque();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1){
                flags.push(1);
                deque.addLast(st.nextToken());
            }else if (command == 2){
                flags.push(2);
                deque.addFirst(st.nextToken());
            }else {
                if (!deque.isEmpty() && !flags.isEmpty()){
                    if (flags.pop() == 1)deque.pollLast();
                    else deque.poll();
                }
            }
        }
        if (deque.size() == 0){
            System.out.println(0);
            return;
        }
        System.out.println(String.join("", deque));
    }
}