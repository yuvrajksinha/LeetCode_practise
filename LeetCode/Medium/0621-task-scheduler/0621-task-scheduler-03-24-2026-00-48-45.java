class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int task:tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                maxHeap.add(freq[i]);
            }
        }
        int time=0;
        while(!maxHeap.isEmpty()){
            int countCycle = n+1;
            List<Integer> list = new ArrayList<>();
            int taskCountPerCycle=0;
            while(countCycle>0 && !maxHeap.isEmpty()){
                int currFreq=maxHeap.poll();
                if(currFreq>1){
                    list.add(currFreq-1); //[2,2]
                }
                taskCountPerCycle++;
                countCycle--;
            }
            for(int f:list){
                maxHeap.add(f);
            }
            time+=maxHeap.isEmpty()?taskCountPerCycle:n+1;
        }
        return time;
    }
}