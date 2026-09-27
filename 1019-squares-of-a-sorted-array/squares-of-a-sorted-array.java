class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;

        while(i<=j){
            if(nums[j]*nums[j] > nums[i]*nums[i]){
                ans[k] = nums[j]*nums[j];
                j--;
            }else{
                ans[k] = nums[i]*nums[i];
                i++;
            }
            k--;
        }
        return ans;
    }
}