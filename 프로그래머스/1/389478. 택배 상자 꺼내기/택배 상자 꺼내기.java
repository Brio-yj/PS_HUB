class Solution {
    static int r,c;
    static int boardNum=1;
    static int[][] board;
    public int solution(int n, int w, int num) {
        r =  n/w + 1;
        c = w;
        board = new int[r][c];
        
        makeBoard(n,w);
        return solve(num);
    }
    static int solve(int num){
        int col=0;
        int answer=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==num) {
                    col =j;
                }
            }
        }
        for(int i=r-1;i>=0;i--){
            if(board[i][col]!=0) answer++;
            if(board[i][col]==num){
                return answer;
            } 
        }
        
        return -1;
    }
    static void makeBoard(int n,int w){
        for(int i=0;i<=n;i++){
            if(i%2==0){
                for(int j=0;j<w;j++){
                    board[i][j]=boardNum++;
                    if(boardNum>=n+1) return;
                }
            }
            else {
                for(int j=w-1;j>=0;j--){
                    board[i][j]=boardNum++;
                    if(boardNum>=n+1) return;
                }
            }
        }
        return;
    }
}