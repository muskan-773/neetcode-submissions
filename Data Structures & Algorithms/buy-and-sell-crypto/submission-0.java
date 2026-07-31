class Solution {
    public int maxProfit(int[] arr) {
        int maxP = 0;
        int minP = Integer.MAX_VALUE;
        for(int i = 0;i < arr.length;i++){
            minP = Math.min(arr[i],minP);
            maxP = Math.max(arr[i] - minP, maxP);
        }
        return maxP;
    }
}
