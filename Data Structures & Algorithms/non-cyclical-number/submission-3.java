class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        // while(true){
        //     int tmp=n;
        //     int sum=0;
        //     while(tmp>0){
        //         int digit=tmp%10;
        //         sum=sum+digit*digit;
        //         tmp=tmp/10;
        //     }
        //     if(sum==1){
        //         return true;
        //     }
        //     if(seen.contains(sum))
        //     {
        //         return false;
        //     }
        //     seen.add(sum);
        //     n=sum;
        // }
        int slow=n;
        int fast=cal(n);
        while(fast!=slow){
            if(fast==1)
                return true;
            slow=cal(slow);
            fast=cal(cal(fast));
        }
        return fast==1;

    }

    int cal(int n){
                    int tmp=n;
            int sum=0;
            while(tmp>0){
                int digit=tmp%10;
                sum=sum+digit*digit;
                tmp=tmp/10;
            }
            return sum;
    }
}
