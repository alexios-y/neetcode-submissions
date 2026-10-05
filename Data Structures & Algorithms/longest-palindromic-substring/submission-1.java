class Solution {
    public String longestPalindrome(String s) {
        //dp
        int resIdx=0, resLen=0;
        
        // int[][] dp=new int[s.length()][s.length()];
        // for(int i=s.length()-1;i>=0;i--){
        //     for(int j=i;j<s.length();j++){
        //         if(s.charAt(i)==s.charAt(j) && ((j-i)<=2 || dp[i+1][j-1]==1)){
        //             dp[i][j]=1;

        //             if((j-i+1)>resLen){
        //                 resLen=j-i+1;
        //                 resIdx=i;
        //             }
        //         }
        //     }
        // }

        //two pointer
        for(int i=0;i<s.length();i++){
            //odd length
            int l=i, r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int len=r-l+1;
                if(len>resLen){
                    resLen=len;
                    resIdx=l;
                }

                l--;
                r++;
            }

            //even length, all possible palindrome strings' left centers can only be within [0,n-1] which will be all covered in loop 
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int len=r-l+1;
                if(len>resLen){
                    resLen=len;
                    resIdx=l;
                }

                l--;
                r++;
            }
        }

        return s.substring(resIdx, resIdx+resLen);
    }
}
