class Solution {
    public boolean solution(int x) {
        int temp=x;
        int remain=0;
        while(temp!=0){
            remain =remain + temp%10;
            temp/=10;
        }
        if(x%remain==0) return true;
        else return false;
    }
}