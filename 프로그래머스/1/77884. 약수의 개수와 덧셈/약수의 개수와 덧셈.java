import java.util.*;
class Solution {
    public Integer solution(int left, int right) {
        Map<Integer,Integer> map = new HashMap();
        int answer =0;
        for(int i=left;i<=right;i++){
            int temp = cal(i);
            if(temp%2==0) answer+=i;
            else answer-=i;
        }
        return answer;
    }
    
    static Integer cal(int num){
        Map<Integer,Integer> map = new HashMap();
        int temp=num;
        for(int i=2;i<=num;i++){
            int cnt=0;
            while(temp%i==0 && temp/i>0){
                temp/=i;
                cnt++;
            }
            if(cnt!=0)map.put(i,cnt);
        }
        int answer=1;
        for(int i=2;i<=num;i++){
            answer*=(map.getOrDefault(i,0)+1);
        }
        return answer;
    }
}
    