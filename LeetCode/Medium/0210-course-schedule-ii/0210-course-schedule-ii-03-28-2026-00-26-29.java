class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,graph,visiting,visited,stack)){
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=stack.pop();
        }
        return result;
    }
    public boolean dfs(int node,Map<Integer,List<Integer>> graph,boolean[] visiting,boolean[] visited,Deque<Integer> stack){
        if(visiting[node]){
            return false;
        }
        if(visited[node]){
            return true;
        }
        visiting[node]=true;
        for(int neighbour:graph.get(node)){
            if(!dfs(neighbour,graph,visiting,visited,stack)){
                return false;
            }
        }
        visiting[node]=false;
        visited[node]=true;
        stack.push(node); // at last add to stack so first added will be 3 as its the last node with no connections, then 1, then 2, then at last 0 will be cleared and will be the last added so for the right order we pop it(hence the stack is useful)
        return true;
    }
}