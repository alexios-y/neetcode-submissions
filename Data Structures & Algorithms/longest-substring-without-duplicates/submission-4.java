class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map<Character, Integer> map=new HashMap<>();
        int[] idx=new int[128];
        Arrays.fill(idx, -1);
        int l=0, max=0;

        for(int r=0; r<s.length();r++){
            if(idx[s.charAt(r)]==-1){
                idx[s.charAt(r)]=r;
            } else{
                l=Math.max(l, idx[s.charAt(r)]+1);
                idx[s.charAt(r)]=r;
            }

            max=Math.max(max, r-l+1);
        }

        return max;
    }

    
}
