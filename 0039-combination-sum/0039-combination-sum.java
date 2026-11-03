class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currentSeq = new ArrayList<>();
    
    public void recursion(int target, int[] candidates, int start) {
        
        if (target == 0) {
            answer.add(new ArrayList<Integer>(currentSeq)); 
            return;
        }
        
        //  Options - for loop
        
        for(int i=start; i < candidates.length; i++)
        {
            if(target >= candidates[i])
            {
                currentSeq.add(candidates[i]);
                recursion(target - candidates[i], candidates, i);
                currentSeq.remove(currentSeq.size() -1);
            }
        }
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recursion(target, candidates, 0); 
        return answer;  
    }
}