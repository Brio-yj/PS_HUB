import java.util.*;
class Solution {
    static class Point{
        int r,c;
        Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    static int[] dr ={-1,-1,0,1,1,1,0,-1};
    static int[] dc ={0,1,1,1,0,-1,-1,-1};
    
    public int solution(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        Queue<Point> q = new LinkedList();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1) q.add(new Point(i,j));
            }
        }
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<8;i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nr>=r || nc<0 || nc>=c) continue;
                board[nr][nc]=1;
            }
        }

        int answer = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==0) answer++;
            }
        }
        
        return answer;
    }
}