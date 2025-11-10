class Solution {
    public String convert(String s, int numRows) {
          ArrayList<ArrayList<Character>> arr = new ArrayList<> ();
           if (numRows == 1) {
            return s; 
           }

        for(int i=0; i< numRows ; i++){
            ArrayList<Character> currentRow = new ArrayList<>();
            arr.add(new ArrayList<>(currentRow));
        }

        int rowIndex = 0;
        int turn = 0;

        for(int i=0; i<s.length();i++){
            arr.get(rowIndex).add(s.charAt(i));

            if(turn == 0){
                rowIndex ++ ;
                
                if(rowIndex == numRows){
                    rowIndex = rowIndex - 2;
                    turn = 1;
                }
            } 
            else {
                rowIndex --;

                if(rowIndex == -1){
                    rowIndex = rowIndex + 2;
                    turn = 0;
                }

            }

        }

         StringBuilder answer = new StringBuilder("");
            
            for(int i=0;i<arr.size();i++){
                for(int j=0;j<arr.get(i).size();j++){
                    answer.append(arr.get(i).get(j));
                }
            }
            
        return answer.toString();
    }
}