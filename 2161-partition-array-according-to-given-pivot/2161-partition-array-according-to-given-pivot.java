class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> small = new ArrayList<>();
         List<Integer> equal = new ArrayList<>();
          List<Integer> greater = new ArrayList<>();

          for(int num : nums) {

            if(num < pivot) {
                small.add(num);
            }
            else if(num == pivot) {
                equal.add(num);
            }
            else {
                greater.add(num);
            }
          }

          int ans[] = new int[nums.length];
          int idx = 0;

          for(int x : small) ans[idx++] = x;
          for(int x : equal) ans[idx++] = x;
          for(int x : greater) ans[idx++] = x;

          return ans;
        
    }
}