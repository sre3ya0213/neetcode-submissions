class Solution {


    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for(char c : tasks) {
            count[c-'A']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(count[b-'A'],count[a-'A']));

        for(int i=0;i<26;i++) {
            if(count[i] > 0) {
                maxHeap.offer((char)(i+'A'));
            }
        }
        
        int time = 0;
        while(!maxHeap.isEmpty()) {
            int k = n+1;
            List<Character> used = new ArrayList<>();
            while(!maxHeap.isEmpty() && k > 0) {
                Character task = maxHeap.poll();
                count[task-'A']--;
                if(count[task-'A'] > 0) {
                    used.add(task);
                }
                time++;
                k--;
            }
            for(char c : used) {
                maxHeap.offer(c);
            }
            if(!maxHeap.isEmpty()) {
                time+=k;
            }
        }

        return time;
  
    }
}
