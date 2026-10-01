class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n-1;

        while(s <= e){
            int mid = s + (e-s)/2;

            //single element
            if(s == e){
                return nums[s];
            }

            int cv = nums[mid];

            int pv =-1;
            if(mid-1 >= 0){
                pv = nums[mid-1];
            }

            int nv = -1;
            if(mid+1 < n){
                nv = nums[mid+1];
            }
            if( cv != pv && cv != nv){
                return nums[mid];
            }

            if(cv == nv && mid%2 == 0 || cv == pv && mid%2 == 1){
                s = mid +1;
            }
            if(cv == nv && mid%2 == 1 || cv == pv && mid%2 == 0){
                e = mid -1;
            }
        }
        return -1;
    }
}