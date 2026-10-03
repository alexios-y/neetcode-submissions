class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        while(r<s.length()){
            while(r<s.length() && (!map.containsKey(s.charAt(r)) || (map.get(s.charAt(r))<l)) ){
                map.put(s.charAt(r),r);
                r++;
            }

            max=Math.max(max, r-l);

            if(r<s.length()){
                // map.remove(s.charAt(l));
                l=map.get(s.charAt(r))+1;
                // map.put(s.charAt(r), l);
            }
        }

        return max;
    }

    
}
