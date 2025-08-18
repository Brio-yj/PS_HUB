import java.io.*;
import java.util.*;

public class Main {
    static int tempC,C,T,R;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1-based
        tempC = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C=2*tempC-1;
        board = new int[R][C];

        //a는 그대로 b는 2n+1에 넣기,둘다 --해주고
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int miniR = Integer.parseInt(st.nextToken());
            int miniC = Integer.parseInt(st.nextToken());
            miniR--;
            miniC=2*miniC-1;
            board[miniR][miniC] = 1;
        }
        /*
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        */
        for (int i = 0; i <= 3; i++) {
            //System.out.println("start cnt = "+i);
            make_board(i, 0);
        }
        System.out.println(-1);
    }

    static void make_board(int cnt, int depth) {
        if (depth == cnt) {
            solve(cnt);
            return;
        }
        /*
        System.out.println("----------------------------");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1) System.out.print("i/j= " + i + " " + j);
            }
        }
        System.out.println();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        */
        for (int i = 0; i < R; i++) {
            for (int j = 1; j < C; j = j + 2) {
                int left  = j-2;
                int right = j+2;
                if(left>=0 && right<C){
                    if (board[i][left] != 1 && board[i][right] != 1 && board[i][j]==0) {
                        board[i][j] = 1;
                        //System.out.println("등록 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                        make_board(cnt, depth + 1);
                        board[i][j] = 0;
                        //System.out.println("해제 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                    }
                }
                //왼쪽 아웃
                else if(left<0 && right<C){
                    if (board[i][right] != 1 && board[i][j]==0) {
                        board[i][j] = 1;
                        //System.out.println("등록 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                        make_board(cnt, depth + 1);
                        board[i][j] = 0;
                        //System.out.println("해제 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                    }
                }
                //오른쪽 아웃
                else if(left>=0 && right>=C){
                    if (board[i][left] != 1 && board[i][j]==0) {
                        board[i][j] = 1;
                        //System.out.println("등록 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                        make_board(cnt, depth + 1);
                        board[i][j] = 0;
                        //System.out.println("해제 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                    }
                }
                else{
                    if (board[i][j] != 1 && board[i][j]==0) {
                        board[i][j] = 1;
                        //System.out.println("등록 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                        make_board(cnt, depth + 1);
                        board[i][j] = 0;
                        //System.out.println("해제 i/j/depth/cnt= "+i+" "+j+" "+depth+" "+cnt+" ");
                    }
                }
            }
        }
    }

    static void solve(int cnt) {
        boolean success = true;
        for (int c = 0; c < C; c = c + 2) {
            int r = 0, nc = c;
            //System.out.println("start r/c= " + r + " " + nc);
            while (r < R) {
                int left  = nc-1;
                int right = nc+1;
                //양쪽 가능
                if(left>=0 && right<C){
                    if(board[r][left]==1){
                        nc-=2;
                        r++;
                    }
                    else if(board[r][right]==1){
                        nc+=2;
                        r++;
                    }else r++;
                }
                //왼쪽 아웃
                else if(left<0 && right<C){
                    if(board[r][right]==1){
                        nc+=2;
                        r++;
                    }else r++;
                }
                //오른쪽 아웃
                else if(left>=0 && right>=C){
                    if(board[r][left]==1){
                        nc-=2;
                        r++;
                    }else r++;
                }
                //System.out.println("now r/c= " + r + " " + nc);
            }
            if (nc != c) return;
        }
        if (success) {
            System.out.println(cnt);
            System.exit(0);
        }
    }
}
