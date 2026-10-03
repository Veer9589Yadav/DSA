class Solution {
    public int pivotIndex(int[] nums) {
        int LeftSum = 0;
        int RightSum = 0;
        for(int i = 0; i<nums.length; i++){
            RightSum += nums[i];
        }
        for(int i=0; i<nums.length; i++){
            if(LeftSum == RightSum - nums[i]){
                return i;
            }
            LeftSum += nums[i];
            RightSum -= nums[i];
        }
        return -1;
    }
}