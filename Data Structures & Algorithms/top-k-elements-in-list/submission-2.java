class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer, Integer> freq=new HashMap<>();
        for(int n : nums){
            freq.merge(n, 1, Integer::sum);
        }

        // PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        // for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
        //     pq.offer(new int[]{entry.getKey(),entry.getValue()});
        //     if(pq.size()>k){
        //         pq.poll();
        //     }
        // }
        // int idx=0;
        // while(!pq.isEmpty()){
        //     res[idx++]=pq.poll()[0];
        // }

        List<Integer>[] list=new List[nums.length+1];
        for(int i=0;i<list.length;i++){
            list[i]=new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            list[entry.getValue()].add(entry.getKey());
        }

        int cnt=0;
        for(int i=list.length-1; i>=0;i--){
            for(int j=0;j<list[i].size() && cnt<k;j++){
                res[cnt++]=list[i].get(j);
            }
        }

        return res;
    }
}
