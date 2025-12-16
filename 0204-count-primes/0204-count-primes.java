class Solution {
    final int N = 5000000;
    boolean isPrime[] = new boolean [N];
    public int countPrimes(int n) {

        for(int i=2; i<n; i++)
        {
            isPrime[i] = true;
        }
        
        for(long i=2; i<n; i++)
        {
            for(long j=i*i; j<n; j=j+i)
            {
                isPrime[(int)j] = false;
            }
        }

        int count = 0;

        for(int i = 0;i<n;i++)
        {
            if(isPrime[i] == true)
            {
                count++;
            }
        }
        return count;
    }
}