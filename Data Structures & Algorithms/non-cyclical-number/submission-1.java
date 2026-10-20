class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(true){
            int tmp=n;
            int sum=0;
            while(tmp>0){
                int digit=tmp%10;
                sum=sum+digit*digit;
                tmp=tmp/10;
            }
            if(sum==1){
                return true;
            }
            if(seen.contains(sum))
            {
                return false;
            }
            seen.add(sum);
            n=sum;
        }
    }
}
