import java.util.*;
class Solution {
    static int answer=0;
    static List<Integer> l = new ArrayList();
    public Integer solution(int[] nums) {
        makeTuple(nums,0,0,0);
        return answer;
    }
    void makeTuple(int[] nums,int start,int depth,int num){
        if(depth==3){
            for(int i=2;i<num;i++){
                if(num%i==0) return;
            }
            answer++;
            return;
        }
        for(int i=start;i<nums.length;i++){
            num+=nums[i];
            makeTuple(nums,i+1,depth+1,num);
            num-=nums[i];
        }
    }
}