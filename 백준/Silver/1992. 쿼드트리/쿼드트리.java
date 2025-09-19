
import java.io.*;
import java.util.*;
public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int d=N;
        board = new int[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                board[i][j]=s.charAt(j)-'0';
            }
        }//BOARD
        solve(0,0,d);
        System.out.println(sb);
    }
    public static boolean same(int startR,int startC,int d){
        int standard = board[startR][startC];
        //if(startR==4 && startC==4 && d==4) System.out.println(standard);
        for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                //if(startR==4 && startC==4 && d==4) System.out.print(board[i][j]);
                if(standard!=board[startR+i][startC+j]) return false;
            }
            //if(startR==4 && startC==4 && d==4) System.out.println();
        }
        return true;
    }
    public static void solve(int r,int c,int d){
        if(same(r,c,d)){
            sb.append(board[r][c]);
            return;
        }
        if(d==1) {
            sb.append(board[r][c]);
            return;
        }
        sb.append("(");
        solve(r,c,d/2);
        solve(r,c+d/2,d/2);
        solve(r+d/2,c,d/2);
        solve(r+d/2,c+d/2,d/2);
        sb.append(")");
    }
}
