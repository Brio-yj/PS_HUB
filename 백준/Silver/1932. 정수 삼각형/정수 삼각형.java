
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> board = new ArrayList();

        for(int i=0;i<n;i++) {
            board.add(new ArrayList());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                int num = Integer.parseInt(st.nextToken());
                board.get(i).add(num);
            }
        }
/*
        for(int i=0;i<n;i++){
            for(int j=0;j<board.get(i).size();j++){
                System.out.print(board.get(i).get(j)+" ");
            }
            System.out.println();
        }
 */
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int now = board.get(i).get(j);
                if(j==0) board.get(i).set(j,now+board.get(i-1).get(j));
                else if(j==i) board.get(i).set(j,now+board.get(i-1).get(j-1));
                else board.get(i).set(j,now + Math.max(board.get(i-1).get(j-1),board.get(i-1).get(j)));
            }
        }
        board.get(n-1).sort((a,b)->{return b-a;});
        System.out.println(board.get(n-1).get(0));
    }
}