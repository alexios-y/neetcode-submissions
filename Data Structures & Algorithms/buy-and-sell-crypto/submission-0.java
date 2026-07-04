class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0;
        int buy=101;
        for(int p : prices){
            if(p<buy)
            {
                buy=p;
            } else{
                maxP=Math.max(p-buy, maxP);
            }
        }
        
        return maxP;
    }
}
