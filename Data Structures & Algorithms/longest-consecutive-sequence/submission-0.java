class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int res=0;
        for(int n : set){
            if(!set.contains(n-1)){
                int tmp=1;
                int head=n;
                while(set.contains(++head)){
                    tmp++;
                }
                res=Math.max(tmp,res);
            }
        }

        return res;
    }
}
