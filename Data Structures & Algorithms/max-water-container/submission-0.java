class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n-1;
        int maxWater = 0;

        while(i < j){
            int wt = j - i;
            int ht = Math.min(height[i], height[j]);
            int area = wt * ht;
            maxWater = Math.max(area, maxWater);
            if(height[i] > height[j]) j--;
            else i++;
        }
        return maxWater;
    }
}