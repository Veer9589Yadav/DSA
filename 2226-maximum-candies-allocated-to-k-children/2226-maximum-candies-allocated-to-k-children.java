class Solution {
    static boolean isValidAns(int candies[], long k, int candiesPerChild) {
        long totalChildren = 0;
        for (int i = 0; i < candies.length; i++) {
            totalChildren += candies[i] / candiesPerChild;
            if (totalChildren >= k) {
                return true;
            }
        }
        return false;
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int s = 1;
        int maxCandies = 0;

        for (int i = 0; i < n; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }
        int ans = 0;
        int e = maxCandies;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValidAns(candies, k, mid)) {
                ans = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return ans;
    }
}