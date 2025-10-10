class Solution {
    public int solution(int n) {
        int answer=0;
        for(int i=4;i<=n;i++){
            int tn =i;
            int ta =1;
            for(int j=2;j<=i;j++){
                int cnt=0;
                while(tn%j==0 && tn/j>0){
                    tn/=j;
                    cnt++;
                }
                ta *=(cnt+1);
            }
            if(ta>=3) answer++;
        }
        return answer;
    }
}