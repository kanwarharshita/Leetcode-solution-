class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int sum = 0;
       int answer = 0;

       for(int i = 0; i<nums.length;i++){
        if(nums[i] == 1){
            sum++;
        } else {
            sum=0;
        }

        if(sum > answer){
            answer = sum;
        }
       } 

       return answer;
        
    }
}