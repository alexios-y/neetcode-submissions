class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen=new boolean[128];
        int l=0;
        int r=0;
        int max=0;
        while(l<=r && r<s.length()){
            while(r<s.length() && !seen[s.charAt(r)] ){
                seen[s.charAt(r)]=true;
                r++;
            }

            max=Math.max(max, r-l);
            seen[s.charAt(l)]=false;
            l++;
        }

        return max;
    }

    
}
