class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || s.length()==0){
            return "";
        }

        Map<Character,Integer> countT=new HashMap<>();
        Map<Character, Integer> countS=new HashMap<>();

        for(Character c:t.toCharArray()){
            countT.merge(c, 1, Integer::sum);
        }

        int[] idx=new int[]{-1,-1};
        int minSize=Integer.MAX_VALUE;
        int l=0, have=0,need=countT.size();
        for(int r=0;r<s.length();r++){
            countS.merge(s.charAt(r), 1, Integer::sum);
            if(countS.get(s.charAt(r)).equals(countT.getOrDefault(s.charAt(r),0))){
                have++;
            }

            while(have==need){
                if(r-l+1<minSize){
                    minSize=r-l+1;
                    idx[0]=l;
                    idx[1]=r;
                }
            countS.merge(s.charAt(l), -1, Integer::sum);
            if(countS.get(s.charAt(l))<countT.getOrDefault(s.charAt(l),-1)){
                have--;
            }
            l++;

            }
        }

        return minSize==Integer.MAX_VALUE? "":s.substring(idx[0], idx[1]+1);
    }
}
