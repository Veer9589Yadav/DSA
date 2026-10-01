class Solution {
    public int heightChecker(int[] heights) {
        int[] increasingHeight = new int[heights.length];
        int count = 0;
        for (int i=0; i<heights.length; i++){
            increasingHeight[i] = heights[i];
        }
        Arrays.sort(increasingHeight);

        for(int i=0; i<heights.length; i++){
            if(increasingHeight[i] != heights[i]){
                count++;
            }
        }
        return count;
    }
}