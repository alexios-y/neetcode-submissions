class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = n-1; i >=0;i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                }
            }
            maxLen=Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
