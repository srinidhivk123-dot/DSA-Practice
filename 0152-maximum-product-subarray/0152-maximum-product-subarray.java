class Solution {
    public int maxProduct(int[] nums) {
        int curMax=nums[0];
        int curMin=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            int n=nums[i];
            int tempMax=Math.max(n,Math.max(curMax*n,curMin*n));
            curMin=Math.min(n,Math.min(curMax*n,curMin*n));   
            curMax=tempMax;
            result=Math.max(result,curMax);
        }
        return result;
    }
}