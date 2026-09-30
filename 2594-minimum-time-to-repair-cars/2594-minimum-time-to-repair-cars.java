class Solution {

    static boolean isValidAns(int ranks[], int totalCars, long timeLimit) {
        long carCount = 0;
        // ek-ek karke har mechanic ke paas jaenge
        for (int i = 0; i < ranks.length; i++) {
            int currentMechRank = ranks[i];
            // rank * cars^2 <= timeLimit
            // cars = sqrt(timeLimit / rank)
            long carsByThisMechanic =
                (long) Math.sqrt(timeLimit / currentMechRank);
            carCount += carsByThisMechanic;
            // required cars repair ho gaye
            if (carCount >= totalCars) {
                return true;
            }
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        // Minimum rank = fastest mechanic
        int minRank = ranks[0];
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] < minRank) {
                minRank = ranks[i];
            }
        }
        long s = 0;
        // Fastest mechanic repairing all cars
        long e = (long) minRank * cars * cars;
        long ans = e;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (isValidAns(ranks, cars, mid)) {
                // mid time is enough
                // try smaller time
                ans = mid;
                e = mid - 1;
            }
            else {
                // mid time is not enough
                // need more time
                s = mid + 1;
            }
        }
        return ans;
    }
}