class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            // int last=n & 1;
            // n>>=1;
            // res<<=1;
            // res=res|last;
            int bit=(n>>>i) &1;
            res+=(bit << (31-i));
        }

        return res;
    }
}
