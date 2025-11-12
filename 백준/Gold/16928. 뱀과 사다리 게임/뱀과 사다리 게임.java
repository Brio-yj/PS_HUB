

import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static Map<Integer,Integer> upMap = new HashMap();
    static Map<Integer,Integer> doMap = new HashMap();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            upMap.put(num1,num2);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            doMap.put(num1,num2);
        }

        for(int i=1;i<=7;i++)board[i]=1;

        for (int i = 8; i <= 100; i++) {
            List<Integer> list = new ArrayList();
            for(int j=1;j<=6;j++){
                if(upMap.keySet().contains(i-j) || doMap.keySet().contains(i-j)) continue;
                list.add(board[i-j]);
            }
            board[i]=Collections.min(list)+1;

            if(upMap.containsValue(i)) {
                for(int key : upMap.keySet()) {
                    if(upMap.get(key)==i){
                        board[i]=Math.min(board[i],board[key]);
                        break;
                    }
                }
            }
            if(doMap.keySet().contains(i)) {
                if(board[doMap.get(i)]>board[i]){
                    board[doMap.get(i)]=board[i];
                    i=doMap.get(i);
                }
            }
        }
        System.out.println(board[100]);
    }
}