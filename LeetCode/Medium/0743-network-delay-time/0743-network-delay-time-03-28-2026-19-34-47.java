class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] time:times){
            int s=time[0],d=time[1],t=time[2];
            graph.get(s).add(new int[]{d,t});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.add(new int[]{0,k});
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int distance = curr[0];
            int node = curr[1];
            if(distance>dist[node]){continue;}
            for(int[] neighbour:graph.get(node)){
                int next = neighbour[0];
                int weight = neighbour[1];
                if(distance+weight<dist[next]){
                    dist[next]=distance+weight;
                    minHeap.add(new int[]{dist[next],next});
                }
            }
        }
        int maxTime = 0;
        for(int i=1;i<=n;i++){
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime==Integer.MAX_VALUE?-1:maxTime;
    }
}