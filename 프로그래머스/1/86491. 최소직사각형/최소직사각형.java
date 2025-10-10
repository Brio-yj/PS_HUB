import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        List<Integer> minList = new ArrayList();
        List<Integer> maxList = new ArrayList();
        for(int i=0;i<sizes.length;i++){
            int f = sizes[i][0];
            int s = sizes[i][1];
            
            int mi = Math.min(f,s);
            int ma = Math.max(f,s);
            
            minList.add(mi);
            maxList.add(ma);
        }
        
        minList.sort((a,b)-> b-a);
        maxList.sort((a,b)-> b-a); 
        
        return minList.get(0)*maxList.get(0);
    }
}