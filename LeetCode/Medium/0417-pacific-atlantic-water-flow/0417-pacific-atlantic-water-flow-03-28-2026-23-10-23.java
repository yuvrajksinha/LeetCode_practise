class Solution {
    private int rows,columns;
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        columns = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] isReachingPacific = new boolean[rows][columns];
        boolean[][] isReachingAtlantic = new boolean[rows][columns];
        for(int r=0;r<rows;r++){
            dfs(heights,r,0,isReachingPacific,heights[r][0]); //LEFT
            dfs(heights,r,columns-1,isReachingAtlantic,heights[r][columns-1]); //RIGHT
        }
        for(int c=0;c<columns;c++){
            dfs(heights,0,c,isReachingPacific,heights[0][c]); //TOP
            dfs(heights,rows-1,c,isReachingAtlantic,heights[rows-1][c]); //BOTTOM
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(isReachingPacific[r][c]&&isReachingAtlantic[r][c]){
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }
    public void dfs(int[][] heights,int r,int c,boolean[][] isReaching,int prevHeight){
        if(r<0||c<0||r>=rows||c>=columns||isReaching[r][c]||heights[r][c]<prevHeight){
            return;
        }
        isReaching[r][c]=true;
        for(int[] d:directions){
            dfs(heights,r+d[0],c+d[1],isReaching,heights[r][c]);
        }
    }
}