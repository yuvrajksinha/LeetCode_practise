class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,graph,visiting,visited)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,Map<Integer,List<Integer>> graph,boolean[] visiting,boolean[] visited){
        if(visiting[node]){
            return false;
        }
        if(visited[node]){
            return true;
        }
        visiting[node]=true;
        for(int neighbour:graph.get(node)){
            if(!dfs(neighbour,graph,visiting,visited)){
                return false;
            }
        }
        visiting[node]=false;
        visited[node]=true;
        return true;
    }
}