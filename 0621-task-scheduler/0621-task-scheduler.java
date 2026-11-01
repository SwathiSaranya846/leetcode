class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq=freq[25];
        int emptySlots=(maxFreq-1)*n;
        for(int i=24;i>=0;i--){
            emptySlots-=Math.min(maxFreq-1 , freq[i]);
        }
        int idle=Math.max(0,emptySlots);
        return tasks.length+idle;
        
    }
}