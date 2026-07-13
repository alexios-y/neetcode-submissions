class Solution {
    public int hammingWeight(int n) {
        int res=0;
        // for(int i=0;i<32;i++){
        //     int mask = 1 << i;
        //     if((n & mask)!=0){
        //         res++;
        //     }
        // }
        // while(n!=0){
        //     if((n & 1)!=0 ){
        //         res++;
        //     }
        //     n>>=1;
        // }
        while(n!=0){
            n=n&(n-1);
            res++;
        }
        return res;
    }
}
