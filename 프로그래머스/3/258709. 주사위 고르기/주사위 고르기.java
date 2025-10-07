import java.util.*;
class Solution {
    static class Score{
        int cnt,idx;
        Score(int cnt, int idx){
            this.cnt=cnt;
            this.idx=idx;
        }
    }
    
    static int n;
    static boolean[][] visit;
    
    static List<Score> sList = new ArrayList();
    static List<Integer> recList;
    static List<List<Integer>> aList = new ArrayList();
    static List<List<Integer>> bList = new ArrayList();
    static List<List<Integer>> aSumList = new ArrayList();
    static List<List<Integer>> bSumList = new ArrayList();
    
    public List<Integer> solution(int[][] dice) {
        n = dice.length;
        visit= new boolean[2][n];
        makeA(0,0,dice);
        makeSum(aList,bList,dice);
        cal();
        sList.sort((n1,n2)->n2.cnt-n1.cnt);
        
        List<Integer> temp = new ArrayList();
        for(int i=0;i<aList.get(sList.get(0).idx).size();i++){
            temp.add(aList.get(sList.get(0).idx).get(i)+1);
        }
        
        return temp;
    }
    //a원소가 blist에 첫 등장하는 idx 그대로 리턴
    //- 나오거나 length 자체가 나올때 고민 -> 0,length 그대로 리턴
    static public int leftSearch(int num,int lo,int hi,int idx){
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(bSumList.get(idx).get(mid)<num) lo=mid+1;
            else hi=mid;
        }
        return lo;
    }
    static public void cal(){
        for(int i=0;i<aSumList.size();i++){
            Collections.sort(bSumList.get(i));
            int cnt=0;
            for(int j=0;j<aSumList.get(i).size();j++){
                cnt+=leftSearch(aSumList.get(i).get(j),0,bSumList.get(i).size(),i);
            }
            sList.add(new Score(cnt,i));
        }
    }
    static public void makeSum(List<List<Integer>> aList,List<List<Integer>> bList,int[][] dice){
        int size = aList.get(0).size();
        for(int i=0;i<aList.size();i++){
            recList = new ArrayList();
            makeRec(aList,i,size,0,0,dice);
            aSumList.add(recList);
        }
        for(int i=0;i<bList.size();i++){
            recList = new ArrayList();
            makeRec(bList,i,size,0,0,dice);
            bSumList.add(recList);
        }
    }
    static public void makeRec(List<List<Integer>> llist,int idx,int size,int depth,int sum,int[][] dice){
        if(depth==size){
            recList.add(sum);
            return;
        }
        for(int i=0;i<6;i++){
            sum+=dice[llist.get(idx).get(depth)][i];
            makeRec(llist,idx,size,depth+1,sum,dice);
            sum-=dice[llist.get(idx).get(depth)][i];
        }
    }
    
    static public void makeA(int start,int depth,int[][] dice){
        if(depth==n/2){
            List<Integer> temp = new ArrayList();
            for(int i=0;i<n;i++)if(visit[0][i])temp.add(i);
            aList.add(temp);
            makeB(0,0,dice);
            return;
        }
        for(int i=start;i<n;i++){
            if(!visit[0][i]){
                visit[0][i]=true;
                makeA(i+1,depth+1,dice);
                visit[0][i]=false;
            }
        }
    }
    static public void makeB(int start,int depth,int[][] dice){
        if(depth==n/2){
            List<Integer> temp = new ArrayList();
            for(int i=0;i<n;i++)if(visit[1][i])temp.add(i);
            bList.add(temp);
            return;
        }
        for(int i=start;i<n;i++){
            if(!visit[0][i] && !visit[1][i]){
                visit[1][i]=true;
                makeB(i+1,depth+1,dice);
                visit[1][i]=false;
            }
        }
    }
}