class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;

        int r = 0;
        int c = totalCol-1;

        while(r < totalRow && c >=0){
            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] > target){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
}