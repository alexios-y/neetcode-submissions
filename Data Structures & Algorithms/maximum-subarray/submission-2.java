class Solution {
    public int maxSubArray(int[] nums) {
        // int[] dp=new int[nums.length];
        // dp[0]=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     dp[i]=Math.max(nums[i], dp[i-1]+nums[i]);
        // }

        // int max=dp[0];
        // for(int i : dp){
        //     max=Math.max(i, max);
        // }
        // return max;

        int max=nums[0],sum=nums[0];

        for(int i=1;i<nums.length;i++){
            sum=Math.max(nums[i],nums[i]+sum);
            max=Math.max(max,sum);
        }
        return max;
    }
}
