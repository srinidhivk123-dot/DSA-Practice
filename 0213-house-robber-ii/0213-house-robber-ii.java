class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];                       
        return Math.max(robLine(nums,0,n-2),          
                        robLine(nums,1,n-1));
    }
    private int robLine(int[] nums,int lo,int hi){
        int prev2=0,prev1=0;
        for(int i=lo;i<=hi;i++){
            int current=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}