class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map<Character, Integer> map=new HashMap<>();
        int[] idx=new int[128];
        Arrays.fill(idx, -1);
        int l=0;
        int r=0;
        int max=0;
        while(r<s.length()){
            while(r<s.length() && idx[s.charAt(r)]<l ){
                // map.put(s.charAt(r),r);
                idx[s.charAt(r)]=r;
                r++;
            }

            max=Math.max(max, r-l);

            if(r<s.length()){
                // map.remove(s.charAt(l));
                l=idx[s.charAt(r)]+1;
                // map.put(s.charAt(r), l);
            }
        }

        return max;
    }

    
}
