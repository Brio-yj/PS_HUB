import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> uMap = new HashMap();
        int n = friends.length;
        int[] score = new int[n];
        int[][] uBoard = new int[n][n];
        
        for(int i=0;i<n;i++){
            uMap.put(friends[i],i);
        }
        // 친구-> 번호
        for(int i=0;i<gifts.length;i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            
            int idx1 = uMap.get(st.nextToken());
            int idx2 = uMap.get(st.nextToken());
            
            score[idx1]++;
            score[idx2]--;
            
            uBoard[idx1][idx2]++;
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(uBoard[i][j]>uBoard[j][i]) cnt++;
                else if(uBoard[i][j]==uBoard[j][i] && score[i]>score[j]) cnt++;
            }
            answer = Math.max(answer,cnt);
        }    
        return answer;
    }
}