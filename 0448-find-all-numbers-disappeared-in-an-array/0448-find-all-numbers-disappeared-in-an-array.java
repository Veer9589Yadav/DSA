class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int curNum =  Math.abs(nums[i]);
            int idx = curNum -1;

            if(nums[idx] < 0){
                continue;
            }

            nums[idx] = -1 * nums[idx];
        }

        List<Integer> res = new LinkedList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}