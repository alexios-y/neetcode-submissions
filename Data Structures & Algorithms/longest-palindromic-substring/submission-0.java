class Solution {
    public String longestPalindrome(String s) {
        //dp
        int resIdx=0, resLen=0;
        
        int[][] dp=new int[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && ((j-i)<=2 || dp[i+1][j-1]==1)){
                    dp[i][j]=1;

                    if((j-i+1)>resLen){
                        resLen=j-i+1;
                        resIdx=i;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx+resLen);
    }
}
