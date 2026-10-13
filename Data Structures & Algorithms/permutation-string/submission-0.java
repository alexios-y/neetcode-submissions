class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;

        int m=s1.length();
        int n=s2.length();
        int[] freq1 = new int[26];
        int[] freq2= new int[26];
        for(char c: s1.toCharArray()){
            freq1[c-'a']++;
        }
        int need=0;
        for(int i : freq1){
            if(i!=0){
                need++;
            }
        }
        int have=0,l=0;
        for(int r=0;r<n;r++){
            int idx=s2.charAt(r)-'a';
                            ++freq2[idx];
                if(freq2[idx] == freq1[idx]) {
                    have++;
                } else if(freq2[idx] == freq1[idx]+1){
                    have--;
                }
            if(r-l+1 < m){
                continue;
            }
            if(have==need)
                return true;

            int idxL=s2.charAt(l)-'a';
            freq2[idxL]--;
            if(freq2[idxL]==freq1[idxL]-1){
                have--;
            } else if( freq2[idxL]==freq1[idxL]){
                have++;
            }    
            l++;
        }

        return false;
    }
}
