class Solution {
    public int totalWaviness(int num1, int num2) {
        
        int ans = 0;
         
         for(int x= num1; x <= num2; x++) {
            ans += waviness(x);
         }
         return ans;
    }
     private int waviness (int x) {
        char[] arr = String.valueOf(x).toCharArray();

        if(arr.length < 3) {
            return 0;
        }

        int count = 0;

        for(int i = 1; i<arr.length-1;i++) {
            if((arr[i] > arr[i-1] && arr[i] > arr[i + 1]) || 
                (arr[i] < arr[i-1] && arr[i] < arr[i + 1]))  {

                    count ++;
                }
        }

        return count;
     }
}