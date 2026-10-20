class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()<text2.length()){
            String tmp=text1;
            text1=text2;
            text2=tmp;
        }

        int m=text1.length();
        int n=text2.length();
        // int[][] dp=new int[m+1][n+1];
        int[] prev=new int[n+1];
        int[] cur=new int[n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // dp[i][j]=1+dp[i-1][j-1];
                    cur[j]=1+prev[j-1];
                } else{
                    // dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    cur[j]=Math.max(prev[j], cur[j-1]);
                }
            }
            int[] tmp=prev;
            prev=cur;
            cur=tmp;
        }

        return prev[n];

        // for(int i=m-1; i>=0;i--){
        //     for(int j=n-1;j>=0;j--){
        //         if(text1.charAt(i) == text2.charAt(j)){
        //             dp[i][j]=1+dp[i+1][j+1];
        //         } else{
        //             dp[i][j]=Math.max(dp[i+1][j], dp[i][j+1]);
        //         }
        //     }
        // }

        // return dp[0][0];
    }
}
