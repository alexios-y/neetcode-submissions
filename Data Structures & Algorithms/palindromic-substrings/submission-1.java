class Solution {
    public int countSubstrings(String s) {
        int res=0;
        // for(int i=0;i<s.length();i++){
        //     int l,r;
        //     l=i;
        //     r=i;
        //     while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
        //         res++;
        //         l--;
        //         r++;
        //     }


        //     l=i;
        //     r=i+1;
        //     while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
        //         res++;
        //         l--;
        //         r++;
        //     }
        // }

        int[] p = manacher(s);
        for(int i : p){
            res+= (i+1)/2;
        }
        return res;
    }

    int[] manacher(String s){
        StringBuilder sb=new StringBuilder("@");
        for(char c:s.toCharArray()){
            sb.append(c).append("@");
        }

        String ss=sb.toString();
        int n = ss.length();
        int l=0,r=0;
        int[] p=new int[n];

//p[i] = longest length panlindrome in original string centered there (either char or between two char if here is @)

        for(int i=0;i<n;i++){
            if(i<r){
                p[i]=Math.min(r-i,p[l+r-i]);
            }
            while(i+p[i]+1<n && i-p[i]-1 >=0 && ss.charAt(i+p[i]+1) == ss.charAt( i-p[i]-1)){
                p[i]++;
            }

            if(p[i]+i>r){
                r=i+p[i];
                l=i-p[i];
            }
        }

        return p;
    }
}
