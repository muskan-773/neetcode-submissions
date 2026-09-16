class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int water = 0;
        int leftMax = height[i];
        int rightMax = height[j];
        while(i < j){
            if(leftMax < rightMax){
                i++;
                leftMax = Math.max(leftMax, height[i]);
                water += leftMax - height[i];
            }else{
                j--;
                rightMax = Math.max(rightMax, height[j]);
                water += rightMax - height[j];
            }
        }
        return water;
    }
}