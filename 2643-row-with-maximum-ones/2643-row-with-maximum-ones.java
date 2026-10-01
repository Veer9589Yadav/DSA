class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int[] ansArr = new int[2];

        int totalRow = mat.length;
        int totalCol = mat[0].length;

        int maxi = -1;
        int ansRowIndex = 0;
        int ansCount1 = 0;

        for (int r = 0; r < totalRow; r++) {

            int oneCount = 0;

            // Count 1's in the current row
            for (int c = 0; c < totalCol; c++) {
                if (mat[r][c] == 1) {
                    oneCount++;
                }
            }

            // Update maximum and answer
            if (oneCount > maxi) {
                maxi = oneCount;
                ansRowIndex = r;
                ansCount1 = oneCount;
            }
        }

        ansArr[0] = ansRowIndex;
        ansArr[1] = ansCount1;

        return ansArr;
    }
}