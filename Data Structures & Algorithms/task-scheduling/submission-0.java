class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        for (int i : count) {
            if (i != 0)
                pq.offer(i);
        }
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!queue.isEmpty()) {
                if (time == queue.peek()[1]) {
                    int[] entry = queue.poll();
                    pq.offer(entry[0]);
                }
            }

            if (!pq.isEmpty()) {
                int c = pq.poll();
                if (--c > 0)
                    queue.offer(new int[] {c, time + n+1});
            }


        }

        return time;
    }
}
