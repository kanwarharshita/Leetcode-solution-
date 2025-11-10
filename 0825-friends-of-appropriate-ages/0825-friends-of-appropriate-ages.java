class Solution {
    public int numFriendRequests(int[] ages) {
        
        int [] count = new int[121];
        for(int age : ages) 
        count [age]++;

        int total = 0;
        for(int A = 5; A <=120; A++){
            if(count[A]==0) continue;

            for(int B = (int)(0.5*A+7)+1; B<=A; B++){
                if(count[B]==0)continue;

                if(A == B) 
                    total += count[A] * (count[A]-1);
                else
                    total += count[A] * count[B];
            }
        }
        return total;
    }
}