class Solution {
    int[] manacher(String s){
        StringBuilder sb=new StringBuilder("$");
        for(char c: s.toCharArray()){
            sb.append(c).append("$");
        }

        String ss=sb.toString();
        int n=ss.length();
        int[] p = new int[n];
        int l, r;
        l=r=0;
        for(int i=0;i<n;i++){
            if(i<r){
                p[i]=Math.min(r-i, p[l+r-i]);
            }

            while(i+p[i]+1<n && i-p[i]-1>=0 && ss.charAt(i+p[i]+1)==ss.charAt(i-p[i]-1)){
                p[i]++;
            }

            if(i+p[i]>r){
                r=i+p[i];
                l=i-p[i];
            }
        }

        return p;
    }

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

        // //two pointer
        // for(int i=0;i<s.length();i++){
        //     //odd length
        //     int l=i, r=i;
        //     while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
        //         int len=r-l+1;
        //         if(len>resLen){
        //             resLen=len;
        //             resIdx=l;
        //         }

        //         l--;
        //         r++;
        //     }

        //     //even length, all possible palindrome strings' left centers can only be within [0,n-1] which will be all covered in loop 
        //     l=i;
        //     r=i+1;
        //     while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
        //         int len=r-l+1;
        //         if(len>resLen){
        //             resLen=len;
        //             resIdx=l;
        //         }

        //         l--;
        //         r++;
        //     }
        // }

/**
s[j] sits at t[2j + 1]. Every letter is at an odd index and every # is at an even index. Going back, a letter at odd index k in t is s[(k - 1) / 2].
Fact 2: a maximal palindrome in t starts and ends on #

The palindrome at center i with radius p[i] covers t[i - p[i] .. i + p[i]]. As shown earlier, it always begins and ends on a #, and it contains exactly p[i] letters. So:

Length in s = p[i] = resLen
The left end i - p[i] is a #, so it's an even index.
*/

int[] p =manacher(s);
        for(int i=0;i<p.length;i++){
            if(p[i]>resLen){
                resLen=p[i];
                resIdx= (i-p[i])/2;
            }
        }

        return s.substring(resIdx, resIdx+resLen);
    }
}
