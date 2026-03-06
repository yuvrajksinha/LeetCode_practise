class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
        }
        int[] visit = new int[numCourses]; // 0->not visited, 1->visiting, 2->visited
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,graph,visit)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,Map<Integer,List<Integer>> graph,int[] visit){
        if(visit[node]==1){
            return false;
        }
        if(visit[node]==2){
            return true;
        }
        visit[node]=1;
        for(int neighbour:graph.get(node)){
            if(!dfs(neighbour,graph,visit)){
                return false;
            }
        }
        visit[node]=2;
        return true;
    }
}