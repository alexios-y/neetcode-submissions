class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0;
        int buy=prices[0];
        for(int p : prices){

                buy=Math.min(buy,p);
                maxP=Math.max(p-buy, maxP);
        }
        
        return maxP;
    }
}
