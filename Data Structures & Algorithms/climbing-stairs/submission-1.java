class Solution {
    public int climbStairs(int n) {
        if(n==1)
        return 1;

        int[] steps=new int[n];
        int pre1=1;
        int pre2=2;
        for(int i=2;i<n;i++){
            int tmp=pre1+pre2;
            pre1=pre2;
            pre2=tmp;
        }

        return pre2;
    }
}
