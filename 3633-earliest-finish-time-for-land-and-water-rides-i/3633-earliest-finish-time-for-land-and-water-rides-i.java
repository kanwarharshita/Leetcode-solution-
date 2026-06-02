class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int x = calc(
            
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        );

         int y = calc(
            
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        );
   
        return Math.min(x,y);
    }

    private int calc(
            
         int[]  start1,
          int[]  durr1,
          int[]  start2,
          int[]  durr2
        ) {

            int minEnd = Integer.MAX_VALUE;

            for(int i=0; i < start1.length; i++){
                minEnd = Math.min(
                    minEnd,
                    start1[i] + durr1[i]
                );
            }

            int ans = Integer.MAX_VALUE;

            for(int i=0; i < start2.length; i++) {
                 int finish = 
                 Math.max(minEnd, start2[i])
                 + durr2[i];

                 ans = Math.min(ans, finish);
            }

            return ans;
        }

}