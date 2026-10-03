class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result.add(new ArrayList<Integer>());
        result.get(0).add(1);

        for (int r=1; r<numRows; r++){
            List<Integer> newRow = new ArrayList<>();

            newRow.add(1);
            List<Integer> prevRow = result.get(r-1);
            for(int i=1; i<r ; i++){
                newRow.add(prevRow.get(i) + prevRow.get(i-1));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}