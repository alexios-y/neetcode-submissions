class Solution {
    public int maxProfit(int[] prices) {
        int buy, maxp;
        buy=Integer.MAX_VALUE;
        maxp=0;

        for(int p : prices){
            if(p<=buy){
                buy=p;
            } else{
                maxp=Math.max(p-buy, maxp);
            }
        }

        return maxp;
    }
}
