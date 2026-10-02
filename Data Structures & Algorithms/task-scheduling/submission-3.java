class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for(char task : tasks) {
            count[task-'A']++;
        }

        int max = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;

        for(int c : count) {
            if(c == max) {
                maxCount++;
            }
        }

        return Math.max((max-1)*(n+1)+maxCount,tasks.length);
        

        
    }
}
