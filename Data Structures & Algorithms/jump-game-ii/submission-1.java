class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        // int[] dp=new int[n];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[0]=0;
        // for(int i=1;i<n;i++){
        //     for(int j=i-1;j>=0;j--){
        //         if(j+nums[j]>=i){
        //             dp[i]=Math.min(dp[i], dp[j]+1);
        //         }
        //     }
        // }

        // return dp[n-1];

        int count=0;
        int maxReach=nums[0];
        int curReach=nums[0];
        for(int i=1; i<n;i++){
            int nn=nums[i];

            if(i>curReach){
                curReach=maxReach;
                count++;
            } 
            if(curReach>=n-1){
                count++;
                break;
            }

            maxReach=Math.max(maxReach, nn+i);
        }

        return count;
    }
}
