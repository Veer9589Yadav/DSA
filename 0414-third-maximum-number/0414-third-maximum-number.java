class Solution {
    public int thirdMax(int[] nums) {
        Integer maxi1 = null;
        Integer maxi2 = null;
        Integer maxi3 = null;
        Integer count = 0;
        for (int i = 0; i<nums.length; i++ ){
            if(maxi1 != null && maxi1 == nums[i]){
                continue;
            }

            if(maxi2 != null && maxi2 == nums[i]){
                continue;
            }

            if(maxi3 != null && maxi3 == nums[i]){
                continue;
            }
            if(maxi1 == null || nums[i] > maxi1){
                maxi3 = maxi2;
                maxi2 = maxi1;
                maxi1 = nums[i];
            }else if (maxi2 == null || nums[i] > maxi2){
                maxi3 = maxi2;
                maxi2 = nums[i];
            }else if (maxi3 == null || nums[i] > maxi3){
                maxi3 = nums[i];
            }
        }
        if (maxi3 != null){
            return maxi3;
        }
        return maxi1;
    }
}