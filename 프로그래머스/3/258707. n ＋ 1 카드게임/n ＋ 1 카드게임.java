import java.util.*;
class Solution {
    
    static int step=1,chance=0,n=0,idx=0;
    static List<List<Integer>> l = new ArrayList();
    static boolean[] visit;
    public int solution(int coin, int[] cards) {
        n=cards.length;
        idx=n/3+1;
        visit = new boolean[n];
        chance=coin;
        
        int cnt=0;
        int f=0;
        int s=0;
        
        while(true){
            cnt++;
            if(idx>=n) break;
            if(makeF(cards)) {
                idx+=2;
                step++;
                f++;
                continue;
            }
            else if(make(idx,cards)){
                idx+=2;
                step++;
                s++;
                continue;
            }
            else break;
        }
        int[] temp = {cnt,f,s};  
        return step;
    }
    static boolean make(int idx,int[] cards){
        for(int i=0;i<idx;i++){
            if(visit[i]) continue;
            int a = cards[i];
            for(int j=i+1;j<=idx;j++){
                if(visit[j]) continue;
                int b = cards[j];
                /*
                List<Integer> temp = new ArrayList();
                temp.add(a);temp.add(i);temp.add(b);temp.add(j);temp.add(a+b);temp.add(idx);
                l.add(temp);
                */
                if(a+b==n+1) {
                    if(i>=n/3 && j>=n/3 && chance>=2){
                        visit[i]=true;visit[j]=true;chance-=2;
                        return true;
                    }
                    if(i>=n/3 && j<n/3 && chance>=1){
                        visit[i]=true;visit[j]=true;chance-=1;
                        return true;
                    }
                    if(i<n/3 && j>=n/3 && chance>=1){
                        visit[i]=true;visit[j]=true;chance-=1;
                        return true;
                    }
                }
            }
        }return false;
    }
        
    
    static boolean noCards(){
        for(int i=0;i<n/3;i++){
            if(!visit[i]) return false; //false가 있다 = 아직 사용안한거 있다.
        }
        return true;
    }
    static public boolean makeF(int[] cards){
        for(int i=0;i<n/3-1;i++){
            if(visit[i]) continue;
            int a = cards[i];
            for(int j=i+1;j<n/3;j++){
                if(visit[j]) continue;
                int b = cards[j];
                if(a+b==n+1) {
                    visit[i]=true;
                    visit[j]=true;
                    return true;
                }
            }
        }
        return false;
    }
}