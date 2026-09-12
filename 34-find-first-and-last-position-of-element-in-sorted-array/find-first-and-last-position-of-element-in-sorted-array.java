class Solution {
        static int getLowerBound(int arr[], int target){
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int ans = n;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] >= target){
                //ans store
                ans = mid;
                //move left
                e = mid -1;
            }
            else{
                //move to right
                s = mid +1;
            }
        }
        return ans;
    }

    static int getUpperBound(int arr[], int target){
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int ans = n;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] <= target){
                //move to right
                s = mid +1;
            }
            else{ //arr[mid] > target
                //ans store
                ans = mid;
                //move left
                e = mid -1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        int lbIndex = getLowerBound(nums,target);
        int upIndex = getUpperBound(nums,target);
        if (lbIndex == nums.length || nums[lbIndex] != target) {
            return new int[]{-1, -1};
        }
        arr[0] = lbIndex;
        arr[1] = upIndex -1;
        return arr;
    }
}