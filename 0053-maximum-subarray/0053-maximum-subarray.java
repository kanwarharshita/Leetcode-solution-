class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maximumSum = nums[0];

        for(int i=1;i<nums.length;i++){
            
            int option1 = nums[i];
            int option2 = nums[i]+currentSum;

            currentSum = Math.max(option1, option2);

            if(currentSum > maximumSum){
                 maximumSum = currentSum ;
            }
        }

        return maximumSum;
        
    }
}