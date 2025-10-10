class Solution {
    public int solution(int[] sides) {
        int A=0,B=0;
        int[] temp = new int[2];
        
        int cnt=0;
        int a = sides[0];
        int b = sides[1];
        int l=Math.max(a,b);
        int s=Math.min(a,b);
        int n = l-s+1;
        
        for(int i=n;l>=i;i++)cnt++;
        for(int i=Math.max(a,b)+1;i<a+b;i++)cnt++;
        
        temp[0]=A;
        temp[1]=B;
        return cnt;
    
    }
}

/*

    둘중에 더 큰게 가장 긴 변 or
    l=Math.max(a,b)
    s=Math.min(a,b)
    int new = l-s+1;
    for(int i=new;b>=i;i++)cnt++;
    새로운게 가장 긴 변
    for(int i=Math.max(a,b)+1;i<a+b;i++)cnt++;
    
*/