class Solution {

    static boolean isvalidAnswer(int nums[], int k, int maxpages){
        //check whether mid or maxpages is valid or not
        int studentCount = 1;
        int pages = 0;

        for(int i=0; i<nums.length; i++){
            if(pages + nums[i] <= maxpages){
                pages = pages + nums[i];
            }
            else{
                studentCount++;
                if(studentCount > k || nums[i] > maxpages){
                    return false;
                }
                else{
                    pages =0;
                    pages = pages + nums[i];
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length < k){
            return -1;
        }
        int n = nums.length;
        int s = 1;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum +=nums[i];
        }
        int e = sum;
        int ans = 0;

        while (s <= e){
            int mid = s +(e-s)/2;

            if (isvalidAnswer(nums,k,mid)){
                //true wala case
                ans = mid;
                e = mid - 1;
            }
            else{
                //false wala case
                s = mid +1;
            }
        }
        return ans;
    }
}