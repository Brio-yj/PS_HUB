class Solution {
    public int solution(int[] numbers, int k) {
        int idx=1;
        for(int i=0;i<k-1;i++){
            idx+=2;
            if(idx>numbers.length) idx %=numbers.length ;
        }
        return idx;
    }
}