class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int hi = 0;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }
        int ans = hi;

        while(l <= hi){
            int k = l + (hi - l)/2;

            long hours = 0;
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }
            if (hours <= h) {
                ans = k;
                hi = k - 1;
            } else l = k + 1;
        }
        return ans;
    }
}