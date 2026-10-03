class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        for(int start=0; count<nums.length; start++){
            int pV = nums[start];
            int nI = start;
            do {
                nI = (nI + k) % nums.length;
                int temp = nums[nI];
                nums[nI] = pV;
                pV = temp;
                count++;
            }while(start != nI);
        }
    }
}