class Solution {
    public int dominantIndex(int[] nums) {
        int Maxi = 0;
        for (int i=0; i< nums.length; i++){
            if(nums[i] > nums[Maxi]){
                Maxi = i;
            }
        }
        for (int i=0; i< nums.length; i++){
            if(i == Maxi){
                continue;
            }
            if(nums[Maxi] < 2*nums[i]){
                return -1;
            }
        }
        return Maxi;
    }
}