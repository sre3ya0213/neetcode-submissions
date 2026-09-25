class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char c : tasks) {
            counts[c-'A']++;
        }
        Arrays.sort(counts);

        int idle = n*(counts[25]-1);

        for(int i=24;i>=0;i--) {
            idle = idle - Math.min(counts[i],counts[25]-1); 
        }

        return Math.max(0,idle) + tasks.length;
   
    }
}
