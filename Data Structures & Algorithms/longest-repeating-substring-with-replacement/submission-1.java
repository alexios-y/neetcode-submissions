class Solution {
    public int characterReplacement(String s, int k) {
        int maxf=0, l=0,res=0;
        int[] freq=new int[26];
        for(int r=0;r<s.length();r++){
            maxf=Math.max(maxf, ++freq[s.charAt(r)-'A']);
//maxf might be stale after shrinking, but it is still a valid value and res is still a valid value before shrinking
//before first shrink: maxf valid, res valid and equal to maxf+k
//then shrinking: maxf same, res same, window size is maxf+k , but now maxf is stale
//we don;t need to decrease maxf because res only grow when maxf grow, decrease maxf does not help with the res
//so the window after shrinking might be invalid due to stale maxf, however the freqs of elements remain accurate in current invalid window
//when maxf grows, it uses the latest freq in current window, then it does not need to shrink, then the res will grow as well
//at this moment, maxf valid, window valid, res updated and valid - so we move on finding the max value

            while((r-l+1)-maxf>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            res=Math.max(res, r-l+1);
        }

        return res;
    }
}
