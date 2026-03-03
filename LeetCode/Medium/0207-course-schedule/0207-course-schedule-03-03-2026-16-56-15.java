class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] p:prerequisites){ //as {0,1} means we must have 1 for 0 so 1 has neighbour 0 confirm
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
        if(visiting[node]){ //we visit the same node that we are searching cycle in
            return false;   //so a cycle is present so return false
        }
        if(visited[node]){ //we visit a node that is visited and checked to have no cycle 
            return true;   //so safe to go on this
        }
        visiting[node]=true;
        for(int neighbour:graph.get(node)){
            if(!dfs(neighbour,graph,visiting,visited)){ //if any loop found in neighbours
                return false;
            }
        }
        visiting[node]=false;
        visited[node]=true;
        return true; //as no loop found in ALL neighbours 
    }
}