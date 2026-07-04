class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //k -> freq
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer>[] freq=new List[nums.length];
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for(int i=0;i<freq.length;i++){
            freq[i]=new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            freq[entry.getValue()-1].add(entry.getKey());
        }

        int[] res=new int[k];
        int index=0;
        for(int i=freq.length-1; i>=0;i--){
            List<Integer> tmp=freq[i];
            for(int t:freq[i]){
                if(index==k)
                    return res;
                res[index++]=t;    
            }    
        }

        return res;
    }
}
