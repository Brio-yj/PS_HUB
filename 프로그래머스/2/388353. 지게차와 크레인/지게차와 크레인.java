import java.util.*;
class Solution {
    static class Point{
        int r,c;
         Point(int r,int c){
            this.r =r;
            this.c =c;
        }        
    }
    static int answer,R,C;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static boolean[][] visit;
    static Character[][] board;
    
    static Map<Character,List<Point>> map = new HashMap();
    
    static List<Point> l = new LinkedList();
    public int solution(String[] storage, String[] requests) {
        R = storage.length;
        C = storage[0].length();
        answer = R*C;
        

        visit = new boolean[R][C];
        board = new Character[R][C];

        for(int i=0;i<R;i++){
            String s = storage[i];
            for(int j=0;j<C;j++){
                board[i][j]=s.charAt(j);
                map.computeIfAbsent(s.charAt(j),k-> new ArrayList()).add(new Point(i,j));
            }
        }
        
        for(int i=0;i<requests.length;i++){
            if(requests[i].length()==1) solve1(requests[i].charAt(0));
            else solve2(requests[i].charAt(0));
        }
        
        return answer;
    }
    
    static void solve1(char ch){
        Queue<Point> q = new LinkedList();
        boolean[][] tempVisit = new boolean[R][C];
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(i==0 || i==R-1 || j==0 || j==C-1){
                    if(visit[i][j]) {
                        q.add(new Point(i,j));
                        tempVisit[i][j]=true;
                    }
                    else if(board[i][j]==ch){    //해당 문자열은 바로 삭제, temp에 기록
                        tempVisit[i][j]= true;
                        visit[i][j]=true;

                        answer--;
                    }
                } 
            }
        }
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if(nr<0 || nr>=R || nc<0 || nc>=C || tempVisit[nr][nc]) continue;
                if(visit[nr][nc]) {
                    q.add(new Point(nr,nc));
                    tempVisit[nr][nc]=true;
                }
                else if(board[nr][nc]==ch){ 
                    tempVisit[nr][nc]=true;
                    visit[nr][nc]=true;
                    
                    answer--;
                }
            }
        }
        return;
    }
    static void solve2(char ch){
        for(int i=0;i<map.getOrDefault(ch,new ArrayList()).size();i++){
            Point cur = map.get(ch).get(i);
            if(visit[cur.r][cur.c]) continue;
            
            visit[cur.r][cur.c]=true;

            answer--;
        }
        return;
    }
}