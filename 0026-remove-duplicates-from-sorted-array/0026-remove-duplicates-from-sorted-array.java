class Solution {
    public int removeDuplicates(int[] nums) {

        int i=0;
        int j=0;
        int index = 0;

        int n= nums.length;

        while(i<n){

            nums[index] = nums[i];
            index++;

            while(j<n && nums[i] == nums[j]){
                j++;
            }
            i=j;
        }

        return index;
        
    }
}