class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long minTime = Integer.MAX_VALUE;
        for (int t : time) minTime = Math.min(minTime, t);

        long lo = 1, hi = minTime * totalTrips;   // fastest bus does all trips alone

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (canComplete(mid, time, totalTrips)) hi = mid;
            else lo= mid + 1;
        }
        return lo;
    }

    private boolean canComplete(long t, int[] time, int totalTrips) {
        long trips = 0;
        for (int d : time) {
            trips += t / d;
            if (trips >= totalTrips) return true;   // early exit guards overflow
        }
        return false;
    }
}