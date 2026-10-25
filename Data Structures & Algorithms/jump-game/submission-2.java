class Solution {
    public boolean canJump(int[] nums) {
        // boolean[] dp=new boolean[nums.length];
        // dp[0]=true;
        // for(int i=1;i<nums.length;i++){
        //     for(int j=i-1; j>=0;j--){
        //         if(dp[j] && ((nums[j]+j)>=i)){
        //             dp[i]=true;
        //             break;
        //         }
        //     }
        // }

        // return dp[nums.length-1];

        int maxReach=0;
        for(int i=0;i<nums.length;i++){
            if(i<=maxReach){
                maxReach=Math.max(maxReach, i+nums[i]);
                if(maxReach>=nums.length-1){
                    return true;
                }
            } else{
                return false;
            }
        }

        return true;
    }
}
