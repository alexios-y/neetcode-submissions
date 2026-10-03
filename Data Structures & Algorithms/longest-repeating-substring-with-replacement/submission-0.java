class Solution {
    public int characterReplacement(String s, int k) {
        int maxf=0, l=0,res=0;
        int[] freq=new int[26];
        for(int r=0;r<s.length();r++){
            maxf=Math.max(maxf, ++freq[s.charAt(r)-'A']);
            while((r-l+1)-maxf>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            res=Math.max(res, r-l+1);
        }

        return res;
    }
}
